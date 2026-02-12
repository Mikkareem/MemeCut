package com.techullurgy.memecut.meme_editor.data

import com.techullurgy.memecut.meme_editor.domain.SaveToStorageStrategy
import com.techullurgy.memecut.meme_editor.domain.StorageHandle

expect class CacheStorageStrategy: SaveToStorageStrategy {
    override fun giveStorageHandle(fileName: String): StorageHandle
}