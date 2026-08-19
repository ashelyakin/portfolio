package com.ashelyakin.portfolio.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val IconArrowLeft: ImageVector by lazy {
    ImageVector.Builder(
        name = "ChevronLeft",
        defaultWidth = 8.dp,
        defaultHeight = 12.dp,
        viewportWidth = 8f,
        viewportHeight = 12f,
    ).apply {
        path(
            stroke = SolidColor(Color.White),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(6.4f, 10.8f)
            lineTo(1.6f, 6f)
            lineTo(6.4f, 1.2f)
        }
    }.build()
}

val IconArrowRight: ImageVector by lazy {
    ImageVector.Builder(
        name = "ArrowRight",
        defaultWidth = 8.dp,
        defaultHeight = 13.dp,
        viewportWidth = 8f,
        viewportHeight = 13f,
    ).apply {
        path(
            stroke = SolidColor(Color.White),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(1.6f, 1.7f)
            lineTo(6.4f, 6.5f)
            lineTo(1.6f, 11.3f)
        }
    }.build()
}

@Preview
@Composable
fun IconArrowLeftPreview() {
    Icon(
        imageVector = IconArrowLeft,
        contentDescription = "Arrow left",
        tint = Color.Black,
        modifier = Modifier
            .background(Color(0xFFF5F5F3))
            .padding(16.dp)
            .size(width = 8.dp, height = 12.dp)
    )
}

@Preview
@Composable
fun IconArrowRightPreview() {
    Icon(
        imageVector = IconArrowRight,
        contentDescription = "Arrow right",
        tint = Color.Black,
        modifier = Modifier
            .background(Color(0xFFF5F5F3))
            .padding(16.dp)
            .size(width = 8.dp, height = 13.dp)
    )
}