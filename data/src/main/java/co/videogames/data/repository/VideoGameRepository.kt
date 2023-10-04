package co.videogames.data.repository

import co.videogames.data.remote.response.VideoGame
import co.videogames.data.model.VideoGameState
import kotlinx.coroutines.flow.Flow

interface VideoGameRepository {
    suspend fun getVideoGames() : Flow<VideoGameState<List<VideoGame>>>
}