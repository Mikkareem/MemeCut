package com.techullurgy.memecut.di

import com.techullurgy.memecut.meme_editor.data.CacheStorageStrategy
import com.techullurgy.memecut.meme_editor.domain.SaveToStorageStrategy
import com.techullurgy.memecut.meme_editor.presentation.util.PlatformShareSheet
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformAppModule = module {
    factoryOf(::CacheStorageStrategy) bind SaveToStorageStrategy::class
    factoryOf(::PlatformShareSheet)
}