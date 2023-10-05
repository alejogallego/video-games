package co.videogames.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.videogames.data.entity.VideoJuegosEntity
import co.videogames.utilidades.AppConstants.NOMBRE_BASE_DATOS

@Dao
interface VideoJuegosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarVideoJuegoBasedatos(datos: VideoJuegosEntity)

    @Query("SELECT * FROM $NOMBRE_BASE_DATOS")
    suspend fun traerTodaLaListaVideoJuegosBasedatos(): List<VideoJuegosEntity>

}