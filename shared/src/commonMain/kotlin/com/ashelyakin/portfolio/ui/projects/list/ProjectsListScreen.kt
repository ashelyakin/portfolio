package com.ashelyakin.portfolio.ui.projects.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ashelyakin.portfolio.ui.Footer
import com.ashelyakin.portfolio.ui.NavHeader
import com.ashelyakin.portfolio.ui.Screen
import com.ashelyakin.portfolio.ui.projects.ProjectCategory
import com.ashelyakin.portfolio.ui.projects.sampleProjects
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Страница "Все проекты" (раздел 3 спека): header, заголовок страницы,
 * фильтры категорий и сетка карточек проектов, футер — всё как элементы
 * одной [LazyVerticalGrid], чтобы избежать вложенного скролла
 * (LazyVerticalGrid внутри Column(Modifier.verticalScroll())).
 */
@Composable
fun ProjectsListScreen(
    projects: List<com.ashelyakin.portfolio.ui.projects.Project> = sampleProjects,
    modifier: Modifier = Modifier,
    onProjectClick: (com.ashelyakin.portfolio.ui.projects.Project) -> Unit = {},
    onHomeClick: () -> Unit = {},
    onLogoClick: () -> Unit = {},
    onLetsTalkClick: () -> Unit = {},
) {
    var selectedCategory by remember { mutableStateOf(ProjectCategory.ALL) }
    val categories = remember(projects) {
        listOf(ProjectCategory.ALL) + projects.map { it.category }.distinct()
    }
    val filteredProjects = remember(projects, selectedCategory) {
        if (selectedCategory == ProjectCategory.ALL) projects else projects.filter { it.category == selectedCategory }
    }

    Column() {
        NavHeader(
            currentScreen = Screen.PROJECTS_LIST,
            onHomeClick = onHomeClick,
            onLogoClick = onLogoClick,
            onLetsTalkClick = onLetsTalkClick,
        )

        Surface(color = PortfolioColors.Background, modifier = modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 340.dp),
                contentPadding = PaddingValues(horizontal = 48.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalArrangement = Arrangement.spacedBy(48.dp),
            ) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    PageTitleHeader(
                        title = "Projects",
                        description = "Все проекты — отражение моего подхода к разработке: " +
                                "чистый код и продуманный UX",
                        modifier = Modifier.horizontalBleed(48.dp),
                    )
                }

                item(span = { GridItemSpan(maxLineSpan) }) {
                    CategoryTabs(
                        categories = categories,
                        selected = selectedCategory,
                        onSelect = { selectedCategory = it },
                    )
                }

                projectsGrid(
                    projects = filteredProjects,
                    onProjectClick = onProjectClick,
                )
            }
        }

        Footer()
    }
}

/**
 * Компенсирует горизонтальный [contentPadding] хост-сетки, чтобы full-width
 * секции (header/footer) выходили вплотную к краю экрана, как и до переноса
 * страницы в единую [LazyVerticalGrid].
 */
private fun Modifier.horizontalBleed(amount: Dp): Modifier = layout { measurable, constraints ->
    val bleedPx = (amount * 2).roundToPx()
    val placeable = measurable.measure(
        constraints.copy(
            minWidth = constraints.minWidth + bleedPx,
            maxWidth = constraints.maxWidth + bleedPx,
        )
    )
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(-amount.roundToPx(), 0)
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun ProjectsListScreenPreview() {
    ProjectsListScreen()
}
