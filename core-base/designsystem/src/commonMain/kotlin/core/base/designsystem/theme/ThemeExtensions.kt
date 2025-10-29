package core.base.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import core.base.designsystem.base.ThemeColorScheme
import core.base.designsystem.base.ThemeShapes
import core.base.designsystem.base.ThemeTypography


fun ThemeColorScheme.toMaterial3ColorSchema() = ColorScheme(
    primary = this.primary,
    onPrimary = this.onPrimary,
    primaryContainer = this.primaryContainer,
    onPrimaryContainer = this.onPrimaryContainer,
    inversePrimary = this.inversePrimary,
    secondary = this.secondary,
    onSecondary = this.onSecondary,
    secondaryContainer = this.secondaryContainer,
    onSecondaryContainer = this.onSecondaryContainer,
    tertiary = this.tertiary,
    onTertiary = this.onTertiary,
    tertiaryContainer = this.tertiaryContainer,
    onTertiaryContainer = this.onTertiaryContainer,
    background = this.background,
    onBackground = this.onBackground,
    surface = this.surface,
    onSurface = this.onSurface,
    surfaceVariant = this.surfaceVariant,
    onSurfaceVariant = this.onSurfaceVariant,
    surfaceTint = this.primary,
    inverseSurface = this.inverseSurface,
    inverseOnSurface = this.inverseOnSurface,
    error = this.error,
    onError = this.onError,
    errorContainer = this.errorContainer,
    onErrorContainer = this.onErrorContainer,
    outline = this.outline,
    outlineVariant = this.outlineVariant,
    scrim = this.scrim,
    surfaceBright = this.surfaceBright,
    surfaceDim = this.surfaceDim,
    surfaceContainer = this.surfaceContainer,
    surfaceContainerHigh = this.surfaceContainerHigh,
    surfaceContainerHighest = this.surfaceContainerHighest,
    surfaceContainerLow = this.surfaceContainerLow,
    surfaceContainerLowest = this.surfaceContainerLowest,
)

fun ThemeTypography.toMaterial3Typography() = Typography(
    displayLarge = this.displayLarge,
    displayMedium = this.displayMedium,
    displaySmall = this.displaySmall,
    headlineLarge = this.headlineLarge,
    headlineMedium = this.headlineMedium,
    headlineSmall = this.headlineSmall,
    titleLarge = this.titleLarge,
    titleMedium = this.titleMedium,
    titleSmall = this.titleSmall,
    bodyLarge = this.bodyLarge,
    bodyMedium = this.bodyMedium,
    bodySmall = this.bodySmall,
    labelLarge = this.labelLarge,
    labelMedium = this.labelMedium,
    labelSmall = this.labelSmall,
)

fun Typography.toMainAppTypography() = MainAppTypographyImpl(
    displayLarge = this.displayLarge,
    displayMedium = this.displayMedium,
    displaySmall = this.displaySmall,
    headlineLarge = this.headlineLarge,
    headlineMedium = this.headlineMedium,
    headlineSmall = this.headlineSmall,
    titleLarge = this.titleLarge,
    titleMedium = this.titleMedium,
    titleSmall = this.titleSmall,
    bodyLarge = this.bodyLarge,
    bodyMedium = this.bodyMedium,
    bodySmall = this.bodySmall,
    labelLarge = this.labelLarge,
    labelMedium = this.labelMedium,
    labelSmall = this.labelSmall,
)

fun ThemeShapes.toMaterial3Shapes() = Shapes(
    extraSmall = this.extraSmall,
    small = this.small,
    medium = this.medium,
    large = this.large,
    extraLarge = this.extraLarge,
)

fun Shapes.toMainAppShapes() = MainAppShapesImpl(
    extraSmall = this.extraSmall,
    small = this.small,
    medium = this.medium,
    large = this.large,
    extraLarge = this.extraLarge,
)