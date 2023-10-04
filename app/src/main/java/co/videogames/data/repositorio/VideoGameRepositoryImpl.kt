package co.videogames.data.repositorio

import android.util.Log
import co.videogames.data.remote.NetworkService
import co.videogames.data.remote.response.VideoGame
import co.videogames.utilities.VideoGameState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VideoGameRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : VideoGameRepository {
    override suspend fun getVideoGames(): Flow<VideoGameState<List<VideoGame>>> {
        return flow {
            emit(VideoGameState.Loading())

            val api = networkService.fetchVideoGames()

            if(api.isSuccessful && api.body() != null){
                emit(VideoGameState.Success(api.body()!!))
            }else{
                emit(VideoGameState.Error("ERROR GENERICO"))
            }

        }.catch { err->
            Log.e("Error VideoGameRepositoryImpl:", err.toString())
            emit(VideoGameState.Error("Falla general del sistema"))
        }
    }
}