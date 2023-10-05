package co.videogames.detalles.view

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import co.videogames.data.model.VideoGameState
import co.videogames.detalles.viewmodel.DetallesViewModel

@Composable
fun DetallesScreen(navController: NavHostController, id: Int, viewModel: DetallesViewModel) {

    val context = LocalContext.current

    LaunchedEffect(id) {
        viewModel.traerElDetalleDelVideoJuego(id)
    }

    val videoJuego by viewModel.videoJuego.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (videoJuego) {
            is VideoGameState.Loading -> {
                // Loader()
            }
            is VideoGameState.Empty -> {

            }
            is VideoGameState.Success -> {
                val resultado = videoJuego.datos
                if (resultado != null) {
                    DetallesScreenContent(datos = resultado,
                        onClickVideoGame = { id ->
                            println("guardar en la base de datos$id")
                        }
                    )
                }
            }
            is VideoGameState.Error -> {
                val textError = videoJuego.mensaje
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
        }
    }
}
