package co.videogames.listado.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.videogames.core_ui.view.BotonesNavegacion
import co.videogames.data.remote.response.VideoJuegos

@Composable
fun ListadoScreenContent(datos: List<VideoJuegos>, onClickVideoGame: (id: Int) -> Unit = {}) {
    val listVideoGame by remember { mutableStateOf(datos) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        LazyColumn(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(10.dp)
        ) {
            items(listVideoGame) { product ->
                ListadoScreenItem(product, onClickVideoGame = {
                    onClickVideoGame.invoke(it)
                })
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}