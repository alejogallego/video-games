package co.videogames.listado.usecases

import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.response.VideoJuegos
import co.videogames.data.repository.TodosLosVideoJuegosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TraerTodosLosVideoJuegosUseCase @Inject constructor(
    private val todosLosVideoJuegosRepository: TodosLosVideoJuegosRepository
) {
    suspend operator fun invoke(): Flow<VideoGameState<List<VideoJuegos>>> {
        return todosLosVideoJuegosRepository.traerTodosLosVideoJuegos()
    }
}