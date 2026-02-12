package com.techullurgy.memecut.di

import com.techullurgy.memecut.meme_editor.data.DefaultMemeExporter
import com.techullurgy.memecut.meme_editor.domain.MemeExporter
import com.techullurgy.memecut.meme_editor.presentation.MemeEditorViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformAppModule: Module

val appModule = module {
    viewModelOf(::MemeEditorViewModel)
    factoryOf(::DefaultMemeExporter) bind MemeExporter::class
    includes(platformAppModule)
}