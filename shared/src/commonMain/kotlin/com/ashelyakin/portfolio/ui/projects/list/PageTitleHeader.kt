package com.ashelyakin.portfolio.ui.projects.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Двухколоночный заголовок страницы "Все проекты" (раздел 3.2):
 * крупный заголовок "Projects" слева, короткое описание справа.
 */
@Composable
fun PageTitleHeader(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 48.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 80.sp,
            color = PortfolioColors.TextPrimary,
        )

        Text(
            text = description,
            fontSize = 16.sp,
            color = PortfolioColors.TextSecondary,
            textAlign = TextAlign.End,
            modifier = Modifier.widthIn(max = 360.dp),
        )
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun PageTitleHeaderPreview() {
    PageTitleHeader(
        title = "Projects",
        description = "Все проекты — отражение моего подхода к разработке: чистый код и продуманный UX",
    )
}
