package co.videogames.data.remote.response

import com.google.gson.annotations.SerializedName

data class VideoGame(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("short_description") val shortDescription: String,
    @SerializedName("platform") val platform: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("description") val description: String,
    @SerializedName("game_url") val gameUrl: String,
    @SerializedName("minimum_system_requirements") val minimumSystemRequirements: MinimumSystem,
    @SerializedName("screenshots") val screenshots: List<Screen>,
)

