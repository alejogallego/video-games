package co.videogames.favoritos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.favoritos.usecases.TraerTodosLosVideoJuegosFavoritosBaseDeDatosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritosVideoJuegosViewModel @Inject constructor(
   private val traerTodosLosVideoJuegosFavoritosBaseDeDatosUseCase: TraerTodosLosVideoJuegosFavoritosBaseDeDatosUseCase
) : ViewModel() {

    private val _videoJuegos = MutableStateFlow<List<VideoJuegosEntity>>(emptyList())
    val videoJuegos: StateFlow<List<VideoJuegosEntity>> = _videoJuegos

    init {
       traerTodosLosVideoJuegosBaseDeDatos()
    }

    private fun traerTodosLosVideoJuegosBaseDeDatos() {
            viewModelScope.launch(Dispatchers.IO) {
                _videoJuegos.value = traerTodosLosVideoJuegosFavoritosBaseDeDatosUseCase.invoke()
            }
    }

}