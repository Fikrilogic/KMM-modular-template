package core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import core.designsystem.generated.resources.Nunito_Black
import core.designsystem.generated.resources.Nunito_Bold
import core.designsystem.generated.resources.Nunito_ExtraBold
import core.designsystem.generated.resources.Nunito_ExtraLight
import core.designsystem.generated.resources.Nunito_Light
import core.designsystem.generated.resources.Nunito_Medium
import core.designsystem.generated.resources.Nunito_Regular
import core.designsystem.generated.resources.Nunito_SemiBold
import core.designsystem.generated.resources.Res
import org.jetbrains.compose.resources.Font

//
//import androidx.compose.ui.text.font.FontFamily
//import kotlin.invoke
//
//// Default Material 3 typography values
val baseline = Typography()
//
val AppTypography: Typography
    @Composable get() = Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = fontFamily),
    )


val fontFamily: FontFamily
    @Composable get() = FontFamily(
        Font(Res.font.Nunito_Bold, FontWeight.Bold),
        Font(Res.font.Nunito_Black, FontWeight.Black),
        Font(Res.font.Nunito_Black, FontWeight.Black),
        Font(Res.font.Nunito_ExtraBold, FontWeight.ExtraBold),
        Font(Res.font.Nunito_ExtraLight, FontWeight.ExtraLight),
        Font(Res.font.Nunito_Light, FontWeight.Light),
        Font(Res.font.Nunito_Medium, FontWeight.Medium),
        Font(Res.font.Nunito_Regular, FontWeight.Normal),
        Font(Res.font.Nunito_SemiBold, FontWeight.SemiBold),
    )
