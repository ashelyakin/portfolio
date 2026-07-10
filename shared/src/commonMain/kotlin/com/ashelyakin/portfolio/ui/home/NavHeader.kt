package com.ashelyakin.portfolio.ui.home

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

/**
 * Навигационный хедер (п.2.1 "Навигация").
 * Слева — логотип-монограмма, в центре/справа — пункт меню "Projects",
 * крайне справа — переключатель темы и кнопка "Let's talk".
 */
@Composable
fun NavHeader(
    logoLetter: String = "AS",
    isProjectsActive: Boolean = false,
    onProjectsClick: () -> Unit = {},
    onThemeToggleClick: () -> Unit = {},
    onLetsTalkClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(PortfolioColors.Background)
            .padding(horizontal = 48.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Логотип-монограмма
        Text(
            text = logoLetter,
            color = PortfolioColors.TextPrimary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        // Пункт меню Projects
        Text(
            text = "Projects",
            color = if (isProjectsActive) PortfolioColors.TextPrimary else PortfolioColors.TextSecondary,
            fontSize = 15.sp,
            fontWeight = if (isProjectsActive) FontWeight.Bold else FontWeight.Medium,
            modifier = Modifier.clickable(onClick = onProjectsClick)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Переключатель темы — простая круглая иконка
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(PortfolioColors.Surface)
                    .clickable(onClick = onThemeToggleClick),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "◐", color = PortfolioColors.TextPrimary, fontSize = 16.sp)
            }

            OutlinePillButton(
                text = "Let's talk",
                onClick = onLetsTalkClick,
                showArrow = false
            )
        }
    }
}

@Preview
@Composable
private fun NavHeaderPreview() {
    NavHeader(isProjectsActive = false)
}
