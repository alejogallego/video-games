package co.videogames.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import co.videogames.R
import co.videogames.presentation.components.Loader
import co.videogames.data.model.AppScreens
import co.videogames.data.remote.response.VideoGame
import co.utilidades.utilidades.VideoGameState

@Composable
fun HomeScreen(
    navController: NavHostController,
    videoGames: VideoGameState<List<VideoGame>>
) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (videoGames) {
            is VideoGameState.Loading -> {
                Loader()
            }
            is VideoGameState.Empty -> {

            }
            is VideoGameState.Success -> {
                val resultado = videoGames.data
                if (resultado != null) {
                    VideoGameScreen(data = resultado,
                        onClickVideoGame = {id ->
                            println("------entla torre:${id}")
                            navController.navigate(
                                route = "${AppScreens.DetailScreen.route}/${id}",
                            )
                        }
                    )
                }
            }
            is VideoGameState.Error -> {
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
    val data = listOf(
        co.videogames.data.remote.response.VideoGame(
            id = 200,
            title = "Overwatch 2",
            thumbnail = "https://www.a.com",
            genre = "Shooter",
            shortDescription = "A hero-focused",
            platform = "PC (Windows)",
            publisher = "Activision",
            releaseDate = "2022-10-04"
        ),
        co.videogames.data.remote.response.VideoGame(
            id = 400,
            title = "Overwatch 2",
            thumbnail = "https://www.b.com",
            genre = "Shooter",
            shortDescription = "A hero-focused",
            platform = "PC (Windows)",
            publisher = "Activision",
            releaseDate = "2022-10-07"
        )
    )
    val videoGames = VideoGameState.Success(data)
    val navController = rememberNavController()
    HomeScreen(videoGames = videoGames, navController = navController)
}
