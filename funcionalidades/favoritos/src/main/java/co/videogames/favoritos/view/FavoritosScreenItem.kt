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
import co.videogames.core_ui.R.string
import co.videogames.core_ui.ayudas.General

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
                painter = rememberAsyncImagePainter(videoJuego.imagen),
                contentDescription = videoJuego.titulo,
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(

                    text = "${context.getString(string.titulo)}: ${videoJuego.titulo}",
                    fontWeight = FontWeight(700),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.genero)}: ${videoJuego.genero}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.descripcion)}: ${videoJuego.descripcionCorta}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.plataforma)}: ${videoJuego.plataforma}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.editor)}: ${videoJuego.editor}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                val nuevaFecha = General.cambiarFormatoDeFecha(videoJuego.fecha)
                Text(
                    text = "${context.getString(string.fecha)}: $nuevaFecha",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}