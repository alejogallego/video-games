package co.videogames.data.remote

import co.videogames.data.remote.response.VideoGame
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET("api/games")
    suspend fun fetchVideoGames(): Response<List<VideoGame>>

}