package co.videogames.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import co.videogames.data.entity.VideoJuegosEntity

@Dao
interface VideoJuegosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarVideoJuegoBasedatos(datos: VideoJuegosEntity)

    @Query("SELECT * FROM VIDEO_JUEGOS")
    suspend fun traerTodaLaListaVideoJuegosBasedatos(): List<VideoJuegosEntity>

}