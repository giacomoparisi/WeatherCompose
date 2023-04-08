package com.giacomoparisi.core.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.giacomoparisi.core.R

val Roboto =
    FontFamily(
        Font(R.font.roboto_regular, FontWeight.Light),
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold),
        Font(R.font.roboto_bold, FontWeight.Black)
    )

