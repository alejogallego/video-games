package co.videogames.data.remote.response

import com.google.gson.annotations.SerializedName

data class Screen(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
)
