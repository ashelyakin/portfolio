package com.ashelyakin.portfolio.ui.projects.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashelyakin.portfolio.ui.projects.Project
import com.ashelyakin.portfolio.ui.projects.detail.ProjectCard
import com.ashelyakin.portfolio.ui.projects.sampleProjects

/**
 * Карточки проектов (раздел 3.4) как элементы общей сетки страницы —
 * встраивается в [LazyGridScope] хост-страницы вместо собственного
 * [LazyVerticalGrid], чтобы не создавать вложенный скролл.
 */
fun LazyGridScope.projectsGrid(
    projects: List<Project>,
    onProjectClick: (Project) -> Unit = {},
) {
    items(projects, key = { it.id }) { project ->
        ProjectCard(project = project, onClick = onProjectClick)
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun ProjectsGridPreview() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 340.dp),
        contentPadding = PaddingValues(horizontal = 48.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp),
    ) {
        projectsGrid(projects = sampleProjects)
    }
}
