package co.videogames.detalles.usecases

import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.response.VideoJuegos
import co.videogames.data.repository.DetalleDelVideoJuegoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TraerDetallesDelVideoJuegoUseCase @Inject constructor(
    private val detalleDelVideoJuegoRepository: DetalleDelVideoJuegoRepository
) {

    suspend operator fun invoke(id:Int): Flow<VideoGameState<VideoJuegos>> {
        return detalleDelVideoJuegoRepository.traerDetalleDeVideoJuego(id= id)
    }
}