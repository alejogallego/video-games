package co.videogames.data.repository


import co.videogames.data.remote.response.VideoGame
import co.utilidades.utilidades.VideoGameState
import kotlinx.coroutines.flow.Flow

interface VideoGameRepository {
    suspend fun getVideoGames() : Flow<VideoGameState<List<VideoGame>>>
}