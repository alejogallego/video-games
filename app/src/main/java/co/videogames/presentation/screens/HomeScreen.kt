package co.videogames.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import co.videogames.R
import co.videogames.data.remote.response.VideoGame
import co.videogames.presentation.components.Loader
import co.videogames.utilities.VideoGameState

@Composable
fun HomeScreen(videoGames: VideoGameState<List<VideoGame>>) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        when(videoGames){
            is VideoGameState.Loading ->{
                Loader()
            }
            is VideoGameState.Empty ->{

            }
            is VideoGameState.Success ->{
                val data = videoGames.data
                println("----------total:${data}")
                if (data != null) VideoGameScreen(data)
            }
            is VideoGameState.Error ->{
                val textError = videoGames.message
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
            else -> {
                val textError = context.getString(R.string.error_general)
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val data = listOf(VideoGame(title="Overwatch 2"  ,thumbnail="https://www.a.com", genre="Shooter", shortDescription="A hero-focused", platform="PC (Windows)", publisher="Activision", releaseDate="2022-10-04"),
        VideoGame(title="Overwatch 2"  ,thumbnail="https://www.b.com", genre="Shooter", shortDescription="A hero-focused", platform="PC (Windows)", publisher="Activision", releaseDate="2022-10-07"))
    val videoGames = VideoGameState.Success(data)
   HomeScreen(videoGames)
}
