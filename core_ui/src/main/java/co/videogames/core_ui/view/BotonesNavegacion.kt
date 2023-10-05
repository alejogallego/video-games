package co.videogames.core_ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BotonesNavegacion(
    screens: List<String>,
    selectedScreen: String,
    onScreenSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        screens.forEach { screen ->
            val isSelected = screen == selectedScreen
            val textColor = if (isSelected) Color.Black else Color.Gray
            val backgroundColor = if (isSelected) Color.Gray else Color.Transparent

            Text(
                text = screen,
                color = textColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { onScreenSelected(screen) }
                    .background(backgroundColor)
                    .padding(8.dp)
            )
        }
    }
}


@Preview
@Composable
fun BotonesNavegacionPreview() {
    val screens = listOf("Pantalla1", "Pantalla2")
    val selectedScreen ="Pantalla2"
    BotonesNavegacion(screens = screens, selectedScreen = selectedScreen,onScreenSelected={})
}