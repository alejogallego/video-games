package co.videogames.di

import co.videogames.data.remote.NetworkService
import co.videogames.data.repositorio.VideoGameRepository
import co.videogames.data.repositorio.VideoGameRepositoryImpl
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
    fun instanciarJuegosVideoRepositorio(
        networkService: NetworkService
    ): VideoGameRepository = VideoGameRepositoryImpl(networkService)
}