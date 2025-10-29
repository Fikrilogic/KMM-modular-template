package core.base.designsystem.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.base.designsystem.base.ThemeColorScheme
import core.base.designsystem.base.ThemeElevation
import core.base.designsystem.base.ThemeProvider
import core.base.designsystem.base.ThemeShapes
import core.base.designsystem.base.ThemeSpacing
import core.base.designsystem.base.ThemeTypography

@Immutable
data class MainAppColorsImpl(
    override val primary: Color
    = Color(0xFF8231C2),
    override val onPrimary: Color
    = Color(0xFFFFFFFF),
    override val primaryContainer: Color
    = Color(0xFF9D4EDD),
    override val onPrimaryContainer: Color
    = Color(0xFFFFFDFF),
    override val inversePrimary: Color
    = Color(0xFFE0B6FF),
    override val secondary: Color
    = Color(0xFF72508E),
    override val onSecondary: Color
    = Color(0xFFFFFFFF),
    override val secondaryContainer: Color
    = Color(0xFFDFB7FD),
    override val onSecondaryContainer: Color
    = Color(0xFF664481),
    override val tertiary: Color
    = Color(0xFF5E5E63),
    override val onTertiary: Color
    = Color(0xFFFFFFFF),
    override val tertiaryContainer: Color
    = Color(0xFFF3F0F7),
    override val onTertiaryContainer: Color
    = Color(0xFF6E6D73),
    override val background: Color
    = Color(0xFFFFF7FD),
    override val onBackground: Color
    = Color(0xFF1F1A22),
    override val surface: Color
    = Color(0xFFFFF7FD),
    override val onSurface: Color
    = Color(0xFF1F1A22),
    override val surfaceVariant: Color
    = Color(0xFFECDEF1),
    override val onSurfaceVariant: Color
    = Color(0xFF4D4353),
    override val surfaceTint: Color
    = Color(0xFFFFF7FD),
    override val inverseSurface: Color
    = Color(0xFF342E38),
    override val inverseOnSurface: Color
    = Color(0xFFF8EDFA),
    override val error: Color
    = Color(0xFFBA1A1A),
    override val onError: Color
    = Color(0xFFFFFFFF),
    override val errorContainer: Color
    = Color(0xFFFFDAD6),
    override val onErrorContainer: Color
    = Color(0xFF93000A),
    override val outline: Color
    = Color(0xFF7E7384),
    override val outlineVariant: Color
    = Color(0xFFD0C2D5),
    override val scrim: Color
    = Color(0xFF000000),
    override val surfaceBright: Color
    = Color(0xFFFFF7FD),
    override val surfaceDim: Color
    = Color(0xFFE1D7E3),
    override val surfaceContainer: Color
    = Color(0xFFF5EAF7),
    override val surfaceContainerHigh: Color
    = Color(0xFFF0E5F1),
    override val surfaceContainerHighest: Color
    = Color(0xFFEADFEC),
    override val surfaceContainerLow: Color
    = Color(0xFFFBF0FD),
    override val surfaceContainerLowest: Color
    = Color(0xFFFFFFFF),
) : ThemeColorScheme

@Immutable
data class MainAppTypographyImpl(
    override val displayLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    override val displayMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    override val displaySmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
    ),
    override val headlineLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    override val headlineMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    override val headlineSmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    override val titleLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    override val titleMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    override val titleSmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    override val bodyLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    override val bodyMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    override val bodySmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    override val labelLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    override val labelMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    override val labelSmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
) : ThemeTypography

@Immutable
data class MainAppShapesImpl(
    override val extraSmall: CornerBasedShape = RoundedCornerShape(4.dp),
    override val small: CornerBasedShape = RoundedCornerShape(8.dp),
    override val medium: CornerBasedShape = RoundedCornerShape(12.dp),
    override val large: CornerBasedShape = RoundedCornerShape(16.dp),
    override val extraLarge: CornerBasedShape = RoundedCornerShape(28.dp),
) : ThemeShapes

@Immutable
data class MainAppSpacingImpl(
    override val xs: Dp = 4.dp,
    override val sm: Dp = 8.dp,
    override val md: Dp = 16.dp,
    override val lg: Dp = 24.dp,
    override val xl: Dp = 32.dp,
    override val xxl: Dp = 64.dp,
) : ThemeSpacing

data class MainAppElevations(
    override val level0: Dp = 0.dp,
    override val level1: Dp = 1.dp,
    override val level2: Dp = 3.dp,
    override val level3: Dp = 6.dp,
    override val level4: Dp = 8.dp,
    override val level5: Dp = 12.dp,
) : ThemeElevation

data class MainAppThemeProviderImpl(
    override val colors: ThemeColorScheme = MainAppColorsImpl(),
    override val typography: ThemeTypography = MainAppTypographyImpl(),
    override val shapes: ThemeShapes = MainAppShapesImpl(),
    override val spacing: ThemeSpacing = MainAppSpacingImpl(),
    override val elevation: ThemeElevation = MainAppElevations(),
) : ThemeProvider

val LocalMainAppColors = staticCompositionLocalOf<ThemeColorScheme> { MainAppColorsImpl() }
val LocalMainAppTypography = staticCompositionLocalOf<ThemeTypography> { MainAppTypographyImpl() }
val LocalMainAppShapes = staticCompositionLocalOf<ThemeShapes> { MainAppShapesImpl() }
val LocalMainAppSpacing = staticCompositionLocalOf<ThemeSpacing> { MainAppSpacingImpl() }
val LocalMainAppElevation = staticCompositionLocalOf<ThemeElevation> { MainAppElevations() }

object MainAppTheme {
    val colorScheme: ThemeColorScheme
        @Composable get() = LocalMainAppColors.current

    val typography: ThemeTypography
        @Composable get() = LocalMainAppTypography.current

    val shapes: ThemeShapes
        @Composable get() = LocalMainAppShapes.current

    val spacing: ThemeSpacing
        @Composable get() = LocalMainAppSpacing.current

    val elevation: ThemeElevation
        @Composable get() = LocalMainAppElevation.current
}