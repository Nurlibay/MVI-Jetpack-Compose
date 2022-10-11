package uz.unidev.mvi_jetpack_compose.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.unidev.mvi_jetpack_compose.R

@Composable
fun EmptyListPlaceHolder(contentItemName: String) {
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_empty),
                contentDescription = stringResource(R.string.no_item),
                modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.margin_standard))
                    .size(100.dp)
            )
            Text(text = "No $contentItemName", fontSize = 18.sp)
        }
    }
}

@Composable
@Preview
fun EmptyListPlaceHolderPreview() {
    EmptyListPlaceHolder(contentItemName = "Groups")
}