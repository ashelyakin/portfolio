package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.ImageResourceCache
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview
import com.ashelyakin.portfolio.ui.projects.Project
import com.ashelyakin.portfolio.ui.projects.sampleProjects

/**
 * Карточка проекта (п.2.4 "Блок Проекты" — описание карточки).
 * Верх — изображение приложения, низ — тёмная подложка с названием, лейблом,
 * категорией и круглой кнопкой-стрелкой.
 */
@Composable
fun ProjectCard(
    project: Project,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
    ) {
        // Верх — изображение/скриншот приложения
        val imagePath = project.cover
        if (!imagePath.isNullOrEmpty()) {
            ProjectCardImage(path = imagePath, backgroundColor = project.coverBackgroundColor)
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(project.coverBackgroundColor)
            )
        }

        // Низ — тёмная подложка с описанием
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.AccentDark)
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = project.category,
                    style = PortfolioTypography.label,
                    color = PortfolioColors.TextSecondary
                )
                Text(
                    text = project.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.Surface,
                    modifier = Modifier.padding(top = 6.dp, bottom = 10.dp)
                )
                Text(
                    text = project.shortDescription,
                    style = PortfolioTypography.caption,
                    color = PortfolioColors.TextSecondary
                )
            }

            CircleArrowButton(
                direction = ArrowDirection.UpRight,
                backgroundColor = PortfolioColors.Surface,
                contentColor = PortfolioColors.AccentDark,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
private fun ProjectCardImage(path: String, backgroundColor: Color) {
    var bitmap by remember(path) {
        mutableStateOf(ImageResourceCache.getCached(path))
    }

    LaunchedEffect(path) {
        if (bitmap == null && !ImageResourceCache.hasFailed(path)) {
            bitmap = ImageResourceCache.load(path)
        }
    }

    val loaded = bitmap

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .background(backgroundColor),
    ) {
        if (loaded != null) {
            Image(
                bitmap = loaded,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Inside,
            )
        }
        // пока bitmap == null (грузится или файл отсутствует) — просто фон-плашка
    }
}

@Preview
@Composable
private fun ProjectCardPreview() {
    Box(
        modifier = Modifier
            .width(320.dp)
            .background(PortfolioColors.Background)
            .padding(16.dp)
    ) {
        ProjectCard(
            project = sampleProjects.first()
        )
    }
}