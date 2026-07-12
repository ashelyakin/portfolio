package com.ashelyakin.portfolio

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.savedstate.read
import com.ashelyakin.portfolio.ui.home.HomeScreen
import com.ashelyakin.portfolio.ui.projects.detail.ProjectDetailScreen
import com.ashelyakin.portfolio.ui.projects.list.ProjectsListScreen
import com.ashelyakin.portfolio.ui.projects.sampleProjects

private const val ROUTE_HOME = "home"
private const val ROUTE_PROJECTS = "projects"
private const val ROUTE_PROJECT_DETAIL = "projects/{projectId}"

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = ROUTE_HOME) {
            composable(ROUTE_HOME) {
                HomeScreen(
                    onProjectsClick = { navController.navigate(ROUTE_PROJECTS) },
                    onViewAllProjectsClick = { navController.navigate(ROUTE_PROJECTS) },
                )
            }

            composable(ROUTE_PROJECTS) {
                ProjectsListScreen(
                    onProjectClick = { project ->
                        navController.navigate("$ROUTE_PROJECTS/${project.id}")
                    },
                )
            }

            composable(
                route = ROUTE_PROJECT_DETAIL,
                arguments = listOf(navArgument("projectId") { type = NavType.StringType }),
            ) { backStackEntry ->
                val projectId = backStackEntry.arguments?.read { getStringOrNull("projectId") }
                val project = sampleProjects.first { it.id == projectId }

                ProjectDetailScreen(
                    project = project,
                    onBackClick = { navController.popBackStack() },
                )
            }
        }
    }
}
