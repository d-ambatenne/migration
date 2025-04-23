package org.jetbrains.ai.androidapp.screenshot

import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import org.jetbrains.ai.androidapp.ui.home.HomeScreen
import org.jetbrains.ai.androidapp.ui.home.HomeViewModel
import org.junit.Test

class HomeScreenTest : BaseScreenshotTest() {

    @Test
    fun testHomeScreen() {
        // Create a HomeViewModel instance
        val viewModel = HomeViewModel()

        // Set the content to the HomeScreen with the ViewModel
        setContent {
            HomeScreen(homeViewModel = viewModel)
        }

        // Capture the screenshot
        composeTestRule.onRoot().captureRoboImage("home_screen.png")
    }
}
