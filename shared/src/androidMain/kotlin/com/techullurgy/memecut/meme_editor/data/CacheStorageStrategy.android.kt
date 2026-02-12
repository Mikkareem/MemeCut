package com.techullurgy.memecut.meme_editor.data

import android.content.Context
import com.techullurgy.memecut.meme_editor.domain.SaveToStorageStrategy
import com.techullurgy.memecut.meme_editor.domain.StorageHandle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

actual class CacheStorageStrategy(
    private val context: Context
) : SaveToStorageStrategy {
    actual override fun giveStorageHandle(fileName: String): StorageHandle {
        val file = File(context.cacheDir, fileName)

        return object : StorageHandle {
            override val identifier: String?
                get() = file.absolutePath

            override suspend fun write(bytes: ByteArray) {
                withContext(Dispatchers.IO) {
                    file.writeBytes(bytes)
                }
            }
        }
    }
}