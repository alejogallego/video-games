package co.videogames.domain.usecase


import co.videogames.data.repository.VideoGameRepository
import co.videogames.utilities.VideoGameState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoGamesUseCase @Inject constructor(
    private val videoGameRepository: VideoGameRepository
) {
    suspend operator fun invoke(): Flow<VideoGameState<List<co.videogames.data.remote.response.VideoGame>>> {
        return videoGameRepository.getVideoGames()
    }
}