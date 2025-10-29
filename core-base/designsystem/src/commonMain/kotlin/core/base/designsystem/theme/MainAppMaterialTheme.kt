package core.base.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import core.base.designsystem.base.ThemeProvider

@Composable
fun MainAppMaterialTheme(
    theme: ThemeProvider = MainAppThemeProviderImpl(),
    content: @Composable () -> Unit,
){
    MainAppThemeProvider(theme){
        MaterialTheme(
            colorScheme = theme.colors.toMaterial3ColorSchema(),
            typography = theme.typography.toMaterial3Typography(),
            shapes = theme.shapes.toMaterial3Shapes(),
            content = content
        )
    }
}

/*
* Dynamic Material Theme light / dark mode
* */

@Composable
fun MainAppMaterialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    lightThemeProvider: ThemeProvider = MainAppThemeProviderImpl(),
    darkThemeProvider: ThemeProvider = MainAppThemeProviderImpl(),
    content: @Composable () -> Unit,
){
    val theme = if(darkTheme) darkThemeProvider else lightThemeProvider
    MainAppMaterialTheme(theme){
        MaterialTheme(
            colorScheme = theme.colors.toMaterial3ColorSchema(),
            typography = theme.typography.toMaterial3Typography(),
            shapes = theme.shapes.toMaterial3Shapes(),
            content = content
        )
    }
}