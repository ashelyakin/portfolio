package com.ashelyakin.portfolio.ui.projects.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Горизонтальный ряд текстовых табов-фильтров категорий (раздел 3.3 спека)
 * с тонкой линией-разделителем под ними на всю ширину.
 */
@Composable
fun CategoryTabs(
    categories: List<String>,
    selected: String,
    modifier: Modifier = Modifier,
    onSelect: (String) -> Unit = {},
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row {
            categories.forEachIndexed { index, category ->
                val isSelected = category == selected
                Text(
                    text = category,
                    color = if (isSelected) PortfolioColors.TextPrimary else PortfolioColors.TextSecondary,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable { onSelect(category) }
                        .padding(vertical = 12.dp),
                )
                if (index != categories.lastIndex) {
                    Spacer(modifier = Modifier.width(24.dp))
                }
            }
        }
        Divider(color = PortfolioColors.Divider, thickness = 1.dp)
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun CategoryTabsPreview() {
    CategoryTabs(
        categories = listOf("All", "Mobile Apps", "Open Source", "Libraries"),
        selected = "All",
    )
}
