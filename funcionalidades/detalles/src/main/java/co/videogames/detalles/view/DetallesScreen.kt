package co.videogames.detalles.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.videogames.detalles.viewmodel.DetallesViewModel

@Composable
fun DetallesScreen(navController: NavHostController, id: Int, viewModel: DetallesViewModel) {

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = White),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Text(text = "lo que llego de alla es: $id")
//
//
//    }

    val context = LocalContext.current

    LaunchedEffect(id) {
        viewModel.traerElDetalleDelVideoJuego(id)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = White)
            .padding(8.dp)
    ) {

        Text(text = "lo que llego de alla es: $id")
//        Column {
//
//            Image(
//                painter = rememberAsyncImagePainter(videoGame.thumbnail),
//                contentDescription = videoGame.title,
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//
//
//            Text(
//                // "${context.getString(R.string.titulo)}: ${videoGame.title}",
//                text = "------: ${videoGame.title}",
//                fontWeight = FontWeight(700),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Género: ${videoGame.genre}",
//                fontWeight = FontWeight(400),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Descripción: ${videoGame.shortDescription}",
//                fontWeight = FontWeight(400),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Plataforma: ${videoGame.platform}",
//                fontWeight = FontWeight(400),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Editor: ${videoGame.publisher}",
//                fontWeight = FontWeight(400),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = "Fecha lanzamiento: ${videoGame.releaseDate}",
//                fontWeight = FontWeight(400),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Button(onClick = {
//                onClickVideoGame.invoke(videoGame.id)
//            }, modifier = Modifier.fillMaxWidth()) {
//                Text(text = "Ver mas detalles")
//            }
//        }
    }
}
