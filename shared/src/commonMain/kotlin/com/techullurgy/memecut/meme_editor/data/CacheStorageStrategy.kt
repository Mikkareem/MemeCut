package com.techullurgy.memecut.meme_editor.data

import com.techullurgy.memecut.meme_editor.domain.SaveToStorageStrategy

expect class CacheStorageStrategy: SaveToStorageStrategy {
    override fun getFilePath(fileName: String): String
}