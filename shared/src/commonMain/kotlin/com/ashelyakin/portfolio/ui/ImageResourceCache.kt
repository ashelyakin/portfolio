package com.ashelyakin.portfolio.ui

import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.decodeToImageBitmap
import portfolio.shared.generated.resources.Res

/**
 * Простой in-memory кэш декодированных изображений проектов.
 *
 * Без него каждая карточка/слайд в Lazy-списке при выходе из видимой
 * области и возврате обратно заново читает байты файла и декодирует
 * битмап — это дорогая операция и именно она вызывает фризы при скролле.
 *
 * Кэш также запоминает пути, для которых чтение/декодирование не
 * удалось (например файл отсутствует в assets), чтобы не пытаться
 * загрузить их повторно и не ронять приложение исключением.
 */
@OptIn(ExperimentalResourceApi::class)
object ImageResourceCache {
    private val cache = mutableMapOf<String, ImageBitmap>()
    private val failed = mutableSetOf<String>()

    /** Синхронно вернуть уже загруженный битмап, если он есть в кэше. */
    fun getCached(path: String): ImageBitmap? = cache[path]

    /** Пытались ли уже загрузить этот путь и получили ошибку. */
    fun hasFailed(path: String): Boolean = path in failed

    /**
     * Загрузить и задекодировать изображение по пути внутри composeResources.
     * Возвращает null, если файл отсутствует или не удалось декодировать —
     * без выброса исключения наружу.
     */
    suspend fun load(path: String): ImageBitmap? {
        cache[path]?.let { return it }
        if (path in failed) return null

        return try {
            val bytes = Res.readBytes(path)
            val bitmap = bytes.decodeToImageBitmap()
            cache[path] = bitmap
            bitmap
        } catch (e: Throwable) {
            failed += path
            null
        }
    }
}