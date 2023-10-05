package co.videogames.detalles.usecases

import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.repository.BaseDeDatosRepository
import javax.inject.Inject

class GuardarVideoJuegoBaseDeDatos @Inject constructor(
    private val baseDeDatosRepository: BaseDeDatosRepository
) {
    suspend operator fun invoke(datos: VideoJuegosEntity){
        return baseDeDatosRepository.guardarVideoJuegoBaseDeDatos(datos= datos)
    }
}