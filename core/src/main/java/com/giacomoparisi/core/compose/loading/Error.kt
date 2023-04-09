package com.giacomoparisi.core.compose.loading

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.giacomoparisi.core.R
import com.giacomoparisi.core.compose.button.WeatherComposeButton
import com.giacomoparisi.core.theme.WeatherComposeTheme
import com.giacomoparisi.domain.error.WeatherComposeException

@Composable
fun Error(
    error: WeatherComposeException,
    onRetryClicked: () -> Unit,
    modifier: Modifier
) {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.error)
    )
    val progress by animateLottieCompositionAsState(composition)

    Box(modifier = modifier.clickable { })
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier =
                Modifier.size(50.dp)
            )
            Text(
                text = getErrorMessage(exception = error),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(40.dp)
            )
            WeatherComposeButton(
                text = stringResource(id = R.string.COMMON_error_retry),
                onClick = onRetryClicked,
                modifier = Modifier.width(200.dp)
            )
        }
    }
}

@Composable
private fun ErrorPreview() {
    Error(
        error = WeatherComposeException.Unknown(),
        modifier = Modifier.fillMaxSize(),
        onRetryClicked = {}
    )
}

@Preview
@Composable
private fun ErrorLightPreview() {
    WeatherComposeTheme(useDarkTheme = false) { ErrorPreview() }
}

@Preview
@Composable
private fun ErrorDarkPreview() {
    WeatherComposeTheme(useDarkTheme = true) { ErrorPreview() }
}