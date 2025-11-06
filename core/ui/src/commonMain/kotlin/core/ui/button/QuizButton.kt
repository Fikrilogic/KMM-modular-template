package core.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import core.base.designsystem.theme.MainAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun QuizButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = MainAppTheme.colorScheme.primary,
    contentColor: Color = MainAppTheme.colorScheme.onPrimary,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        shape = RoundedCornerShape(MainAppTheme.spacing.lg),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = MainAppTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            disabledContentColor = MainAppTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
        ),
        contentPadding = PaddingValues(vertical = MainAppTheme.spacing.md)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge
        )
        if (trailingIcon != null) {
            Spacer(Modifier.width(MainAppTheme.spacing.sm))
            trailingIcon()
        }
    }
}

@Composable
fun DynamicButtonAnswer(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isCorrect: Boolean = false,
    isAnswer: Boolean = false
) {

    if(!isAnswer) {
        QuizButton(
            modifier = modifier,
            text = text,
            onClick = onClick,
            enabled = true,
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    } else {
        QuizButton(
            modifier = modifier,
            text = text,
            onClick = onClick,
            backgroundColor = if(isCorrect) Color(0xFF4CAF50) else MaterialTheme.colorScheme.error,
            contentColor = Color.White,
            trailingIcon = {
                Icon(
                    Icons.Default.Check,
                    contentDescription = text,
                    tint = Color.White
                )
            }
        )
    }
}

@Preview
@Composable
private fun QuizButtonPreview() {
    QuizButton(
        text = "Answer A",
        onClick = {}
    )
}

@Preview
@Composable
private fun QuizButtonCorrectPreview() {
    DynamicButtonAnswer(text = "Correct Answer",
        onClick = {}, isAnswer = true, isCorrect = true)
}

@Preview
@Composable
private fun QuizButtonIncorrectPreview() {
    QuizButton(
        text = "Wrong Answer",
        onClick = {},
        backgroundColor = Color(0xFFF44336),
        contentColor = Color.White,
        trailingIcon = { Icon(
            Icons.Default.Close,
            contentDescription = "Title",
            tint = Color.White
        ) }
    )
}

@Preview
@Composable
private fun QuizButtonDisabledPreview() {
    QuizButton(
        text = "Disabled Answer",
        onClick = {},
        enabled = false
    )
}