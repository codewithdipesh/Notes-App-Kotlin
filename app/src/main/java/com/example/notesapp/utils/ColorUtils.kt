package com.example.notesapp.utils

import androidx.compose.ui.graphics.Color

fun Color.toArgbInt(): Int {
    return android.graphics.Color.argb(
        (alpha * 255).toInt(),
        (red * 255).toInt(),
        (green * 255).toInt(),
        (blue * 255).toInt()
    )
}

fun Int.toColor(): Color {
    return Color(this)
}
