package com.techullurgy.memecut.meme_editor.presentation

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.IntSize

@Stable
data class MemeEditorState(
    val templateSize: IntSize = IntSize.Zero,
    val isLeavingWithoutSaving: Boolean = false,
    val textBoxInteractionState: TextBoxInteractionState = TextBoxInteractionState.None,
    val memeTexts: List<MemeText> = listOf(),
    val hasLeftEditor: Boolean = false
)

sealed interface TextBoxInteractionState {
    data object None: TextBoxInteractionState
    data class Selected(val textBoxId: String): TextBoxInteractionState
    data class Editing(val textBoxId: String): TextBoxInteractionState
}