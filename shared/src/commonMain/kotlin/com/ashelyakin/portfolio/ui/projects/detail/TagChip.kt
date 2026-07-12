package com.ashelyakin.portfolio.ui.projects.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Тег-пилюля с тонкой обводкой, например "Kotlin", "MVVM", "Firebase".
 */
@Composable
fun TagChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        color = PortfolioColors.TextPrimary,
        fontSize = 13.sp,
        modifier = modifier
            .border(1.dp, PortfolioColors.Divider, RoundedCornerShape(50))
            .padding(horizontal = 14.dp, vertical = 6.dp),
    )
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun TagChipPreview() {
    TagChip(text = "Kotlin")
}
