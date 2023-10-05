package co.videogames.detalles.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.videogames.data.remote.response.VideoJuegos
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetallesScreenContent(
    datos: VideoJuegos,
    onClickVideoGame: (id: Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = datos.titulo,
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = rememberAsyncImagePainter(datos.imagen),
                contentDescription = datos.titulo,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Descripción: ${datos.descripcion}",
                fontWeight = FontWeight(400),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Url: ${datos.urlDelJuego}",
                fontWeight = FontWeight(400),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Requisitos mínimos del sistema: ${datos.requerimientos}",
                fontWeight = FontWeight(400),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Capturas de pantalla: ${datos.pantallazos}",
                fontWeight = FontWeight(400),
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {
                onClickVideoGame.invoke(datos.id)
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Guardar en favoritos")
            }
        }
    }
}