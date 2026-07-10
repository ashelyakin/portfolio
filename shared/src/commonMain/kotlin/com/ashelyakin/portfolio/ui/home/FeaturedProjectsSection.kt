package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview

private val defaultProjects = listOf(
    ProjectCardData(
        label = "FITTRACK",
        title = "Fitness Tracking App",
        technologies = listOf("Kotlin", "Room", "MVVM", "Google Fit")
    ),
    ProjectCardData(
        label = "SHOPLY",
        title = "E-commerce Marketplace",
        technologies = listOf("Kotlin", "Compose", "Ktor", "Coroutines")
    ),
    ProjectCardData(
        label = "NOTETIDY",
        title = "Notes & Tasks Manager",
        technologies = listOf("Kotlin", "SQLDelight", "WorkManager")
    )
)

/**
 * Секция с кратким списком проектов на главной (п.2.4 "Блок 'Проекты'").
 * Заголовок с лейблом и кнопкой "View all projects", ниже сетка карточек в 3 колонки.
 */
@Composable
fun FeaturedProjectsSection(
    projects: List<ProjectCardData> = defaultProjects,
    onViewAllClick: () -> Unit = {},
    onProjectClick: (ProjectCardData) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 48.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Заголовок блока
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(
                    text = "FEATURED PROJECTS",
                    style = PortfolioTypography.label,
                    color = PortfolioColors.TextSecondary
                )
                Row {
                    Text(
                        text = "APPS THAT ",
                        style = PortfolioTypography.h2,
                        color = PortfolioColors.TextPrimary
                    )
                    Text(
                        text = "MAKE",
                        style = PortfolioTypography.h2,
                        color = PortfolioColors.TextSecondary
                    )
                }
                Text(
                    text = "AN IMPACT",
                    style = PortfolioTypography.h2,
                    color = PortfolioColors.TextPrimary
                )
            }

            OutlinePillButton(text = "View all projects", onClick = onViewAllClick)
        }

        // Сетка карточек — 3 колонки в ряд (десктоп)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            projects.forEach { project ->
                ProjectCard(
                    data = project,
                    onClick = { onProjectClick(project) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun FeaturedProjectsSectionPreview() {
    FeaturedProjectsSection()
}
