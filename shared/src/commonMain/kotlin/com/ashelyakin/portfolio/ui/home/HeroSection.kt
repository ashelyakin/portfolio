package com.ashelyakin.portfolio.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashelyakin.portfolio.ui.theme.PortfolioColors
import com.ashelyakin.portfolio.ui.theme.PortfolioTypography
import androidx.compose.ui.tooling.preview.Preview
import com.ashelyakin.portfolio.ui.ImageResourceCache

/**
 * Hero-блок главной страницы (п.2.2 "Hero-блок").
 * Двухколоночная раскладка: слева заголовок/описание/CTA, справа фото с бейджем.
 */
@Composable
fun HeroSection(
    titleLine1: String = "ANDROID",
    titleLine2: String = "DEVELOPER",
    description: String = "Я создаю быстрые, отзывчивые и продуманные Android-приложения, " +
        "уделяя особое внимание чистой архитектуре и удобству использования.",
    badgeNumber: String = "6+",
    badgeLabel: String = "YEARS EXPERIENCE",
    onViewWorkClick: () -> Unit = {},
    onLetsTalkClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(PortfolioColors.Background)
            .padding(horizontal = 48.dp, vertical = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        // Левая колонка — текст
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column {
                Text(
                    text = titleLine1,
                    style = PortfolioTypography.h1,
                    color = PortfolioColors.TextPrimary
                )
                Text(
                    text = titleLine2,
                    style = PortfolioTypography.h1,
                    color = PortfolioColors.TextSecondary
                )
            }

            Text(
                text = description,
                style = PortfolioTypography.body,
                color = PortfolioColors.TextSecondary
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                PrimaryPillButton(text = "View my work", onClick = onViewWorkClick)
                UnderlineArrowLink(text = "Let's talk", onClick = onLetsTalkClick)
            }
        }

        // Правая колонка — фото с бейджем
        Box(
            modifier = Modifier
                .weight(1f)
                .height(480.dp)
        ) {
            val path = "files/hero_photo.jpg"
            var bitmap by remember(path) {
                mutableStateOf(ImageResourceCache.getCached(path))
            }

            LaunchedEffect(path) {
                if (bitmap == null && !ImageResourceCache.hasFailed(path)) {
                    bitmap = ImageResourceCache.load(path)
                }
            }

            val loaded = bitmap
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(24.dp))
                    .background(PortfolioColors.ImagePlaceholder)
            ){
                if (loaded != null){
                    Image(
                        bitmap = loaded,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                }
            }

            // Бейдж с опытом
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(PortfolioColors.AccentDark)
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column {
                    Text(text = badgeNumber, color = PortfolioColors.Surface, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = badgeLabel,
                        style = PortfolioTypography.label,
                        color = PortfolioColors.TextSecondary
                    )
                }
                Text(text = "↗", color = PortfolioColors.Surface, fontSize = 18.sp)
            }
        }
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun HeroSectionPreview() {
    HeroSection()
}
