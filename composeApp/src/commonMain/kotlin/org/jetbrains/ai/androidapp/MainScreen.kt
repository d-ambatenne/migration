package org.jetbrains.ai.androidapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.jetbrains.ai.androidapp.ui.dashboard.DashboardScreen
import org.jetbrains.ai.androidapp.ui.dashboard.DashboardViewModel
import org.jetbrains.ai.androidapp.ui.home.HomeScreen
import org.jetbrains.ai.androidapp.ui.home.HomeViewModel
import org.jetbrains.ai.androidapp.ui.notifications.NotificationsScreen
import org.jetbrains.ai.androidapp.ui.notifications.NotificationsViewModel
import org.jetbrains.ai.androidapp.ui.theme.AppTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

sealed class Screen(val route: String, val iconResourcePath: String, val label: String) {
    object Home : Screen("home", "drawable/ic_home_black_24dp.xml", "Home")
    object Dashboard : Screen("dashboard", "drawable/ic_dashboard_black_24dp.xml", "Dashboard")
    object Notifications : Screen("notifications", "drawable/ic_notifications_black_24dp.xml", "Notifications")
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen() {
    val homeViewModel = remember { HomeViewModel() }
    val dashboardViewModel = remember { DashboardViewModel() }
    val notificationsViewModel = remember { NotificationsViewModel() }

    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        val items = listOf(
                            Screen.Home,
                            Screen.Dashboard,
                            Screen.Notifications
                        )

                        items.forEach { screen ->
                            NavigationBarItem(
                                icon = { 
                                    Icon(
                                        painter = painterResource(screen.iconResourcePath),
                                        contentDescription = null
                                    ) 
                                },
                                label = { Text(screen.labelResourceId) },
                                selected = currentScreen == screen,
                                onClick = { currentScreen = screen }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                when (currentScreen) {
                    Screen.Home -> HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = homeViewModel
                    )
                    Screen.Dashboard -> DashboardScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = dashboardViewModel
                    )
                    Screen.Notifications -> NotificationsScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = notificationsViewModel
                    )
                }
            }
        }
    }
}
