package uz.unidev.mvi_jetpack_compose.navigator

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.Flow

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 16:00
 */

typealias NavigationArgs = Navigator.() -> Unit

interface NavigationHandler {
    val navigationStack: Flow<NavigationArgs>
}