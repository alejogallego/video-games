package co.videogames.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.videogames.data.remote.response.VideoGame
import co.videogames.utilities.VideoGameState
import co.videogames.domain.usecase.GetVideoGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoGamesViewModel @Inject constructor(
    private val getVideoGamesUseCase: GetVideoGamesUseCase,
) : ViewModel() {

    private val _videoGamesState = MutableStateFlow<VideoGameState<List<VideoGame>>>(VideoGameState.Loading())
    val videoGamesState: StateFlow<VideoGameState<List<VideoGame>>> = _videoGamesState

    init {

        getVideoGames()
    }

    fun getVideoGames() {
        if (true) {
            viewModelScope.launch(IO) {
                /** Este delay es solo para que puedan visualizar el loader */
                delay(2000)
                getVideoGamesUseCase.invoke().collectLatest { videoGames ->
                   _videoGamesState.value = videoGames
                }
            }
        } else {
            _videoGamesState.value = VideoGameState.Empty()
        }
    }

}