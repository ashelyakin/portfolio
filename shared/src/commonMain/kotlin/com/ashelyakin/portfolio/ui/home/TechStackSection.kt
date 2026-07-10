package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview

/** Одна технология в стеке: название и первая буква для иконки-заглушки. */
data class TechItem(
    val name: String
) {
    val iconGlyph: String get() = name.take(1).uppercase()
}

private val defaultTechs = listOf(
    TechItem("Kotlin"),
    TechItem("Android"),
    TechItem("Jetpack Compose"),
    TechItem("Firebase"),
    TechItem("Retrofit"),
    TechItem("Room")
)

/**
 * Плашка-пилюля одной технологии: круглая иконка + название.
 */
@Composable
fun TechChip(
    item: TechItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .border(width = 1.dp, color = PortfolioColors.Divider, shape = RoundedCornerShape(50))
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(PortfolioColors.AccentDark),
            contentAlignment = Alignment.Center
        ) {
            Text(text = item.iconGlyph, color = PortfolioColors.Surface, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
        Text(text = item.name, color = PortfolioColors.TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

/**
 * Блок "Технологии / Стек" (п.2.6 спецификации).
 * Лейбл сверху и горизонтальный ряд плашек-пилюль с переносом (flex-wrap).
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechStackSection(
    technologies: List<TechItem> = defaultTechs,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "TECHNOLOGIES",
            style = PortfolioTypography.label,
            color = PortfolioColors.TextSecondary
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            technologies.forEach { tech ->
                TechChip(item = tech)
            }
        }
    }
}

@Preview
@Composable
private fun TechChipPreview() {
    Box(modifier = Modifier.background(PortfolioColors.Background).padding(16.dp)) {
        TechChip(item = TechItem("Kotlin"))
    }
}

@Preview
@Composable
private fun TechStackSectionPreview() {
    TechStackSection()
}
