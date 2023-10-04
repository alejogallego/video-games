package co.utilidades.utilidades

sealed class VideoGameState<T>(val data: T? = null, val message: String? = null) {
    class Empty<T> : VideoGameState<T>()
    class Loading<T> : VideoGameState<T>()
    class Success<T>(data: T) : VideoGameState<T>(data)
    class Error<T>(message: String) : VideoGameState<T>(message = message)
}

