package co.videogames.data.remote.response

import com.google.gson.annotations.SerializedName

data class VideoJuegos(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val titulo: String,
    @SerializedName("thumbnail") val imagen: String,
    @SerializedName("genre") val genero: String,
    @SerializedName("short_description") val descripcionCorta: String,
    @SerializedName("platform") val plataforma: String,
    @SerializedName("publisher") val editor: String,
    @SerializedName("release_date") val fecha: String,
    @SerializedName("description") val descripcion: String,
    @SerializedName("game_url") val urlDelJuego: String,
    @SerializedName("minimum_system_requirements") val requerimientos: MinimumSystem,
    @SerializedName("screenshots") val pantallazos: List<Screen>,
)

