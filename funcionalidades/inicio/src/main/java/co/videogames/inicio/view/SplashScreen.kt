package co.videogames.inicio.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import co.videogames.core_ui.AppScreens
import kotlinx.coroutines.delay
import co.videogames.core_ui.R.drawable
import co.videogames.core_ui.R.string
import co.videogames.core_ui.ayudas.General

@Composable
fun SplashScreen(navController: NavHostController) {

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        if (General.estaConectadoAInternet(context = context)) {
            navController.navigate(AppScreens.ListadoScreen.route)
        } else {
            navController.navigate(AppScreens.FavoritosScreen.route)
       }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFBD40C)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = drawable.logo),
            contentDescription = context.resources.getString(string.nombre_de_la_aplicacion),
            modifier = Modifier.size(350.dp, 350.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}
