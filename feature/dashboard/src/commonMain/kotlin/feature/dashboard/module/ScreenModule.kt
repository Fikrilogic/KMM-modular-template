package feature.dashboard.module

import cafe.adriel.voyager.core.registry.screenModule
import feature.dashboard.home.HomeView
import feature.dashboard.prequiz.PreQuizView
import feature.navigation.SharedScreen

val featureDashboardModule = screenModule {
    register<SharedScreen.Home> {
        HomeView()
    }

    register<SharedScreen.PreQuiz> {
        PreQuizView()
    }
}