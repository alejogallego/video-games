package co.videogames.di

import co.videogames.data.repositorio.VideoGameRepository
import co.videogames.domain.usecase.GetVideoGamesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuloCasosUso {

    @Singleton
    @Provides
    fun provideGetVideoGamesUseCase(videoGameRepository:VideoGameRepository): GetVideoGamesUseCase {
        return GetVideoGamesUseCase(videoGameRepository)
    }

}