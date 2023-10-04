package co.videogames.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.videogames.core_ui.AppScreens
import co.videogames.detalles.view.DetailScreen
import co.videogames.inicio.view.SplashScreen
import co.videogames.listado.view.ListScreen
import co.videogames.listado.viewmodel.VideoGamesViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<VideoGamesViewModel>()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.ListScreen.route) {
           ListScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "${AppScreens.DetailScreen.route}/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailScreen(navController = navController, id = id)
        }
    }
}