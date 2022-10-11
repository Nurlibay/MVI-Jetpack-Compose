package uz.unidev.mvi_jetpack_compose.ui.common

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uz.unidev.mvi_jetpack_compose.R
import uz.unidev.mvi_jetpack_compose.ui.group.viewmodel.Intent

@Composable
fun AddItemButton(
    modifier: Modifier, eventDispatcher: (Intent) -> Unit
) {
    FloatingActionButton(modifier = modifier, onClick = { eventDispatcher(Intent.AddDialog) }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = stringResource(R.string.add_item)
        )
    }
}

@Composable
@Preview
fun AddItemButtonPreview() {
    AddItemButton(modifier = Modifier, eventDispatcher = {})
}
