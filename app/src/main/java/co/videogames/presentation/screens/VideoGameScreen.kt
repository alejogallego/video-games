package co.videogames.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import co.videogames.data.remote.response.VideoGame
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.videogames.presentation.components.ItemVideoGame

@Composable
fun VideoGameScreen(data: List<VideoGame>) {

    val listVideoGame by remember { mutableStateOf(data) }
    LazyColumn(){
        items(listVideoGame) { product ->
            ItemVideoGame(product, onClickProduct = {
                //onClickProduct.invoke(product)
            })
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}