package co.videogames.data.repository

import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.model.VideoGameState
import kotlinx.coroutines.flow.Flow

interface BaseDeDatosFavoritosRepository {

    suspend fun traerTodosLosVideoJuegosFavoritos(): List<VideoJuegosEntity>

}