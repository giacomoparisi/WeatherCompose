package com.giacomoparisi.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.giacomoparisi.core.compose.preview.ScreenPreview
import com.giacomoparisi.core.theme.WeatherComposeTheme
import com.giacomoparisi.home.data.HomeState
import com.giacomoparisi.home.data.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val state by viewModel.stateFlow.collectAsState()

    HomeScreen(state = state)

}

@Composable
private fun HomeScreen(state: HomeState) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Weather Compose",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@ScreenPreview
@Composable
private fun HomeScreenLightPreview() {
    WeatherComposeTheme(useDarkTheme = false) {
        HomeScreen(state = HomeState())
    }
}

@ScreenPreview
@Composable
private fun HomeScreenDarkPreview() {
    WeatherComposeTheme(useDarkTheme = true) {
        HomeScreen(state = HomeState())
    }
}