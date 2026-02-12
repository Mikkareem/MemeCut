package com.techullurgy.memecut.meme_editor.domain

interface StorageHandle {
    val identifier: String?
    suspend fun write(bytes: ByteArray)
}

interface SaveToStorageStrategy {
    fun giveStorageHandle(fileName: String): StorageHandle
}