package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashelyakin.portfolio.ui.projects.Project
import com.ashelyakin.portfolio.ui.projects.sampleProjects
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography

/**
 * Секция с кратким списком проектов на главной (п.2.4 "Блок 'Проекты'").
 * Заголовок с лейблом и кнопкой "View all projects", ниже сетка карточек в 3 колонки.
 */
@Composable
fun FeaturedProjectsSection(
    projects: List<Project> = sampleProjects,
    onViewAllClick: () -> Unit = {},
    onProjectClick: (Project) -> Unit = {},
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

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(items = projects, key = { it }) { project ->
                ProjectCard(
                    project = project,
                    onClick = { onProjectClick(project) },
                    modifier = Modifier.width(540.dp),
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
