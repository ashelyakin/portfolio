package com.ashelyakin.portfolio.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Цветовая палитра портфолио.
 * Значения взяты из раздела "4. Цветовая палитра" спецификации дизайна.
 */
object PortfolioColors {
    /** Фон основной (#F5F5F3) */
    val Background = Color(0xFFF5F5F3)

    /** Фон карточек/белый (#FFFFFF) */
    val Surface = Color(0xFFFFFFFF)

    /** Текст основной (#111111) */
    val TextPrimary = Color(0xFF111111)

    /** Текст второстепенный (#8A8A8A) */
    val TextSecondary = Color(0xFF8A8A8A)

    /** Акцент тёмный — кнопки, подложки (#000000) */
    val AccentDark = Color(0xFF000000)

    /** Обводки/разделители (#E5E5E5) */
    val Divider = Color(0xFFE5E5E5)

    /** Индикатор "доступен для работы" (#4CAF50) */
    val Available = Color(0xFF4CAF50)

    /** Заглушка для мест под изображения/фото (нейтральный серый) */
    val ImagePlaceholder = Color(0xFFD9D9D6)

    /** Фон для обложек проектов Subaru */
    val SubaruBackground = Color(0xFF000919)
}
