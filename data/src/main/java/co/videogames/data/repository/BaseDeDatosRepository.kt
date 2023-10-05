package co.videogames.data.repository

import co.videogames.data.entity.VideoJuegosEntity

interface BaseDeDatosRepository {

    suspend fun guardarVideoJuegoBaseDeDatos(datos: VideoJuegosEntity)

}