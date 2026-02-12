@file:OptIn(ExperimentalUuidApi::class)

package com.techullurgy.memecut.meme_editor.domain

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

interface MemeExporter {
    suspend fun exportMeme(
        memeBytes: ByteArray,
        fileName: String = "meme_${Uuid.random()}.jpg"
    ): Result<String>
}