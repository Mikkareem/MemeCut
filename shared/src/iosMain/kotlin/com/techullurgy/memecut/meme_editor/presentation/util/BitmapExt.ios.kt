package com.techullurgy.memecut.meme_editor.presentation.util

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asSkiaBitmap
import kotlinx.coroutines.suspendCancellableCoroutine
import org.jetbrains.skia.EncodedImageFormat
import org.jetbrains.skia.Image
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

actual suspend fun ImageBitmap.toByteArray(): ByteArray = suspendCancellableCoroutine {
    val image = Image.makeFromBitmap(asSkiaBitmap())
    val data = image.encodeToData(
        format = EncodedImageFormat.JPEG,
        quality = 100
    )
    if (data?.bytes != null) {
        it.resume(data.bytes)
    } else {
        it.resumeWithException(IllegalStateException("Image encoding failed"))
    }
}