package co.videogames.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.videogames.data.remote.response.VideoGame

@Composable
fun ItemVideoGame( videoGame: VideoGame,
                   onClickProduct: (product: VideoGame) -> Unit = {})
{
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = White)
            .padding(32.dp)
            .clickable {
                onClickProduct.invoke(videoGame)
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .background(color = White)
        ) {
//            Image(
//                painter = rememberAsyncImagePainter(videoGame.thumbnail),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(120.dp)
//                    .clip(shape = RoundedCornerShape(8.dp))
//            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = videoGame.title,
                   // color = GreyFont,
                    fontWeight = FontWeight(700),
                    //style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                //val xxxx = "${context.getString(R.string.xxx)}: ${videoGame.xxx} $"
                Text(
                    text = "xxxx",
                    color = Blue,
                    fontWeight = FontWeight(400),
                  //  style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

//@Preview( showBackground = true)
//@Composable
//fun ItemProductPreview() {
//    val product = Product(
//        id = "String id",
//        title = "String title",
//        price = 120000,
//        thumbnail = "String URL"
//    )
//    ItemProduct(product = product)
//}