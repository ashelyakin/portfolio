package com.ashelyakin.portfolio.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import androidx.compose.ui.tooling.preview.Preview
import com.ashelyakin.portfolio.ui.home.ArrowDirection
import com.ashelyakin.portfolio.ui.home.CircleArrowButton

/** Одна ссылка на соцсеть в футере. */
data class SocialLink(
    val label: String,
    val url: String = ""
)

private val defaultSocialLinks = listOf(
    SocialLink("GitHub"),
    SocialLink("LinkedIn"),
    SocialLink("Email")
)

/**
 * Футер страницы (п.2.8 спецификации).
 * Разделительная линия сверху, копирайт слева, ссылки на соцсети в центре/справа,
 * круглая кнопка "наверх" в правом углу.
 */
@Composable
fun Footer(
    copyrightText: String = "© 2026 Your Name. All rights reserved.",
    socialLinks: List<SocialLink> = defaultSocialLinks,
    onSocialLinkClick: (SocialLink) -> Unit = {},
    onScrollToTopClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(PortfolioColors.Divider)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = copyrightText, color = PortfolioColors.TextSecondary, fontSize = 13.sp)

            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                socialLinks.forEach { link ->
                    Text(
                        text = link.label,
                        color = PortfolioColors.TextPrimary,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable { onSocialLinkClick(link) }
                    )
                }
            }

            CircleArrowButton(direction = ArrowDirection.Up, onClick = onScrollToTopClick)
        }
    }
}

@Preview
@Composable
private fun FooterPreview() {
    Footer()
}
