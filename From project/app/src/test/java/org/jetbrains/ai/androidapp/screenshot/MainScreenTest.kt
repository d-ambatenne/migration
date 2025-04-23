package org.jetbrains.ai.androidapp.screenshot

import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import org.jetbrains.ai.androidapp.MainScreen
import org.junit.Test

class MainScreenTest : BaseScreenshotTest() {

    @Test
    fun testMainScreen() {
        // Set the content to the MainScreen
        setContent {
            MainScreen()
        }

        // Capture the screenshot of the initial state (Home screen)
        composeTestRule.onRoot().captureRoboImage("main_screen_home.png")
    }
}