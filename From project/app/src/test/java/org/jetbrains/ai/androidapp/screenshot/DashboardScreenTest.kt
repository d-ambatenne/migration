package org.jetbrains.ai.androidapp.screenshot

import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import org.jetbrains.ai.androidapp.ui.dashboard.DashboardScreen
import org.jetbrains.ai.androidapp.ui.dashboard.DashboardViewModel
import org.junit.Test
import java.io.File

class DashboardScreenTest : BaseScreenshotTest() {

    @Test
    fun testDashboardScreen() {
        // Create a DashboardViewModel instance
        val viewModel = DashboardViewModel()

        // Set the content to the DashboardScreen with the ViewModel
        setContent {
            DashboardScreen(dashboardViewModel = viewModel)
        }

        // Capture the screenshot
        composeTestRule.onRoot().captureRoboImage("dashboard_screen.png")
    }
}
