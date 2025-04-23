package org.jetbrains.ai.androidapp.screenshot

import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import org.jetbrains.ai.androidapp.ui.notifications.NotificationsScreen
import org.jetbrains.ai.androidapp.ui.notifications.NotificationsViewModel
import org.junit.Test

class NotificationsScreenTest : BaseScreenshotTest() {

    @Test
    fun testNotificationsScreen() {
        // Create a NotificationsViewModel instance
        val viewModel = NotificationsViewModel()

        // Set the content to the NotificationsScreen with the ViewModel
        setContent {
            NotificationsScreen(notificationsViewModel = viewModel)
        }

        // Capture the screenshot
        composeTestRule.onRoot().captureRoboImage("notifications_screen.png")
    }
}