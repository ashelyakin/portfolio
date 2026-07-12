package com.ashelyakin.portfolio.ui.projects.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.Footer
import com.ashelyakin.portfolio.ui.NavHeader
import com.ashelyakin.portfolio.ui.projects.Project
import com.ashelyakin.portfolio.ui.projects.sampleProjects
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Страница отдельного проекта: header, ссылка "назад к списку",
 * крупное изображение, название и год, полное описание, теги/стек.
 */
@Composable
fun ProjectDetailScreen(
    project: Project,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onLetsTalkClick: () -> Unit = {},
) {
    Surface(color = PortfolioColors.Background, modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            NavHeader(isProjectsActive = true, onLetsTalkClick = onLetsTalkClick)

            Column(modifier = Modifier.padding(horizontal = 48.dp, vertical = 32.dp)) {
                Text(
                    text = "← All projects",
                    color = PortfolioColors.TextSecondary,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { onBackClick() },
                )

                Spacer(modifier = Modifier.height(24.dp))

                ProjectHero(imagePaths = project.images, modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(32.dp))

                SectionLabel(text = project.category)

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = project.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 48.sp,
                        color = PortfolioColors.TextPrimary,
                    )
                    Text(
                        text = project.year,
                        fontSize = 16.sp,
                        color = PortfolioColors.TextSecondary,
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = project.fullDescription,
                    fontSize = 17.sp,
                    color = PortfolioColors.TextPrimary,
                )

                Spacer(modifier = Modifier.height(24.dp))

                SectionLabel(text = "Technologies")

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    project.tags.forEachIndexed { index, tag ->
                        TagChip(text = tag)
                        if (index != project.tags.lastIndex) {
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                OutlinePillButton(text = "Back to all projects →", onClick = onBackClick)
            }

            Footer()
        }
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun ProjectDetailScreenPreview() {
    ProjectDetailScreen(project = sampleProjects.first())
}
