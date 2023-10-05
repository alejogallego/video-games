package co.videogames.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.videogames.utilidades.AppConstants.NOMBRE_BASE_DATOS

@Entity(tableName = NOMBRE_BASE_DATOS)
data class VideoJuegosEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "title") val titulo: String,
    @ColumnInfo(name = "thumbnail") val imagen: String,
    @ColumnInfo(name = "genre") val genero: String,
    @ColumnInfo(name = "shortDescription") val descripcionCorta: String,
    @ColumnInfo(name = "platform") val plataforma: String,
    @ColumnInfo(name = "publisher") val editor: String,
    @ColumnInfo(name = "releaseDate") val fecha: String,
    @ColumnInfo(name = "description") val descripcion: String,
    @ColumnInfo(name = "gameUrl") val urlDelJuego: String
)