package co.videogames.data.di

import co.videogames.data.constantes.AppConstantes.BASE_URL
import co.videogames.data.constantes.AppConstantes.TIEMPO_ESPERA_SEGUNDOS

import co.videogames.data.remote.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideRetrofit(): NetworkService =
        Retrofit.Builder()
            .client(getOkHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)

    private fun getOkHttpClient() =
        OkHttpClient.Builder()
            .connectTimeout(TIEMPO_ESPERA_SEGUNDOS, TimeUnit.SECONDS)
            .readTimeout(TIEMPO_ESPERA_SEGUNDOS, TimeUnit.SECONDS)
            .writeTimeout(TIEMPO_ESPERA_SEGUNDOS, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

}