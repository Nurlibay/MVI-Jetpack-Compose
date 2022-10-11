package uz.unidev.mvi_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uz.unidev.mvi_jetpack_compose.ui.theme.MVIJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVIJetpackComposeTheme {

            }
        }
    }
}