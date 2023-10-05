package co.videogames.favoritos.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.remote.response.VideoJuegos


@Composable
fun FavoritosScreenContent(datos: List<VideoJuegosEntity>, onClickVideoGame: (id: Int) -> Unit = {}) {
    val listVideoGame by remember { mutableStateOf(datos) }
    LazyColumn(modifier = Modifier
        .background(color = Color.LightGray)
        .padding(10.dp)) {
        items(listVideoGame) { videoJuego ->
            FavoritosScreenItem(videoJuego = videoJuego,
                onClickVideoGame = {
                onClickVideoGame.invoke(it)
            })
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}