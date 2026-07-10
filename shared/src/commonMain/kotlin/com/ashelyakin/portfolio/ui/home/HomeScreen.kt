package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import androidx.compose.ui.tooling.preview.Preview

/**
 * Главная страница (Home) портфолио — сборка всех секций по разделу 2 спецификации:
 * навигация, hero, статистика, проекты, "обо мне", технологии, CTA-контакты, футер.
 */
@Composable
fun HomeScreen(
    onProjectsClick: () -> Unit = {},
    onViewAllProjectsClick: () -> Unit = {},
    onProjectClick: (ProjectCardData) -> Unit = {},
    onLetsTalkClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PortfolioColors.Background)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(64.dp)
    ) {
        NavHeader(onProjectsClick = onProjectsClick, onLetsTalkClick = onLetsTalkClick)

        HeroSection(onLetsTalkClick = onLetsTalkClick)

        StatsSection()

        AboutSection()

        TechStackSection()

        FeaturedProjectsSection(
            onViewAllClick = onViewAllProjectsClick,
            onProjectClick = onProjectClick
        )

        SiteFooter()
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
