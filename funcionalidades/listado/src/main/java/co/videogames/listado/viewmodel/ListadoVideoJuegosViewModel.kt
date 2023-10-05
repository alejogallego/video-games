package co.videogames.listado.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.response.VideoJuegos
import co.videogames.listado.usecases.TraerTodosLosVideoJuegosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListadoVideoJuegosViewModel @Inject constructor(
    private val traerTodosLosVideoJuegosUseCase: TraerTodosLosVideoJuegosUseCase
) : ViewModel() {

    private val _videoJuegos = MutableStateFlow<VideoGameState<List<VideoJuegos>>>(VideoGameState.Loading())
    val videoJuegos: StateFlow<VideoGameState<List<VideoJuegos>>> = _videoJuegos

    init {
        traerTodosLosVideoJuegos()
    }

    private fun traerTodosLosVideoJuegos() {
        viewModelScope.launch(IO) {
            traerTodosLosVideoJuegosUseCase.invoke().collectLatest { videoGames ->
                _videoJuegos.value = videoGames
            }
        }
    }

}
