package site.ylan.compose.ui.Component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import site.ylan.compose.R


@Composable
fun ResourcesDemo() {
    Column(
        modifier = Modifier.systemBarsPadding()
    ) {
        // stringResource
        Text(text = stringResource(R.string.compose))
        Text(text = stringResource(R.string.congratulate, "New Year", 2025))

        // dimensionResource
        val smallPadding = dimensionResource(R.dimen.padding_small)
        Text(
            text = "...",
            modifier = Modifier.padding(smallPadding)
        )

        // colorResource
        Divider(color = colorResource(R.color.purple_200))

        // painterResource
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null // decorative element
        )

        // Icons
        Icon(Icons.Rounded.Menu, contentDescription = "Localized description")

        // Fonts
        // val light = Font(R.font.raleway_light, FontWeight.W300)
        // val regular = Font(R.font.raleway_regular, FontWeight.W400)
        // val medium = Font(R.font.raleway_medium, FontWeight.W500)
        // val semibold = Font(R.font.raleway_semibold, FontWeight.W600)
        // val craneFontFamily = FontFamily(light, regular, medium, semibold)
    }
}