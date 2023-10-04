package co.videogames.data.repositorio

import co.videogames.data.remote.response.VideoGame
import co.videogames.utilities.VideoGameState
import kotlinx.coroutines.flow.Flow

interface VideoGameRepository {
    suspend fun getVideoGames() : Flow<VideoGameState<List<VideoGame>>>
}