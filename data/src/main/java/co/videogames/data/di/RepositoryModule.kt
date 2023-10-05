package co.videogames.data.di

import co.videogames.data.local.VideoJuegosDao
import co.videogames.data.remote.NetworkService
import co.videogames.data.repository.BaseDeDatosFavoritosRepository
import co.videogames.data.repository.BaseDeDatosRepository
import co.videogames.data.repository.BaseDeDatosRepositoryImpl
import co.videogames.data.repository.DetalleDelVideoJuegoRepository
import co.videogames.data.repository.TodosLosVideoJuegosRepository
import co.videogames.data.repository.TodosLosVideoJuegosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun instanciarTodosLosVideoJuegosRepository(
        networkService: NetworkService
    ): TodosLosVideoJuegosRepository = TodosLosVideoJuegosRepositoryImpl(networkService)

    @Singleton
    @Provides
    fun instanciarDetalleDelVideoJuegoRepository(
        networkService: NetworkService
    ): DetalleDelVideoJuegoRepository = TodosLosVideoJuegosRepositoryImpl(networkService)

    @Singleton
    @Provides
    fun instanciarBaseDeDatosFavoritosRepository(
        videoJuegosDao: VideoJuegosDao
    ): BaseDeDatosFavoritosRepository = BaseDeDatosRepositoryImpl(videoJuegosDao)


    @Singleton
    @Provides
    fun instanciarBaseDeDatosRepository(
        videoJuegosDao: VideoJuegosDao
    ): BaseDeDatosRepository = BaseDeDatosRepositoryImpl(
        videoJuegosDao = videoJuegosDao
    )

}