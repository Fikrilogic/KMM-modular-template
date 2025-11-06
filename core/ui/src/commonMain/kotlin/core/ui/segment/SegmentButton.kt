package core.ui.segment

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.base.designsystem.theme.MainAppTheme
import core.designsystem.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun <T> SegmentButton(
    items: List<T>,
    onItemSelection: (select: T) -> Unit,
    isSelected: T,
    modifier: Modifier = Modifier,
) {


    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(MainAppTheme.spacing.lg))
            .wrapContentWidth()
            .border(
                width = 1.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(MainAppTheme.spacing.sm)
            )
            .background(color = Color.Gray.copy(alpha = .3f))
            .padding(horizontal = MainAppTheme.spacing.sm, vertical = MainAppTheme.spacing.sm)
        ,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {


        items.forEach { item ->
            val animatedBackgroundColor by animateColorAsState(
                targetValue = if (isSelected == item) MainAppTheme.colorScheme.primary else Color.Transparent,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
            Row(
                modifier = Modifier.clickable { onItemSelection.invoke(item) }
                    .height(40.dp)
                    .width(120.dp)
                    .clip(shape = RoundedCornerShape(MainAppTheme.spacing.lg))
                    .background(animatedBackgroundColor)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                SegmentTextButton(
                    text = item.toString(),
                    isSelected = isSelected == item
                )
            }
        }
    }
}

@Composable
fun RowScope.SegmentTextButton(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {

    val animatedTextColor by animateColorAsState(
        targetValue = if (isSelected) MainAppTheme.colorScheme.onPrimary else MainAppTheme.colorScheme.onSurface,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
    )

    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = animatedTextColor,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun SegmentButtonPreview() {
    val items = listOf("Month", "Year", "Day0")
    var selectedItem by remember { mutableStateOf(items.first()) }

    AppTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            SegmentButton(
                items = items,
                onItemSelection = { selectedItem = it },
                modifier = Modifier.fillMaxWidth(),
                isSelected = selectedItem
            )
        }
    }
}