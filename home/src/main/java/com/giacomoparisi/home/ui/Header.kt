package com.giacomoparisi.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giacomoparisi.core.compose.weather.background
import com.giacomoparisi.core.compose.weather.icon
import com.giacomoparisi.core.theme.WeatherComposeTheme
import com.giacomoparisi.entities.location.Location
import com.giacomoparisi.entities.weather.WeatherHour
import com.giacomoparisi.home.R
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
internal fun Header(
    location: Location,
    currentWeather: WeatherHour
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
        Modifier
            .fillMaxWidth()
            .background(
                currentWeather.background(),
                MaterialTheme.shapes.large
            )
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = location.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = currentWeather.icon()),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = currentWeather.tempC.roundToInt().toString(),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        val date = remember(currentWeather.instant) {
            currentWeather.instant
                .atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("EEEE dd MMMM"))
        }
        Text(
            text = date,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(20.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            WeatherInfo(
                icon = R.drawable.wind,
                value = "${currentWeather.windKmH.roundToInt()} km/h",
                name = stringResource(id = R.string.HOME_wind)
            )
            WeatherInfo(
                icon = R.drawable.humidity,
                value = "${currentWeather.humidity.roundToInt()}%",
                name = stringResource(id = R.string.HOME_humidity)
            )
            WeatherInfo(
                icon = R.drawable.rain,
                value = "${currentWeather.chanceOfRain.roundToInt()}%",
                name = stringResource(id = R.string.HOME_chance_of_rain)
            )
        }
    }
}

@Composable
private fun RowScope.WeatherInfo(icon: Int, value: String, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.weight(1f)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White,
        )
    }
}

@Composable
private fun HeaderPreview() {
    Header(
        location = Location.mock(),
        currentWeather = WeatherHour.mock()
    )
}

@Preview
@Composable
private fun HeaderLightPreview() {
    WeatherComposeTheme(useDarkTheme = false) {
        HeaderPreview()
    }
}

@Preview
@Composable
private fun HeaderDarkPreview() {
    WeatherComposeTheme(useDarkTheme = true) {
        HeaderPreview()
    }
}