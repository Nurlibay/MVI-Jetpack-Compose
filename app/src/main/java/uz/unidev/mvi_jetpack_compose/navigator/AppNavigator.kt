package uz.unidev.mvi_jetpack_compose.navigator

import cafe.adriel.voyager.androidx.AndroidScreen

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 15:59
 */

typealias AppScreen = AndroidScreen

interface AppNavigator {
    suspend fun back()
    suspend fun backAll()
    suspend fun backToRoot()
    suspend fun navigateTo(screen: AppScreen)
}