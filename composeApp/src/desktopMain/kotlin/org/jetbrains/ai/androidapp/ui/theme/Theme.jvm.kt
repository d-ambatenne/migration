package org.jetbrains.ai.androidapp.ui.theme

import androidx.compose.runtime.Composable
import java.awt.GraphicsEnvironment

@Composable
actual fun isSystemInDarkTheme(): Boolean {
    // This is a simple implementation that always returns false
    // For a more accurate implementation, you would need to use platform-specific APIs
    // to detect the system theme on desktop
    return false
}