package com.techullurgy.memecut.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.techullurgy.memecut.meme_editor.presentation.MemeEditorRoot
import com.techullurgy.memecut.meme_gallery.presentation.MemeGalleryScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

@Composable
fun NavigationRoot() {
    val backStack = rememberNavBackStack(
        SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.MemeGallery::class)
                    subclass(Route.MemeEditor::class)
                }
            }
        },
        Route.MemeGallery
    )

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Route.MemeGallery> {
                MemeGalleryScreen(
                    onMemeTemplateSelected = { memeTemplate ->
                        backStack.add(Route.MemeEditor(memeTemplate.id))
                    }
                )
            }

            entry<Route.MemeEditor> {
                val templateId = it.templateId
                val template = remember(templateId) {
                    memeTemplates.first { it.id == templateId }
                }
                MemeEditorRoot(
                    template = template,
                    onGoBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}