package com.giacomoparisi.core.compose.loading

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.giacomoparisi.core.R
import com.giacomoparisi.core.theme.WeatherComposeTheme

@Composable
fun Loading(modifier: Modifier, size: Dp = 50.dp) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    val progress by animateLottieCompositionAsState(composition)

    Box(modifier = modifier.clickable { }) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier =
            Modifier
                .size(size)
                .align(Alignment.Center)
        )
    }

}

@Preview
@Composable
private fun LoadingLightPreview() {
    WeatherComposeTheme(useDarkTheme = false) {
        Loading(modifier = Modifier.fillMaxSize())
    }
}

@Preview
@Composable
private fun LoadingDarkPreview() {
    WeatherComposeTheme(useDarkTheme = true) {
        Loading(modifier = Modifier.fillMaxSize())
    }
}