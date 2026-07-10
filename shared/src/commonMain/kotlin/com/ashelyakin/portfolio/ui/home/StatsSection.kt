package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview

/** Одна колонка блока статистики: число + подпись. */
data class StatItem(
    val value: String,
    val label: String
)

private val defaultStats = listOf(
    StatItem("6+", "YEARS EXPERIENCE"),
    StatItem("20+", "COMMERCIAL PROJECTS"),
    StatItem("4+", "PUBLICATIONS ON GOOGLE PLAY")
)

/**
 * Блок статистики (п.2.3 "Блок статистики").
 * Горизонтальная полоса с тонкой рамкой, разделённая вертикальными линиями на равные колонки.
 */
@Composable
fun StatsSection(
    stats: List<StatItem> = defaultStats,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp)
            .height(IntrinsicSize.Min)
            .border(width = 1.dp, color = PortfolioColors.Divider)
    ) {
        stats.forEachIndexed { index, stat ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stat.value,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.TextPrimary
                )
                Text(
                    text = stat.label,
                    style = PortfolioTypography.label,
                    color = PortfolioColors.TextSecondary
                )
            }

            if (index != stats.lastIndex) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(PortfolioColors.Divider)
                )
            }
        }
    }
}

@Preview
@Composable
private fun StatsSectionPreview() {
    StatsSection()
}
