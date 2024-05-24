package presentation.pages.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AdditionalInfoText(
    title: String,
    description: String,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
        )
        Text(
            text = description,
            fontSize = 14.sp,
        )
    }
}

@Preview
@Composable
@Suppress("unused")
fun AdditionalInfoTextPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        AdditionalInfoText(
            title = "Title",
            description = "Description",
        )
    }
}