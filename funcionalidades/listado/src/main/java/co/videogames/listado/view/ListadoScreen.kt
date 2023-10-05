package co.videogames.listado.view

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import co.videogames.core_ui.AppScreens
import co.videogames.core_ui.Loader
import co.videogames.core_ui.R.string
import co.videogames.data.model.VideoGameState
import co.videogames.listado.viewmodel.ListadoVideoJuegosViewModel

@Composable
fun ListadoScreen(
    navController: NavHostController,
    viewModel: ListadoVideoJuegosViewModel
) {
    val context = LocalContext.current
    val videoJuegos by viewModel.videoJuegos.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (videoJuegos) {
            is VideoGameState.Loading -> {
                Loader()
            }
            is VideoGameState.Empty -> {
                val textError = context.getString(string.sin_registros)
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
            is VideoGameState.Success -> {
                val resultado = videoJuegos.datos
                if (resultado != null) {
                    ListadoScreenContent(datos = resultado,
                        onClickVideoGame = {id ->
                            navController.navigate(
                                route = "${AppScreens.DetallesScreen.route}/${id}",
                            )
                        }
                    )
                }
            }
            is VideoGameState.Error -> {
                val textError = videoJuegos.mensaje
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
            else -> {
                val textError = context.getString(string.error_general)
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
        }
    }
}
