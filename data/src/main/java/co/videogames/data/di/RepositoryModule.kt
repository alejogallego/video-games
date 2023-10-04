package co.videogames.data.di

import co.videogames.data.remote.NetworkService
import co.videogames.data.repository.VideoGameRepository
import co.videogames.data.repository.VideoGameRepositoryImpl
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
    ): VideoGameRepository =
        VideoGameRepositoryImpl(networkService)
}