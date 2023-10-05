package co.videogames.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "VIDEO_JUEGOS")
data class VideoJuegosEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "shortDescription") val shortDescription: String,
    @ColumnInfo(name = "platform") val platform: String,
    @ColumnInfo(name = "publisher") val publisher: String,
    @ColumnInfo(name = "releaseDate") val releaseDate: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "gameUrl") val gameUrl: String
)