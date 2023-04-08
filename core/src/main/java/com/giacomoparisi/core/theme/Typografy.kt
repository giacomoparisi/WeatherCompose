package com.giacomoparisi.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography =
    Typography(
        bodyLarge =
        TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ),
        titleLarge =
        TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    )
