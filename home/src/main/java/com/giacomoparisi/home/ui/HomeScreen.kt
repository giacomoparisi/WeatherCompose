package com.giacomoparisi.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.giacomoparisi.core.compose.loading.LoadingError
import com.giacomoparisi.core.compose.preview.ScreenPreview
import com.giacomoparisi.core.theme.WeatherComposeTheme
import com.giacomoparisi.home.data.HomeAction
import com.giacomoparisi.home.data.HomeState
import com.giacomoparisi.home.data.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val state by viewModel.stateFlow.collectAsState()

    HomeScreen(
        state = state,
        onWeatherDaysRetry = { viewModel.dispatch(HomeAction.GetWeatherDays) })

}

@Composable
private fun HomeScreen(
    state: HomeState,
    onWeatherDaysRetry: () -> Unit
) {
    LoadingError(
        data = state.weatherDays,
        onRetryClicked = onWeatherDaysRetry
    ) {
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(20.dp)
        ) {
            Header(
                location = it.location,
                currentWeather = it.current
            )
        }
    }
}

@Composable
private fun HomeScreenPreview() {
    HomeScreen(state = HomeState(), onWeatherDaysRetry = {})
}

@ScreenPreview
@Composable
private fun HomeScreenLightPreview() {
    WeatherComposeTheme(useDarkTheme = false) {
        HomeScreenPreview()
    }
}

@ScreenPreview
@Composable
private fun HomeScreenDarkPreview() {
    WeatherComposeTheme(useDarkTheme = true) {
        HomeScreenPreview()
    }
}