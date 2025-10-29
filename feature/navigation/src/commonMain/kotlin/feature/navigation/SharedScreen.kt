package feature.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen: ScreenProvider {

    object Home: SharedScreen()
    object PreQuiz: SharedScreen()
}