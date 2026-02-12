package com.techullurgy.memecut.meme_editor.presentation.util

import androidx.compose.ui.graphics.ImageBitmap

expect suspend fun ImageBitmap.toByteArray(): ByteArray