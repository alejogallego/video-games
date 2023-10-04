package co.videogames.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.videogames.ui.screens.HomeScreen
import co.videogames.ui.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {

        composable(route = AppScreens.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.MainScreen.route){
            HomeScreen()
        }
        composable(route = AppScreens.SearchScreen.route){

        }
        composable(route = AppScreens.DetailScreen.route){

        }


    }



}