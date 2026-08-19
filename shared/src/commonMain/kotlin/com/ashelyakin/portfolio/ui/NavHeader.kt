package com.ashelyakin.portfolio.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import androidx.compose.ui.tooling.preview.Preview
import com.ashelyakin.portfolio.ui.home.OutlinePillButton

/**
 * Навигационный хедер (п.2.1/3.1 "Навигация") — используется как на главной,
 * так и на страницах проектов.
 * Слева — логотип-монограмма, в центре/справа — пункт меню "Projects",
 * крайне справа — переключатель темы и кнопка "Let's talk".
 */
@Composable
fun NavHeader(
    currentScreen: Screen,
    onLogoClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onProjectsClick: () -> Unit = {},
    onLetsTalkClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(PortfolioColors.Background)
            .padding(horizontal = 48.dp, vertical = 12.dp)
    ) {
        Text(
            text = "AS",
            color = PortfolioColors.TextPrimary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable(onClick = onLogoClick)
        )

        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Главная",
                color = if (currentScreen == Screen.HOME) PortfolioColors.TextPrimary else PortfolioColors.TextSecondary,
                fontSize = 15.sp,
                fontWeight = if (currentScreen == Screen.HOME) FontWeight.Bold else FontWeight.Medium,
                modifier = Modifier.clickable(onClick = onHomeClick).padding(vertical = 12.dp, horizontal = 12.dp)
            )

            val isProjectsScreen = currentScreen == Screen.PROJECTS_LIST || currentScreen == Screen.PROJECT_DETAILS
            Text(
                text = "Проекты",
                color = if (isProjectsScreen) PortfolioColors.TextPrimary else PortfolioColors.TextSecondary,
                fontSize = 15.sp,
                fontWeight = if (isProjectsScreen) FontWeight.Bold else FontWeight.Medium,
                modifier = Modifier.clickable(onClick = onProjectsClick).padding(vertical = 12.dp, horizontal = 12.dp)
            )
        }
    }
}

@Preview
@Composable
private fun NavHeaderPreview() {
    NavHeader(currentScreen = Screen.HOME)
}
