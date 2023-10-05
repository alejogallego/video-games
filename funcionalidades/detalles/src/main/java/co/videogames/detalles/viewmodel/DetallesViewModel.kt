package co.videogames.detalles.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.response.VideoGame
import co.videogames.detalles.usecases.TraerDetalleDelVideoJuegoUseCase
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
    private val traerDetalleDelVideoJuegoUseCase: TraerDetalleDelVideoJuegoUseCase,
): ViewModel() {

    private val _video = MutableStateFlow<VideoGameState<VideoGame>>(VideoGameState.Loading())
    val video: StateFlow<VideoGameState<VideoGame>> = _video

    fun traerElDetalleDelVideoJuego(id:Int) {
        if (true) {
            viewModelScope.launch(Dispatchers.IO) {
                /** Este delay es solo para que puedan visualizar el loader */
                delay(2000)
                traerDetalleDelVideoJuegoUseCase.invoke(id=id).collectLatest { videoJuego ->
                    _video.value = videoJuego
                }
            }
        } else {
            _video.value = VideoGameState.Empty()
        }
    }
}