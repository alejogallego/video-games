package co.videogames.data.repository

import android.util.Log
import co.videogames.data.model.VideoGameState
import co.videogames.data.remote.NetworkService
import co.videogames.data.remote.response.VideoGame
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodosLosVideoJuegosRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : TodosLosVideoJuegosRepository, DetalleDelVideoJuegoRepository {
    override suspend fun traerTodosLosVideoJuegos(): Flow<VideoGameState<List<VideoGame>>> {
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

    override suspend fun traerDetalleDeVideoJuego(id:Int): Flow<VideoGameState<VideoGame>> {
        return flow {
            emit(VideoGameState.Loading())

            val api = networkService.traerLaInformacionDelVideoJuego(id = id)

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