package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import androidx.compose.ui.tooling.preview.Preview

/** Направление стрелки для [CircleArrowButton]. */
enum class ArrowDirection { UpRight, Up }

/**
 * Основной CTA — чёрная пилюля с белым текстом.
 * См. п.1 "Общий стиль" — "Основной CTA".
 */
@Composable
fun PrimaryPillButton(
    text: String,
    onClick: () -> Unit = {},
    showArrow: Boolean = true,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(PortfolioColors.AccentDark)
            .clickable(onClick = onClick)
            .padding(horizontal = 28.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, color = PortfolioColors.White, fontSize = 15.sp, fontWeight = FontWeight.Medium)
        if (showArrow) {
            Text(text = "  →", color = PortfolioColors.White, fontSize = 15.sp, fontWeight = FontWeight.Medium)
        }
    }
}

/**
 * Второстепенный CTA — пилюля с обводкой, прозрачный фон.
 * См. п.1 "Общий стиль" — "кнопка-пилюля с обводкой".
 */
@Composable
fun OutlinePillButton(
    text: String,
    onClick: () -> Unit = {},
    showArrow: Boolean = true,
    textColor: Color = PortfolioColors.TextPrimary,
    borderColor: Color = PortfolioColors.TextPrimary,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(50))
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, color = textColor, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        if (showArrow) {
            Text(text = "  →", color = textColor, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
    }
}

/**
 * Текстовая ссылка с подчёркиванием и стрелкой.
 * См. п.1 "Общий стиль" — "Второстепенный CTA — текстовая ссылка".
 */
@Composable
fun UnderlineArrowLink(
    text: String,
    onClick: () -> Unit = {},
    color: Color = PortfolioColors.TextPrimary,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = color,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline
        )
    }
}

/**
 * Круглая кнопка со стрелкой (↗ или ↑).
 * Используется на карточках проектов и в футере ("наверх").
 */
@Composable
fun CircleArrowButton(
    direction: ArrowDirection = ArrowDirection.UpRight,
    backgroundColor: Color = PortfolioColors.AccentDark,
    contentColor: Color = PortfolioColors.White,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val glyph = if (direction == ArrowDirection.UpRight) "↗" else "↑"
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(backgroundColor, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(text = glyph, color = contentColor, fontSize = 16.sp)
    }
}

@Preview
@Composable
private fun PrimaryPillButtonPreview() {
    Box(modifier = Modifier.background(PortfolioColors.Background).padding(24.dp)) {
        PrimaryPillButton(text = "View my work")
    }
}

@Preview
@Composable
private fun OutlinePillButtonPreview() {
    Box(modifier = Modifier.background(PortfolioColors.Background).padding(24.dp)) {
        OutlinePillButton(text = "View all projects")
    }
}

@Preview
@Composable
private fun UnderlineArrowLinkPreview() {
    Box(modifier = Modifier.background(PortfolioColors.Background).padding(24.dp)) {
        UnderlineArrowLink(text = "Let's talk")
    }
}

@Preview
@Composable
private fun CircleArrowButtonPreview() {
    Box(modifier = Modifier.background(PortfolioColors.Background).padding(24.dp)) {
        CircleArrowButton(direction = ArrowDirection.UpRight)
    }
}
