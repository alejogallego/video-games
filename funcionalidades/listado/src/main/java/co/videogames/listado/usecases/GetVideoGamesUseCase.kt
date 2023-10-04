package co.videogames.listado.usecases


import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.response.VideoGame
import co.videogames.data.repository.VideoGameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoGamesUseCase @Inject constructor(
    private val videoGameRepository: VideoGameRepository
) {
    suspend operator fun invoke(): Flow<VideoGameState<List<VideoGame>>> {
        return videoGameRepository.getVideoGames()
    }
}