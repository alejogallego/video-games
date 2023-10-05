package co.videogames.detalles.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.response.VideoJuegos
import co.videogames.detalles.usecases.GuardarVideoJuegoBaseDeDatos
import co.videogames.detalles.usecases.TraerDetallesDelVideoJuegoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetallesViewModel @Inject constructor(
    private val traerDetalleDelVideoJuegoUseCase: TraerDetallesDelVideoJuegoUseCase,
    private val guardarVideoJuegoBaseDeDatos: GuardarVideoJuegoBaseDeDatos
) : ViewModel() {

    private val _videoJuego = MutableStateFlow<VideoGameState<VideoJuegos>>(VideoGameState.Loading())
    val videoJuego: StateFlow<VideoGameState<VideoJuegos>> = _videoJuego

    fun traerElDetalleDelVideoJuego(id: Int) {
        if (true) {
            viewModelScope.launch(Dispatchers.IO) {
                /** Este delay es solo para que puedan visualizar el loader */
                delay(2000)
                traerDetalleDelVideoJuegoUseCase.invoke(id = id).collectLatest { videoJuego ->
                    _videoJuego.value = videoJuego
                }
            }
        } else {
            _videoJuego.value = VideoGameState.Empty()
        }
    }

    fun guardarVideoJuegoBaseDeDatos(resultado: VideoJuegos) {
        val datos = VideoJuegosEntity(
            id = resultado.id,
            title = resultado.title,
            thumbnail = resultado.thumbnail,
            genre = resultado.genre,
            shortDescription = resultado.shortDescription,
            platform = resultado.platform,
            publisher = resultado.publisher,
            releaseDate = resultado.releaseDate,
            description = resultado.description,
            gameUrl = resultado.gameUrl,
        )
        viewModelScope.launch(Dispatchers.IO) {
            guardarVideoJuegoBaseDeDatos.invoke(datos = datos)
        }
    }
}