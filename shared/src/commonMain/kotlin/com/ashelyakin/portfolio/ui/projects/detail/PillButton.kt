package com.ashelyakin.portfolio.ui.projects.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors

/**
 * Основной CTA — чёрная кнопка-пилюля с белым текстом.
 * Например: "View my work →", "Let's talk".
 */
@Composable
fun FilledPillButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = PortfolioColors.AccentDark,
            contentColor = Color.White,
        ),
        contentPadding = PaddingValues(horizontal = 28.dp, vertical = 14.dp),
    ) {
        Text(text = text, fontSize = 15.sp, fontWeight = FontWeight.Medium)
    }
}

/**
 * Второстепенная кнопка-пилюля с обводкой и прозрачным фоном.
 * Например: "View all projects →", "More about me →".
 */
@Composable
fun OutlinePillButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, PortfolioColors.TextPrimary),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = PortfolioColors.TextPrimary),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
    ) {
        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun FilledPillButtonPreview() {
    FilledPillButton(text = "View my work →")
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun OutlinePillButtonPreview() {
    OutlinePillButton(text = "View all projects →")
}
