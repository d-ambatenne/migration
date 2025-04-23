package org.jetbrains.ai.androidapp.screenshot

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ApplicationProvider
import com.github.takahirom.roborazzi.RoborazziRule
import org.jetbrains.ai.androidapp.ui.theme.AppTheme
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
abstract class BaseScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val roborazziRule = RoborazziRule()

    val context: Context = ApplicationProvider.getApplicationContext()

    fun setContent(content: @Composable () -> Unit) {
        composeTestRule.setContent {
            AppTheme {
                content()
            }
        }
    }
}
