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

  //  @Update
   // suspend fun updateInfoToAomTable(aomEntity: VideoJuegosEntity)

 //   @Query("SELECT * FROM VIDEO_JUEGOS")
  //  suspend fun getInfoFromAomTable(): List<VideoJuegosEntity>

  //  @Query("SELECT * FROM VIDEO_JUEGOS WHERE aomSquad = :aomSquad")
   // suspend fun getInfoFromAomTableBySquad(aomSquad: Int): List<AomEntity>

   // @Query("DELETE FROM VIDEO_JUEGOS WHERE aomKey = :aomKey")
  //  suspend fun deleteItemByKeyAomTable(aomKey: String)

   //// @Query("SELECT * FROM VIDEO_JUEGOS WHERE aomKey = :aomKey LIMIT 1")
    //suspend fun getAomByAomKey(aomKey: String): AomEntity


}