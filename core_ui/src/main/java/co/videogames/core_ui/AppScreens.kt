package co.videogames.core_ui

sealed class AppScreens(val route: String){
    object  SplashScreen: AppScreens(route = "splash_screen")
    object  MainScreen: AppScreens(route = "main_screen")
    object  SearchScreen: AppScreens(route = "search_screen")
    object  DetailScreen: AppScreens(route = "detail_screen")

    object ListScreen: AppScreens(route = "list_screen")
    object DetailsScreen: AppScreens(route = "details_screen")
}
