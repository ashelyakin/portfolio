package com.ashelyakin.portfolio.ui.projects.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashelyakin.portfolio.ui.ImageResourceCache
import com.ashelyakin.portfolio.ui.projects.sampleProjects
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Горизонтальная лента изображений проекта средней высоты.
 *
 * [imagePaths] — список путей к файлам внутри composeResources.
 * Загрузка идёт через [ImageResourceCache]: уже показанные картинки
 * не декодируются повторно при выходе слайда из видимой области
 * и возврате обратно во время скролла. Если файл по указанному пути
 * отсутствует в assets — слайд остаётся плашкой-заглушкой, без падения.
 *
 * Ширина каждого слайда подстраивается под реальное соотношение сторон
 * картинки (высота ленты фиксирована), поэтому вертикальные скриншоты
 * (например 1242x2692) показываются целиком, без обрезки сверху/снизу.
 */
@Composable
fun ProjectHero(
    imagePaths: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.height(360.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items = imagePaths, key = { it }) { path ->
            ProjectHeroImage(path = path)
        }
    }
}

@Composable
private fun ProjectHeroImage(path: String) {
    var bitmap by remember(path) {
        mutableStateOf(ImageResourceCache.getCached(path))
    }

    LaunchedEffect(path) {
        if (bitmap == null && !ImageResourceCache.hasFailed(path)) {
            bitmap = ImageResourceCache.load(path)
        }
    }

    val loaded = bitmap
    // Пока картинка не загружена — используем placeholder-пропорцию 16:10,
    // после загрузки ширина слайда подстраивается под реальную пропорцию картинки.
    val aspectRatio = loaded
        ?.let { it.width.toFloat() / it.height.toFloat() }
        ?: (16f / 10f)

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(aspectRatio)
            .clip(RoundedCornerShape(12.dp))
            .background(PortfolioColors.Divider),
    ) {
        if (loaded != null) {
            Image(
                bitmap = loaded,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit,
            )
        }
        // пока bitmap == null (грузится или файл отсутствует) — просто фон-плашка
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun ProjectHeroPreview() {
    ProjectHero(
        imagePaths = sampleProjects.first().images,
    )
}