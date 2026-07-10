package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview

/**
 * CTA-блок с контактами (п.2.7 спецификации).
 * Широкий блок на чёрном фоне со скруглёнными углами: слева заголовок и подпись,
 * справа белая кнопка-пилюля "Let's talk".
 */
@Composable
fun ContactCtaSection(
    titleLine1: String = "Have a project",
    titleLine2: String = "in mind?",
    subtitle: String = "Давайте обсудим, как я могу помочь превратить вашу идею в приложение.",
    onLetsTalkClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 24.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(PortfolioColors.AccentDark)
            .padding(horizontal = 48.dp, vertical = 56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = titleLine1, style = PortfolioTypography.h2, color = PortfolioColors.Surface)
            Text(text = titleLine2, style = PortfolioTypography.h2, color = PortfolioColors.Surface)
            Text(
                text = subtitle,
                style = PortfolioTypography.body,
                color = PortfolioColors.TextSecondary,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        PrimaryPillButtonLight(text = "Let's talk", onClick = onLetsTalkClick)
    }
}

/** Белая пилюля с чёрным текстом — используется на тёмном фоне CTA-блока. */
@Composable
private fun PrimaryPillButtonLight(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(PortfolioColors.Surface)
            .clickable(onClick = onClick)
            .padding(horizontal = 28.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, color = PortfolioColors.AccentDark, fontWeight = FontWeight.Medium)
    }
}

@Preview
@Composable
private fun ContactCtaSectionPreview() {
    ContactCtaSection()
}
