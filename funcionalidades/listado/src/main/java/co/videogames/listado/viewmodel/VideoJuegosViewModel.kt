package co.videogames.listado.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.response.VideoGame
import co.videogames.listado.usecases.TraerTodosLosVideoJuegosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoJuegosViewModel @Inject constructor(
    private val traerTodosLosVideoJuegosUseCase: TraerTodosLosVideoJuegosUseCase
) : ViewModel() {

    private val _videoJuegos = MutableStateFlow<VideoGameState<List<VideoGame>>>(VideoGameState.Loading())
    val videoJuegos: StateFlow<VideoGameState<List<VideoGame>>> = _videoJuegos

    init {
        getVideoGames()
    }

    fun getVideoGames() {
        if (true) {
            viewModelScope.launch(IO) {
                /** Este delay es solo para que puedan visualizar el loader */
                delay(2000)
                traerTodosLosVideoJuegosUseCase.invoke().collectLatest { videoGames ->
                    _videoJuegos.value = videoGames
                }
            }
        } else {
            _videoJuegos.value = VideoGameState.Empty()
        }
    }

}
