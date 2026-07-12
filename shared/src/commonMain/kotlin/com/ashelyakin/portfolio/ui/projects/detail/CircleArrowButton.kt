package com.ashelyakin.portfolio.ui.projects.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Круглая кнопка со стрелкой (диагональная ↗ на карточках проектов,
 * либо ↑ в футере для скролла наверх — передаётся через [icon]).
 */
@Composable
fun CircleArrowButton(
    modifier: Modifier = Modifier,
    icon: String = "↗",
    size: Dp = 40.dp,
    background: Color = PortfolioColors.AccentDark,
    contentColor: Color = Color.White,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .size(size)
            .background(background, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = icon, color = contentColor, fontSize = 16.sp)
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun CircleArrowButtonPreview() {
    CircleArrowButton()
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun CircleArrowButtonUpPreview() {
    CircleArrowButton(icon = "↑", background = PortfolioColors.Surface, contentColor = PortfolioColors.TextPrimary)
}
