package uz.unidev.mvi_jetpack_compose.ui.group.screen

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import uz.unidev.mvi_jetpack_compose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGroupDialog(
    eventDispatcher: (Intent) -> Unit
) {
    var groupName by remember { mutableStateOf("") }

    Dialog(onDismissRequest = {}) {
        Surface(shape = RoundedCornerShape(10.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 15.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    TextField(
                        value = groupName,
                        onValueChange = { groupName = it },
                        placeholder = { Text(text = stringResource(R.string.group_name)) }
                    )
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(onClick = { }) {
                            Text(text = stringResource(R.string.cancel), color = Color.White)
                        }
                        Button(onClick = { }) {
                            Text(text = stringResource(R.string.add), color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun AddGroupDialogPreview() {
    AddGroupDialog(eventDispatcher = {})
}