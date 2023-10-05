package co.videogames.data.remote

import co.videogames.data.remote.response.VideoJuegos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("api/games")
    suspend fun fetchVideoGames(): Response<List<VideoJuegos>>

    @GET("api/game")
    suspend fun traerLaInformacionDelVideoJuego(
        @Query("id") id: Int,
    ): Response<VideoJuegos>


}