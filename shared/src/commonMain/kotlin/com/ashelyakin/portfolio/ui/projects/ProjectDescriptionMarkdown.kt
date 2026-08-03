package com.ashelyakin.portfolio.ui.projects

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.mikepenz.markdown.m3.Markdown
import com.mikepenz.markdown.m3.markdownColor
import com.mikepenz.markdown.m3.markdownTypography
import org.jetbrains.compose.resources.ExperimentalResourceApi
import portfolio.shared.generated.resources.Res

/**
 * Асинхронно читает .md файл из composeResources (files/) и рендерит его
 * через multiplatform-markdown-renderer, подстроенный под цвета/типографику сайта.
 *
 * Пока файл грузится — ничего не мигает "скачком": показываем небольшой лоадер.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectDescriptionMarkdown(
    descriptionMdPath: String,
    modifier: Modifier = Modifier,
) {
    val content by produceState<String?>(initialValue = null, key1 = descriptionMdPath) {
        value = runCatching { Res.readBytes(descriptionMdPath).decodeToString() }
            .getOrElse { "" } // при ошибке чтения — просто пустой блок, не роняем экран
    }

    when (val text = content) {
        null -> CircularProgressIndicator(color = PortfolioColors.TextPrimary)
        else -> Markdown(
            content = text,
            modifier = modifier.fillMaxWidth(),
            colors = markdownColor(
                text = PortfolioColors.TextPrimary,
                codeBackground = PortfolioColors.Background,
                inlineCodeBackground = PortfolioColors.Background,
                dividerColor = PortfolioColors.TextSecondary,
            ),
            typography = markdownTypography(
                text = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 17.sp,
                    color = PortfolioColors.TextPrimary,
                ),
                h1 = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.TextPrimary,
                ),
                h2 = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.TextPrimary,
                ),
                h3 = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = PortfolioColors.TextPrimary,
                ),
                paragraph = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 17.sp,
                    color = PortfolioColors.TextPrimary,
                ),
                list = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 17.sp,
                    color = PortfolioColors.TextPrimary,
                ),
            ),
        )
    }
}