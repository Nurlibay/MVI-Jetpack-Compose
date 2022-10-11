package uz.unidev.mvi_jetpack_compose.navigator

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 *  Created by Nurlibay Koshkinbaev on 05/10/2022 16:02
 */

@Singleton
class NavigatorDispatcher @Inject constructor() : AppNavigator, NavigationHandler {

    override val navigationStack = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(args: NavigationArgs) {
        navigationStack.emit(args)
    }

    override suspend fun back() = navigate { pop() }
    override suspend fun backAll() = navigate { popAll() }
    override suspend fun backToRoot() = navigate { popUntilRoot() }
    override suspend fun navigateTo(screen: AppScreen) = navigate { push(screen) }
}