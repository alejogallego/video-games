package co.videogames.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.videogames.core_ui.AppScreens
import co.videogames.core_ui.view.BotonesNavegacion
import co.videogames.detalles.view.DetallesScreen
import co.videogames.detalles.viewmodel.DetallesViewModel
import co.videogames.favoritos.view.FavoritosScreen
import co.videogames.favoritos.viewmodel.FavoritosVideoJuegosViewModel
import co.videogames.inicio.view.SplashScreen
import co.videogames.listado.view.ListadoScreen
import co.videogames.listado.viewmodel.ListadoVideoJuegosViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val videoGamesViewModel = hiltViewModel<ListadoVideoJuegosViewModel>()
    val detallesViewModel = hiltViewModel<DetallesViewModel>()
    val favoritosViewModel = hiltViewModel<FavoritosVideoJuegosViewModel>()
    NavHost(
        navController = navController,
        startDestination = AppScreens.InicioScreen.route
    ) {
        composable(route = AppScreens.InicioScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.FavoritosScreen.route) {
            FavoritosScreen(navController = navController, viewModel = favoritosViewModel)
        }
        composable(route = AppScreens.ListadoScreen.route) {
            ListadoScreen(navController = navController, viewModel = videoGamesViewModel)
        }
        composable(route = "${AppScreens.DetallesScreen.route}/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetallesScreen(navController = navController, id = id, viewModel = detallesViewModel)
        }
    }
}