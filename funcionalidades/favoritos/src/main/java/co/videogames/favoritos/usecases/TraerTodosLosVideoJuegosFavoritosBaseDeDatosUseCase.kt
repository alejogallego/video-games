package co.videogames.favoritos.usecases

import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.model.VideoGameState
import co.videogames.data.repository.BaseDeDatosFavoritosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TraerTodosLosVideoJuegosFavoritosBaseDeDatosUseCase @Inject constructor(
    private val baseDeDatosFavoritosRepository: BaseDeDatosFavoritosRepository
) {
    suspend operator fun invoke(): List<VideoJuegosEntity> {
        return baseDeDatosFavoritosRepository.traerTodosLosVideoJuegosFavoritos()
    }
}