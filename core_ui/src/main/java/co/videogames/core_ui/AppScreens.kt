package co.videogames.core_ui

sealed class AppScreens(val route: String) {
    object InicioScreen : AppScreens(route = "inicio_screen")
    object PrincipalScreen : AppScreens(route = "principal_screen")
    object ListadoScreen : AppScreens(route = "listado_screen")
    object DetallesScreen : AppScreens(route = "detalles_screen")

    object FavoritosScreen : AppScreens(route = "favoritos_screen")


}
