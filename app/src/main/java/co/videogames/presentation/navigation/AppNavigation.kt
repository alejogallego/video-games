package co.videogames.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.videogames.presentation.screens.DetailScreen
import co.videogames.presentation.screens.HomeScreen
import co.videogames.presentation.screens.SplashScreen
import co.videogames.presentation.viewModels.VideoGamesViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel = viewModel<VideoGamesViewModel>()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.MainScreen.route) {
            val videoGames by viewModel.videoGamesState.collectAsState()
            HomeScreen(navController = navController, videoGames = videoGames)
        }
        composable(route = AppScreens.SearchScreen.route) {

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