package co.videogames.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.videogames.data.constantes.AppConstantes.NOMBRE_BASE_DATOS
import co.videogames.data.entity.VideoJuegosEntity


@Dao
interface VideoJuegosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarVideoJuegoBasedatos(datos: VideoJuegosEntity)

    @Query("SELECT * FROM $NOMBRE_BASE_DATOS ORDER BY id ASC")
    fun traerTodaLaListaVideoJuegosBasedatos(): List<VideoJuegosEntity>

}