package site.ylan.compose.ui.Component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import site.ylan.compose.R.drawable.carousel_image

data class CarouselItem(
    val id: Int,
    @DrawableRes val imageResId: Int,
)

val items =
    listOf(
        CarouselItem(0, carousel_image),
        CarouselItem(1, carousel_image),
        CarouselItem(2, carousel_image),
        CarouselItem(3, carousel_image),
        CarouselItem(4, carousel_image),
        CarouselItem(5, carousel_image)
    )

@ExperimentalMaterial3Api
@Composable
fun HorizontalMultiBrowseCarouselDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        HorizontalMultiBrowseCarousel(
            state = rememberCarouselState { items.count() },
            preferredItemWidth = 365.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Center)
        ) { i ->
            val item = items[i]
            Image(
                modifier = Modifier
                    .height(480.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = item.imageResId),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun HorizontalUncontainedCarouselDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        HorizontalUncontainedCarousel(
            state = rememberCarouselState { items.count() },
            itemWidth = 365.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Center)
        ) { i ->
            val item = items[i]
            Image(
                modifier = Modifier
                    .height(480.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = item.imageResId),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    }
}