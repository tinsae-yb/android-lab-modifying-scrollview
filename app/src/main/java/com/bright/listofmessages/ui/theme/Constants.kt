package com.bright.listofmessages.ui.theme

import androidx.compose.ui.unit.dp

object Padding {
    val extraSmall = 2.dp
    val small = 4.dp
    val     medium = 8.dp
    val large = 16.dp
}

object Border {
    val small = 2.dp
    val medium = 4.dp
    val large = 8.dp
}

object ImageSize {
    val imageSize = 48.dp
    val borderWidth = 2.dp
    val totalSize = imageSize + Padding.small * 2 + borderWidth * 2
}