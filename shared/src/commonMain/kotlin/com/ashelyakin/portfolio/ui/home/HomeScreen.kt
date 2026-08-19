package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashelyakin.portfolio.ui.NavHeader
import com.ashelyakin.portfolio.ui.Screen
import com.ashelyakin.portfolio.ui.projects.Project
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

/**
 * Главная страница (Home) портфолио — сборка всех секций по разделу 2 спецификации:
 * навигация, hero, статистика, проекты, "обо мне", технологии, CTA-контакты, футер.
 */
@Composable
fun HomeScreen(
    onProjectsClick: () -> Unit = {},
    onViewAllProjectsClick: () -> Unit = {},
    onProjectClick: (Project) -> Unit = {},
    onLetsTalkClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    // Y-смещение секции проектов внутри контента скролла
    var projectsOffset by remember { mutableStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PortfolioColors.Background)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(64.dp)
    ) {
        NavHeader(
            currentScreen = Screen.HOME,
            onProjectsClick = onProjectsClick,
            onLetsTalkClick = onLetsTalkClick
        )

        HeroSection(
            onLetsTalkClick = onLetsTalkClick,
            onViewWorkClick = {
                scope.launch {
                    scrollState.animateScrollTo(projectsOffset.roundToInt())
                }
            }
        )

        StatsSection()
        AboutSection()
        TechStackSection()

        FeaturedProjectsSection(
            modifier = Modifier.onGloballyPositioned { coords ->
                projectsOffset = coords.positionInParent().y
            },
            onViewAllClick = onViewAllProjectsClick,
            onProjectClick = onProjectClick
        )
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
