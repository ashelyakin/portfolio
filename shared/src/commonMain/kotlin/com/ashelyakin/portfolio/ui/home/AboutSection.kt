package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Блок "Обо мне" (п.2.5 спецификации).
 * Двухколоночная раскладка: слева лейбл + заголовок в 3 строки,
 * справа абзац текста и кнопка "More about me".
 */
@Composable
fun AboutSection(
    description: String = "Последние несколько лет я специализируюсь на разработке нативных " +
        "Android-приложений — от идеи и прототипа до релиза в Google Play. " +
        "Мне важны чистая архитектура, производительность и внимание к деталям интерфейса.",
    onMoreAboutMeClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 48.dp),
        horizontalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        // Левая колонка — лейбл + заголовок
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "ABOUT ME",
                style = PortfolioTypography.label,
                color = PortfolioColors.TextSecondary
            )
            Text(
                text = "I TURN IDEAS INTO",
                style = PortfolioTypography.h2,
                color = PortfolioColors.TextPrimary
            )
            Row {
                Text(
                    text = "SMOOTH ",
                    style = PortfolioTypography.h2,
                    color = PortfolioColors.TextPrimary
                )
                Text(
                    text = "ANDROID",
                    style = PortfolioTypography.h2,
                    color = PortfolioColors.TextSecondary
                )
            }
            Text(
                text = "EXPERIENCES",
                style = PortfolioTypography.h2,
                color = PortfolioColors.TextPrimary
            )
        }

        // Правая колонка — описание + CTA
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = description,
                style = PortfolioTypography.body,
                color = PortfolioColors.TextSecondary
            )
            OutlinePillButton(text = "More about me", onClick = onMoreAboutMeClick)
        }
    }
}

@Preview
@Composable
private fun AboutSectionPreview() {
    AboutSection()
}
