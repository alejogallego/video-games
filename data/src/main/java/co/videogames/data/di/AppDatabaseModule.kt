package co.videogames.data.di

import android.content.Context
import androidx.room.Room
import co.videogames.data.local.VideoJuegosDao
import co.videogames.data.local.VideoJuegosDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Singleton
    @Provides
    fun instanciarVideoJuegosDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        VideoJuegosDatabase::class.java,
        "VIDEO_JUEGOS"
    ).build()


    @Singleton
    @Provides
    fun instanciarVideoJuegosDao(database: VideoJuegosDatabase): VideoJuegosDao = database.videoJuegosDao()

}