package co.videogames.data.model

sealed class VideoGameState<T>(val datos: T? = null, val mensaje: String? = null) {
    class Empty<T> : VideoGameState<T>()
    class Loading<T> : VideoGameState<T>()
    class Success<T>(datos: T) : VideoGameState<T>(datos)
    class Error<T>(message: String) : VideoGameState<T>(mensaje = message)
}

