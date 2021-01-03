package dev.rasul.remoteimage

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test


class RemoteImageTest {


    @get:Rule
    val composeTestRule = createComposeRule()
//    c
    // createComposeRule() if you don't need access to the activityTestRule

    @Test
    fun RemoteImageTestBadImage() {

        val fakeBadImg = "https://somebadurl.com/somebad.img"

        composeTestRule.setContent {
            RemoteImage(
                url = fakeBadImg,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .shadow(10.dp, RoundedCornerShape(100.dp)),
                error = {
                    Text(text = "Could not load image", modifier = Modifier.testTag("errorText"))
                },
                loading = {
                    CircularProgressIndicator(
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(16.dp)
                    )
                }
            )
        }
        composeTestRule
            .onNodeWithTag("errorText")
            .assertExists()

        composeTestRule
            .onNodeWithTag("loadedImg")
            .assertDoesNotExist()
    }

    @Test
    fun RemoteImageTestCorrectImage() {

        val fakeGoodImg =
            "https://i0.wp.com/itc.ua/wp-content/uploads/2020/07/android_logo_stacked__rgb_.0.jpg?fit=1200%2C800&quality=100&strip=all&ssl=1"

        composeTestRule.setContent {
            RemoteImage(
                url = fakeGoodImg,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .shadow(10.dp, RoundedCornerShape(100.dp)),
                error = {
                    Text(text = "Could not load image", modifier = Modifier.testTag("errorText"))
                },
                loading = {
                    CircularProgressIndicator(
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(16.dp)
                    )
                }
            )
        }
        composeTestRule
            .onNodeWithTag("errorText")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag("loadedImg")
            .assertExists()
    }


}