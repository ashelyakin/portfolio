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
    description: String = "Я работаю над Android-приложениями на всех этапах их развития — от первых идей до готового продукта, которым пользуются люди. За это время мне приходилось решать самые разные задачи, поэтому я привык смотреть на приложение не как на набор отдельных экранов, а как на единый продукт.\n" +
            "\n" +
            "Для меня важно понимать, ради чего создаётся приложение, и находить решения, которые помогают довести идею до работающего результата.",
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
                text = "ОБО МНЕ",
                style = PortfolioTypography.label,
                color = PortfolioColors.TextSecondary
            )
            Text(
                text = "ЗА КАЖДЫМ ХОРОШИМ ПРИЛОЖЕНИЕМ — ",
                style = PortfolioTypography.h2,
                color = PortfolioColors.TextPrimary
            )
            Row {
                Text(
                    text = "ПРОДУМАННАЯ ",
                    style = PortfolioTypography.h2,
                    color = PortfolioColors.TextSecondary
                )
                Text(
                    text = "РАБОТА",
                    style = PortfolioTypography.h2,
                    color = PortfolioColors.TextPrimary
                )
            }
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
        }
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun AboutSectionPreview() {
    AboutSection()
}
