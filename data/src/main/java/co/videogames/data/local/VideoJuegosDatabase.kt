package co.videogames.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import co.videogames.data.entity.VideoJuegosEntity

@Database(entities = [VideoJuegosEntity::class], version = 1, exportSchema = false)
abstract class VideoJuegosDatabase : RoomDatabase() {
    abstract fun videoJuegosDao(): VideoJuegosDao

}