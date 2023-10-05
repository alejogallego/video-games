package co.videogames.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.videogames.core_ui.AppScreens
import co.videogames.detalles.view.DetallesScreen
import co.videogames.detalles.viewmodel.DetallesViewModel
import co.videogames.inicio.view.SplashScreen
import co.videogames.listado.view.ListScreen
import co.videogames.listado.viewmodel.VideoJuegosViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val videoGamesViewModel = hiltViewModel<VideoJuegosViewModel>()
    val detallesViewModel = hiltViewModel<DetallesViewModel>()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.ListScreen.route) {
           ListScreen(navController = navController, viewModel = videoGamesViewModel)
        }
        composable(route = "${AppScreens.DetailScreen.route}/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetallesScreen(navController = navController, id = id, viewModel = detallesViewModel)
        }
    }
}