package uz.unidev.mvi_jetpack_compose.ui.group.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.unidev.mvi_jetpack_compose.R
import uz.unidev.mvi_jetpack_compose.data.models.GroupFullData
import uz.unidev.mvi_jetpack_compose.ui.group.viewmodel.Intent

@Composable
fun GroupItem(
    groupFullData: GroupFullData, eventDispatcher: (Intent) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(start = 8.dp, top = 10.dp, bottom = 10.dp)) {
                Column(Modifier.padding(0.dp, bottom = 5.dp)) {
                    TitleText(text = "Group Name", modifier = Modifier)
                    TitleContentText(text = groupFullData.name, modifier = Modifier)
                }
                Column(Modifier.padding(0.dp, top = 5.dp)) {
                    TitleText(text = "Students Count", modifier = Modifier)
                    TitleContentText(text = groupFullData.count.toString(), modifier = Modifier)
                }
            }

            Column(
                modifier = Modifier.padding(end = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                ActionButton(icon = R.drawable.ic_edit,
                    modifier = Modifier.padding(4.dp),
                    color = Color.Yellow,
                    onClick = { eventDispatcher(Intent.Edit(groupFullData.toGroupEntity())) })
                ActionButton(icon = R.drawable.ic_delete,
                    modifier = Modifier.padding(4.dp),
                    color = Color.Red,
                    onClick = { eventDispatcher(Intent.Edit(groupFullData.toGroupEntity())) })
            }
        }
    }
}

@Composable
fun TitleText(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Gray
    )
}

@Composable
fun TitleContentText(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black
    )
}

@Composable
fun ActionButton(
    icon: Int, modifier: Modifier, color: Color, onClick: () -> Unit, shape: Shape = RectangleShape
) {
    IconButton(
        onClick = onClick, modifier = modifier
            .clip(shape)
            .background(color)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.icon_button_description)
        )
    }
}

@Composable
@Preview
fun GroupItemPreview() {
    GroupItem(groupFullData = GroupFullData(1, "Android", 12), eventDispatcher = {})
}