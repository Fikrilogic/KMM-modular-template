package core.base.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import core.base.designsystem.base.ThemeColorScheme
import core.base.designsystem.base.ThemeProvider


@Composable
fun MainAppThemeProvider(
    theme: ThemeProvider,
    content: @Composable () -> Unit
){
    CompositionLocalProvider(
        LocalMainAppColors provides theme.colors,
        LocalMainAppSpacing provides theme.spacing,
        LocalMainAppShapes provides theme.shapes,
        LocalMainAppElevation provides theme.elevation,
        LocalMainAppTypography provides theme.typography
    ){
        content()
    }
}