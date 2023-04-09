package com.giacomoparisi.core.compose.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giacomoparisi.core.theme.WeatherComposeTheme

@Composable
fun WeatherComposeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(onClick = onClick, modifier = Modifier
        .height(50.dp)
        .then(modifier)) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview
@Composable
private fun WeatherComposeButtonLightPreview() {
    WeatherComposeTheme(useDarkTheme = false) {
        WeatherComposeButton(
            text = "Click Me",
            onClick = {  },
            modifier = Modifier.width(200.dp)
        )
    }
}

@Preview
@Composable
private fun WeatherComposeButtonDarkPreview() {
    WeatherComposeTheme(useDarkTheme = true) {
        WeatherComposeButton(
            text = "Click Me",
            onClick = {  },
            modifier = Modifier.width(200.dp)
        )
    }
}