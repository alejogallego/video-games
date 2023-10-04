package co.videogames.domain.usecase


import co.videogames.data.remote.response.VideoGame
import co.videogames.data.repository.VideoGameRepository
import co.utilidades.utilidades.VideoGameState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoGamesUseCase @Inject constructor(
    private val videoGameRepository: VideoGameRepository
) {
    suspend operator fun invoke(): Flow<VideoGameState<List<VideoGame>>> {
        return videoGameRepository.getVideoGames()
    }
}