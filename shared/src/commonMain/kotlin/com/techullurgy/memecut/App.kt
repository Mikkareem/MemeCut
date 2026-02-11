package com.techullurgy.memecut

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.techullurgy.memecut.core.presentation.NavigationRoot
import com.techullurgy.memecut.core.theme.MemeCreatorTheme

@Composable
@Preview
fun App() {
    MemeCreatorTheme {
        NavigationRoot()
    }
}