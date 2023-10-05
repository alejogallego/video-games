package co.videogames.data.repository

import co.videogames.data.remote.response.VideoGame
import co.videogames.data.model.VideoGameState
import kotlinx.coroutines.flow.Flow

interface DetalleDelVideoJuegoRepository {
    suspend fun traerDetalleDeVideoJuego(id:Int) :Flow<VideoGameState<VideoGame>>
}