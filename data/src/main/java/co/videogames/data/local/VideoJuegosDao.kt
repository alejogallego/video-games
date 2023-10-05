package co.videogames.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.data.model.VideoGameState
import co.videogames.utilidades.AppConstants.NOMBRE_BASE_DATOS
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoJuegosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarVideoJuegoBasedatos(datos: VideoJuegosEntity)

    @Query("SELECT * FROM $NOMBRE_BASE_DATOS ORDER BY id ASC")
    fun traerTodaLaListaVideoJuegosBasedatos(): List<VideoJuegosEntity>

}