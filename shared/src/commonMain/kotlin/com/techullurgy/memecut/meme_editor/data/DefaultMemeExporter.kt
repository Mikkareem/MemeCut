package com.techullurgy.memecut.meme_editor.data

import com.techullurgy.memecut.meme_editor.domain.MemeExporter
import com.techullurgy.memecut.meme_editor.domain.SaveToStorageStrategy
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive

class DefaultMemeExporter(
    private val saveToStorageStrategy: SaveToStorageStrategy
) : MemeExporter {
    override suspend fun exportMeme(
        memeBytes: ByteArray,
        fileName: String
    ): Result<String> {
        return try {
            val storageHandle = saveToStorageStrategy.giveStorageHandle(fileName)
            storageHandle.write(memeBytes)
            Result.success(storageHandle.identifier!!)
        } catch (e: Exception) {
            currentCoroutineContext().ensureActive()
            Result.failure(e)
        }
    }
}