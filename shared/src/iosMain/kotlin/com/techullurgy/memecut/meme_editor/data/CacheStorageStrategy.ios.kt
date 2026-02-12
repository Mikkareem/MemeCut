@file:OptIn(ExperimentalForeignApi::class)

package com.techullurgy.memecut.meme_editor.data

import com.techullurgy.memecut.meme_editor.domain.SaveToStorageStrategy
import com.techullurgy.memecut.meme_editor.domain.StorageHandle
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSData
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask
import platform.Foundation.dataWithBytes
import platform.Foundation.writeToFile

actual class CacheStorageStrategy : SaveToStorageStrategy {
    actual override fun giveStorageHandle(fileName: String): StorageHandle {
        val cacheDirectory = NSSearchPathForDirectoriesInDomains(
            NSCachesDirectory,
            NSUserDomainMask,
            true
        ).firstOrNull() as? String ?: throw IllegalStateException("Could not find cache directory")

        return object : StorageHandle {
            override val identifier: String
                get() = "$cacheDirectory/$fileName"

            override suspend fun write(bytes: ByteArray) {
                withContext(Dispatchers.IO) {
                    bytes.usePinned {
                        NSData.dataWithBytes(
                            it.addressOf(0),
                            bytes.size.toULong()
                        ).writeToFile(identifier, true)
                    }
                }
            }
        }
    }
}