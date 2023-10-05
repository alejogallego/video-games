package co.videogames.favoritos.view

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import co.videogames.favoritos.viewmodel.FavoritosVideoJuegosViewModel

@Composable
fun FavoritosScreen(
    navController: NavHostController,
    viewModel: FavoritosVideoJuegosViewModel
) {
    val context = LocalContext.current
     val videoJuegos by viewModel.videoJuegos.collectAsState()
    //val videoJuegos = viewModel.traerTodosLosVideoJuegosBaseDeDatos().value ?: emptyList()
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        when {
            videoJuegos.isNotEmpty() -> {
                println("-----------video${videoJuegos.size}")
                FavoritosScreenContent(datos = videoJuegos)
            }
            videoJuegos.isEmpty() -> {

            }
            else -> {
                // val textError = context.getString(R.string.error_general)
                val textError = "---d--sd-s-d-s-d"
                Toast.makeText(context, textError, Toast.LENGTH_LONG).show()
            }
        }
    }
}
