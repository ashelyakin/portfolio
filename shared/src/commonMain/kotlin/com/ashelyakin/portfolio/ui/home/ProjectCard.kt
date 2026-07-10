package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview

/** Данные для карточки проекта. */
data class ProjectCardData(
    val label: String,
    val title: String,
    val technologies: List<String>,
    val imagePlaceholderColor: Color = PortfolioColors.ImagePlaceholder
)

/**
 * Карточка проекта (п.2.4 "Блок Проекты" — описание карточки).
 * Верх — изображение приложения, низ — тёмная подложка с названием, лейблом,
 * технологиями и круглой кнопкой-стрелкой.
 */
@Composable
fun ProjectCard(
    data: ProjectCardData,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
    ) {
        // Верх — изображение/скриншот приложения
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(data.imagePlaceholderColor)
        )

        // Низ — тёмная подложка с описанием
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PortfolioColors.AccentDark)
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = data.label,
                    style = PortfolioTypography.label,
                    color = PortfolioColors.TextSecondary
                )
                Text(
                    text = data.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.Surface,
                    modifier = Modifier.padding(top = 6.dp, bottom = 10.dp)
                )
                Text(
                    text = data.technologies.joinToString(" • ") { it.uppercase() },
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
            data = ProjectCardData(
                label = "FITTRACK",
                title = "Fitness Tracking App",
                technologies = listOf("Kotlin", "Room", "MVVM", "Google Fit")
            )
        )
    }
}
