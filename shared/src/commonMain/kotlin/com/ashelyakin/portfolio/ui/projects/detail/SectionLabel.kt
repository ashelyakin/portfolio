package com.ashelyakin.portfolio.ui.projects.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Мелкий служебный uppercase-лейбл с увеличенным letter-spacing,
 * например "FEATURED PROJECTS" или "ABOUT ME".
 */
@Composable
fun SectionLabel(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text.uppercase(),
        color = PortfolioColors.TextSecondary,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.5.sp,
        modifier = modifier,
    )
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun SectionLabelPreview() {
    SectionLabel(text = "Featured projects")
}
