package co.videogames.favoritos.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.videogames.data.entity.VideoJuegosEntity
import coil.compose.rememberAsyncImagePainter

@Composable
fun FavoritosScreenItem(
    videoJuego: VideoJuegosEntity,
    onClickVideoGame: (id: Int) -> Unit = {}
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = Color.White)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = rememberAsyncImagePainter(videoJuego.thumbnail),
                contentDescription = videoJuego.title,
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    // "${context.getString(R.string.titulo)}: ${videoGame.title}",
                    text = "------: ${videoJuego.title}",
                    fontWeight = FontWeight(700),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Género: ${videoJuego.genre}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Descripción: ${videoJuego.shortDescription}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Plataforma: ${videoJuego.platform}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Editor: ${videoJuego.publisher}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Fecha lanzamiento: ${videoJuego.releaseDate}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(onClick = {
                    onClickVideoGame.invoke(videoJuego.id)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Ver mas detalles")
                }
            }
        }
    }
}