package dev.rasul.remoteimageexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import dev.rasul.remoteimage.RemoteImage
import dev.rasul.remoteimageexample.ui.RemoteImageExampleTheme

class MainActivity : AppCompatActivity() {

    val fakeGoodImg =
        "https://i0.wp.com/itc.ua/wp-content/uploads/2020/07/android_logo_stacked__rgb_.0.jpg?fit=1200%2C800&quality=100&strip=all&ssl=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteImageExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            modifier = Modifier.wrapContentWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            RemoteImage(
                                url = fakeGoodImg,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(200.dp)
                                    .shadow(2.dp, RoundedCornerShape(20.dp)),
                                error = {
                                    Text(text = "Could not load image")
                                },
                                loading = {
                                    CircularProgressIndicator(
                                        strokeWidth = 2.dp,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}