package co.videogames.data.repository

import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.local.VideoJuegosDao
import co.videogames.data.model.VideoGameState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BaseDeDatosRepositoryImpl @Inject constructor(
    private val videoJuegosDao: VideoJuegosDao
): BaseDeDatosRepository, BaseDeDatosFavoritosRepository {
    override suspend fun guardarVideoJuegoBaseDeDatos(datos: VideoJuegosEntity) {
        videoJuegosDao.guardarVideoJuegoBasedatos(datos = datos)
    }

    override suspend fun traerTodosLosVideoJuegosFavoritos(): List<VideoJuegosEntity> {
        return videoJuegosDao.traerTodaLaListaVideoJuegosBasedatos()
    }
}