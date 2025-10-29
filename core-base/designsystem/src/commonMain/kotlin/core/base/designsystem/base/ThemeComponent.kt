package core.base.designsystem.base

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

interface ThemeProvider {
    val colors: ThemeColorScheme
    val typography: ThemeTypography
    val shapes: ThemeShapes
    val spacing: ThemeSpacing
    val elevation: ThemeElevation
}

@Stable
data class Theme(
    override val colors: ThemeColorScheme,
    override val typography: ThemeTypography,
    override val shapes: ThemeShapes,
    override val spacing: ThemeSpacing,
    override val elevation: ThemeElevation
) : ThemeProvider

@Stable
interface ThemeColorScheme {
    val primary: Color
    val onPrimary: Color
    val primaryContainer: Color
    val onPrimaryContainer: Color
    val inversePrimary: Color
    val secondary: Color
    val onSecondary: Color
    val secondaryContainer: Color
    val onSecondaryContainer: Color
    val tertiary: Color
    val onTertiary: Color
    val tertiaryContainer: Color
    val onTertiaryContainer: Color
    val background: Color
    val onBackground: Color
    val surface: Color
    val onSurface: Color
    val surfaceVariant: Color
    val onSurfaceVariant: Color
    val surfaceTint: Color
    val inverseSurface: Color
    val inverseOnSurface: Color
    val error: Color
    val onError: Color
    val errorContainer: Color
    val onErrorContainer: Color
    val outline: Color
    val outlineVariant: Color
    val scrim: Color
    val surfaceBright: Color
    val surfaceDim: Color
    val surfaceContainer: Color
    val surfaceContainerHigh: Color
    val surfaceContainerHighest: Color
    val surfaceContainerLow: Color
    val surfaceContainerLowest: Color
}

@Stable
data class AppThemeColorScheme(
    override val primary: Color,
    override val onPrimary: Color,
    override val primaryContainer: Color,
    override val onPrimaryContainer: Color,
    override val inversePrimary: Color,
    override val secondary: Color,
    override val onSecondary: Color,
    override val secondaryContainer: Color,
    override val onSecondaryContainer: Color,
    override val tertiary: Color,
    override val onTertiary: Color,
    override val tertiaryContainer: Color,
    override val onTertiaryContainer: Color,
    override val background: Color,
    override val onBackground: Color,
    override val surface: Color,
    override val onSurface: Color,
    override val surfaceVariant: Color,
    override val onSurfaceVariant: Color,
    override val surfaceTint: Color,
    override val inverseSurface: Color,
    override val inverseOnSurface: Color,
    override val error: Color,
    override val onError: Color,
    override val errorContainer: Color,
    override val onErrorContainer: Color,
    override val outline: Color,
    override val outlineVariant: Color,
    override val scrim: Color,
    override val surfaceBright: Color,
    override val surfaceDim: Color,
    override val surfaceContainer: Color,
    override val surfaceContainerHigh: Color,
    override val surfaceContainerHighest: Color,
    override val surfaceContainerLow: Color,
    override val surfaceContainerLowest: Color
) : ThemeColorScheme

class ThemeColorSchemeBuilder {
    var primary: Color = Color(0xFF8231C2)
    var onPrimary: Color = Color(0xFFFFFFFF)
    var primaryContainer: Color = Color(0xFF9D4EDD)
    var onPrimaryContainer: Color = Color(0xFFFFFDFF)
    var inversePrimary: Color = Color(0xFFE0B6FF)
    var secondary: Color = Color(0xFF72508E)
    var onSecondary: Color = Color(0xFFFFFFFF)
    var secondaryContainer: Color = Color(0xFFDFB7FD)
    var onSecondaryContainer: Color = Color(0xFF664481)
    var tertiary: Color = Color(0xFF5E5E63)
    var onTertiary: Color = Color(0xFFFFFFFF)
    var tertiaryContainer: Color = Color(0xFFF3F0F7)
    var onTertiaryContainer: Color = Color(0xFF6E6D73)
    var background: Color = Color(0xFFFFF7FD)
    var onBackground: Color = Color(0xFF1F1A22)
    var surface: Color = Color(0xFFFFF7FD)
    var onSurface: Color = Color(0xFF1F1A22)
    var surfaceVariant: Color = Color(0xFFECDEF1)
    var onSurfaceVariant: Color = Color(0xFF4D4353)
    var surfaceTint: Color = Color(0xFFFFF7FD)
    var inverseSurface: Color = Color(0xFF342E38)
    var inverseOnSurface: Color = Color(0xFFF8EDFA)
    var error: Color = Color(0xFFBA1A1A)
    var onError: Color = Color(0xFFFFFFFF)
    var errorContainer: Color = Color(0xFFFFDAD6)
    var onErrorContainer: Color = Color(0xFF93000A)
    var outline: Color = Color(0xFF7E7384)
    var outlineVariant: Color = Color(0xFFD0C2D5)
    var scrim: Color = Color(0xFF000000)
    var surfaceBright: Color = Color(0xFFFFF7FD)
    var surfaceDim: Color = Color(0xFFE1D7E3)
    var surfaceContainer: Color = Color(0xFFF5EAF7)
    var surfaceContainerHigh: Color = Color(0xFFF0E5F1)
    var surfaceContainerHighest: Color = Color(0xFFEADFEC)
    var surfaceContainerLow: Color = Color(0xFFFBF0FD)
    var surfaceContainerLowest: Color = Color(0xFFFFFFFF)

    fun build() = AppThemeColorScheme(
        primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary,
        secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary,
        onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground,
        surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint,
        inverseSurface, inverseOnSurface, error, onError, errorContainer,
        onErrorContainer, outline, outlineVariant, scrim, surfaceBright, surfaceDim,
        surfaceContainer, surfaceContainerHigh, surfaceContainerHighest,
        surfaceContainerLow, surfaceContainerLowest
    )
}

@Stable
interface ThemeTypography {
    val displayLarge: TextStyle
    val displayMedium: TextStyle
    val displaySmall: TextStyle
    val headlineLarge: TextStyle
    val headlineMedium: TextStyle
    val headlineSmall: TextStyle
    val titleLarge: TextStyle
    val titleMedium: TextStyle
    val titleSmall: TextStyle
    val bodyLarge: TextStyle
    val bodyMedium: TextStyle
    val bodySmall: TextStyle
    val labelLarge: TextStyle
    val labelMedium: TextStyle
    val labelSmall: TextStyle
}

@Stable
data class AppThemeTypography(
    override val displayLarge: TextStyle,
    override val displayMedium: TextStyle,
    override val displaySmall: TextStyle,
    override val headlineLarge: TextStyle,
    override val headlineMedium: TextStyle,
    override val headlineSmall: TextStyle,
    override val titleLarge: TextStyle,
    override val titleMedium: TextStyle,
    override val titleSmall: TextStyle,
    override val bodyLarge: TextStyle,
    override val bodyMedium: TextStyle,
    override val bodySmall: TextStyle,
    override val labelLarge: TextStyle,
    override val labelMedium: TextStyle,
    override val labelSmall: TextStyle
) : ThemeTypography

class ThemeTypographyBuilder {
    var displayLarge: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 57.sp)
    var displayMedium: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 45.sp)
    var displaySmall: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 36.sp)
    var headlineLarge: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 32.sp)
    var headlineMedium: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 28.sp)
    var headlineSmall: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 24.sp)
    var titleLarge: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 22.sp)
    var titleMedium: TextStyle = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp)
    var titleSmall: TextStyle = TextStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp)
    var bodyLarge: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 16.sp)
    var bodyMedium: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp)
    var bodySmall: TextStyle = TextStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp)
    var labelLarge: TextStyle = TextStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp)
    var labelMedium: TextStyle = TextStyle(fontWeight = FontWeight.Medium, fontSize = 12.sp)
    var labelSmall: TextStyle = TextStyle(fontWeight = FontWeight.Medium, fontSize = 11.sp)

    fun build() = AppThemeTypography(
        displayLarge, displayMedium, displaySmall, headlineLarge, headlineMedium,
        headlineSmall, titleLarge, titleMedium, titleSmall, bodyLarge, bodyMedium,
        bodySmall, labelLarge, labelMedium, labelSmall
    )
}

@Stable
interface ThemeShapes {
    val extraSmall: CornerBasedShape
    val small: CornerBasedShape
    val medium: CornerBasedShape
    val large: CornerBasedShape
    val extraLarge: CornerBasedShape
}

@Stable
data class AppThemeShapes(
    override val extraSmall: CornerBasedShape,
    override val small: CornerBasedShape,
    override val medium: CornerBasedShape,
    override val large: CornerBasedShape,
    override val extraLarge: CornerBasedShape
) : ThemeShapes

class ThemeShapesBuilder {
    var extraSmall: CornerBasedShape = RoundedCornerShape(4.dp)
    var small: CornerBasedShape = RoundedCornerShape(8.dp)
    var medium: CornerBasedShape = RoundedCornerShape(12.dp)
    var large: CornerBasedShape = RoundedCornerShape(16.dp)
    var extraLarge: CornerBasedShape = RoundedCornerShape(28.dp)

    fun build() = AppThemeShapes(extraSmall, small, medium, large, extraLarge)
}

@Stable
interface ThemeSpacing {
    val xs: Dp
    val sm: Dp
    val md: Dp
    val lg: Dp
    val xl: Dp
    val xxl: Dp
}

@Stable
data class AppThemeSpacing(
    override val xs: Dp,
    override val sm: Dp,
    override val md: Dp,
    override val lg: Dp,
    override val xl: Dp,
    override val xxl: Dp
) : ThemeSpacing

class ThemeSpacingBuilder {
    var xs: Dp = 4.dp
    var sm: Dp = 8.dp
    var md: Dp = 16.dp
    var lg: Dp = 24.dp
    var xl: Dp = 32.dp
    var xxl: Dp = 64.dp

    fun build() = AppThemeSpacing(xs, sm, md, lg, xl, xxl)
}

@Stable
interface ThemeElevation {
    val level0: Dp
    val level1: Dp
    val level2: Dp
    val level3: Dp
    val level4: Dp
    val level5: Dp
}

@Stable
data class AppThemeElevation(
    override val level0: Dp,
    override val level1: Dp,
    override val level2: Dp,
    override val level3: Dp,
    override val level4: Dp,
    override val level5: Dp
) : ThemeElevation

class ThemeElevationBuilder {
    var level0: Dp = 0.dp
    var level1: Dp = 1.dp
    var level2: Dp = 3.dp
    var level3: Dp = 6.dp
    var level4: Dp = 8.dp
    var level5: Dp = 12.dp

    fun build() = AppThemeElevation(level0, level1, level2, level3, level4, level5)
}

class ThemeBuilder {
    private val colorSchemeBuilder = ThemeColorSchemeBuilder()
    private val typographyBuilder = ThemeTypographyBuilder()
    private val shapesBuilder = ThemeShapesBuilder()
    private val spacingBuilder = ThemeSpacingBuilder()
    private val elevationBuilder = ThemeElevationBuilder()

    fun colors(block: ThemeColorSchemeBuilder.() -> Unit) =
        colorSchemeBuilder.apply(block)

    fun typography(block: ThemeTypographyBuilder.() -> Unit) =
        typographyBuilder.apply(block)

    fun shapes(block: ThemeShapesBuilder.() -> Unit) =
        shapesBuilder.apply(block)

    fun spacing(block: ThemeSpacingBuilder.() -> Unit) =
        spacingBuilder.apply(block)

    fun elevation(block: ThemeElevationBuilder.() -> Unit) =
        elevationBuilder.apply(block)

    fun build(): ThemeProvider = Theme(
        colors = colorSchemeBuilder.build(),
        typography = typographyBuilder.build(),
        shapes = shapesBuilder.build(),
        spacing = spacingBuilder.build(),
        elevation = elevationBuilder.build()
    )
}

fun appThemeBuilder(
    block: ThemeBuilder.() -> Unit
): ThemeProvider = ThemeBuilder().apply(block).build()