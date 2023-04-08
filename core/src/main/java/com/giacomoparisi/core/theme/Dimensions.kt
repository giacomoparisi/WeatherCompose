package com.giacomoparisi.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

sealed class DimensionType {

	object Small : DimensionType()
	object SW320 : DimensionType()
	object SW360 : DimensionType()
	object SW400 : DimensionType()

}

class Dimensions(private val type: DimensionType) {

	fun <T> get(small: T, sw320: T, sw360: T, sw400: T) =
		when (type) {
			DimensionType.Small -> small
			DimensionType.SW320 -> sw320
			DimensionType.SW360 -> sw360
			DimensionType.SW400 -> sw400
		}
}

@Composable
fun ProvideDimens(
	dimensions: Dimensions,
	content: @Composable () -> Unit,
) {
	val dimensionSet = remember { dimensions }
	CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

val LocalAppDimens = staticCompositionLocalOf {
	Dimensions(DimensionType.Small)
}