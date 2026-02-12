package com.techullurgy.memecut.meme_editor.presentation.util

import android.graphics.Bitmap
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.ByteArrayOutputStream
import kotlin.coroutines.resume

actual suspend fun ImageBitmap.toByteArray(): ByteArray = suspendCancellableCoroutine {
    val stream = ByteArrayOutputStream()
    asAndroidBitmap().compress(Bitmap.CompressFormat.JPEG, 100, stream)
    it.resume(stream.toByteArray())
}