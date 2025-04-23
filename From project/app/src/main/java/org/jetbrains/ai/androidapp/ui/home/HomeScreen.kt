package org.jetbrains.ai.androidapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.ai.androidapp.R
import org.jetbrains.ai.androidapp.ui.theme.AppTheme

@Composable
fun TeamWeatherWidget(
    modifier: Modifier = Modifier
) {
    val weatherCondition = remember { mutableStateOf("Sunny, partially cloudy") }
    val temperature = remember { mutableStateOf("+25°C") }
    val city = remember { mutableStateOf("Berlin") }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header with city and weather icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = city.value,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Text(
                        text = weatherCondition.value,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                    )
                }

                // Weather icon
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.sunny_24px),
                        contentDescription = "Weather icon",
                        modifier = Modifier.size(32.dp),
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Temperature display
            Text(
                text = temperature.value,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel()
) {
    var text by remember { mutableStateOf("Loading...") }

    // Observe the LiveData and update the state
    DisposableEffect(homeViewModel) {
        val observer = Observer<String> { newText ->
            text = newText
        }

        homeViewModel.text.observeForever(observer)

        onDispose {
            homeViewModel.text.removeObserver(observer)
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Surface(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.9f),
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 8.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ) {
                // Android mascot image with animation
                Image(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = "Android mascot",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(bottom = 24.dp)
                )

                // Divider
                androidx.compose.material3.Divider(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(0.7f),
                    thickness = 2.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                )

                // Text with improved styling
                Text(
                    text = text,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Subtitle text
                Text(
                    text = "Welcome to Android Workgroup",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Team Weather Widget
                TeamWeatherWidget()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 8.dp,
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(24.dp)
                ) {
                    // Android mascot image
                    Image(
                        painter = painterResource(id = R.drawable.ic_android),
                        contentDescription = "Android mascot",
                        modifier = Modifier
                            .size(180.dp)
                            .padding(bottom = 24.dp)
                    )

                    // Divider
                    androidx.compose.material3.Divider(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(0.7f),
                        thickness = 2.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    )

                    // Headline text with fancy version tag
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    ) {
                        Text(
                            text = "New AOSP merge is coming:",
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Fancy version tag
                        Card(
                            modifier = Modifier.padding(vertical = 4.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            )
                        ) {
                            Text(
                                text = "2025.1.1-alpha03",
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    // Subtitle text
                    Text(
                        text = "Welcome to Android Workgroup",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Team Weather Widget
                    TeamWeatherWidget()
                }
            }
        }
    }
}
