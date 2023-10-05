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
import co.videogames.core_ui.Loader
import co.videogames.data.model.VideoGameState
import co.videogames.detalles.viewmodel.DetallesViewModel
import co.videogames.core_ui.R.string

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
                Loader()
            }
            is VideoGameState.Empty -> {
                val textError = context.getString(string.sin_registros)
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
            is VideoGameState.Success -> {
                val resultado = videoJuego.datos
                if (resultado != null) {
                    DetallesScreenContent(datos = resultado,
                        onClickVideoGame = {
                            viewModel.guardarVideoJuegoBaseDeDatos(resultado)
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
