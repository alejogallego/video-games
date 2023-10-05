package co.videogames.listado.view

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
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.videogames.data.remote.response.VideoJuegos
import coil.compose.rememberAsyncImagePainter
import co.videogames.core_ui.R.string
import co.videogames.core_ui.ayudas.General

@Composable
fun ListadoScreenItem(
    videoGame: VideoJuegos,
    onClickVideoGame: (id: Int) -> Unit = {}
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = White)
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = White)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = rememberAsyncImagePainter(videoGame.imagen),
                contentDescription = videoGame.titulo,
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "${context.getString(string.titulo)}: ${videoGame.titulo}",
                    fontWeight = FontWeight(700),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.genero)}: ${videoGame.genero}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.descripcion)}: ${videoGame.descripcionCorta}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.plataforma)}: ${videoGame.plataforma}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${context.getString(string.editor)}: ${videoGame.editor}",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))

                val nuevaFecha = General.cambiarFormatoDeFecha(videoGame.fecha)
                Text(
                    text = "${context.getString(string.fecha)}: $nuevaFecha",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(onClick = {
                    onClickVideoGame.invoke(videoGame.id)
                } , modifier = Modifier.fillMaxWidth()) {
                    Text(text = "${context.getString(string.ver_mas)}")
                }
            }
        }
    }
}