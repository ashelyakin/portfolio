package com.ashelyakin.portfolio.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * Типографика портфолио.
 * Размеры взяты из раздела "5. Типографика" спецификации дизайна (значения desktop).
 */
object PortfolioTypography {

    /** H1 (hero), 64–88px Bold — берём среднее значение 76sp */
    val h1 = TextStyle(
        fontSize = 76.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 80.sp
    )

    /** H2 (заголовки секций), 36–48px Bold — берём среднее значение 42sp */
    val h2 = TextStyle(
        fontSize = 42.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 48.sp
    )

    /** Лейблы uppercase, 11–12px Medium, letter-spacing 0.1em */
    val label = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.em
    )

    /** Основной текст, 16–18px Regular */
    val body = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp
    )

    /** Мелкий текст (подписи, теги), 12–13px Regular/Medium */
    val caption = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal
    )
}
