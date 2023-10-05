package co.videogames.data.repository

import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.local.VideoJuegosDao
import javax.inject.Inject

class BaseDeDatosRepositoryImpl @Inject constructor(
    private val videoJuegosDao: VideoJuegosDao
): BaseDeDatosRepository {
    override suspend fun guardarVideoJuegoBaseDeDatos(datos: VideoJuegosEntity) {
        videoJuegosDao.guardarVideoJuegoBasedatos(datos = datos)
    }
}