package com.ashelyakin.portfolio.ui.projects.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.ImageResourceCache
import com.ashelyakin.portfolio.ui.projects.Project
import com.ashelyakin.portfolio.ui.projects.sampleProjects
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Карточка проекта на странице "Все проекты" (раздел 3.4):
 * изображение с лёгким скруглением, иконка-стрелка в правом верхнем углу,
 * название, короткое описание и теги-пилюли с обводкой под изображением.
 *
 * Изображение — первая картинка из [Project.images], загружается через
 * [ImageResourceCache], чтобы не декодировать её заново при каждом
 * входе карточки в видимую область во время скролла. Если файл
 * отсутствует в assets или список images пуст — остаётся
 * плашка-заглушка цвета [PortfolioColors.Divider], без падения приложения.
 *
 * Контейнер держит фиксированную пропорцию 4:3 (чтобы сетка карточек была
 * ровной), поэтому вертикальные скриншоты вписываются целиком через
 * ContentScale.Fit — сверху/снизу может остаться фон-плашка, но ничего
 * не обрезается.
 */
@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier,
    onClick: (Project) -> Unit = {},
) {
    val firstImagePath = project.images.firstOrNull()

    var bitmap by remember(firstImagePath) {
        mutableStateOf(firstImagePath?.let { ImageResourceCache.getCached(it) })
    }

    LaunchedEffect(firstImagePath) {
        if (firstImagePath != null &&
            bitmap == null &&
            !ImageResourceCache.hasFailed(firstImagePath)
        ) {
            bitmap = ImageResourceCache.load(firstImagePath)
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(project) },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
                .clip(RoundedCornerShape(16.dp))
                .background(PortfolioColors.Divider),
        ) {
            val loaded = bitmap
            if (loaded != null) {
                Image(
                    bitmap = loaded,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit,
                )
            }

            CircleArrowButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp),
                size = 36.dp,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = project.title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = PortfolioColors.TextPrimary,
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = project.shortDescription,
            fontSize = 14.sp,
            color = PortfolioColors.TextSecondary,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            project.tags.forEachIndexed { index, tag ->
                TagChip(text = tag)
                if (index != project.tags.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun ProjectCardPreview() {
    ProjectCard(project = sampleProjects.first())
}