package feature.dashboard.prequiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import core.base.designsystem.theme.MainAppTheme
import core.designsystem.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

class PreQuizView : Screen {

    @Composable
    override fun Content() {
        val listMode = rememberLazyListState(
            initialFirstVisibleItemIndex = 0,
            initialFirstVisibleItemScrollOffset = 0
        )
        val modes = listOf("Classic Mode", "Survival Mode")

        Scaffold {
            Column(
                modifier = Modifier.fillMaxSize().padding(
                    start = it.calculateStartPadding(
                        LayoutDirection.Ltr
                    ), end = it.calculateEndPadding(
                        LayoutDirection.Ltr
                    ), top = 16.dp, bottom = 16.dp
                ),
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(MainAppTheme.spacing.xxl))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Game Mode", style = MaterialTheme.typography.displaySmall)
                    Text("Select Mode of Quiz", style = MaterialTheme.typography.headlineSmall)
                }

                Spacer(modifier = Modifier.height(MainAppTheme.spacing.xxl))

                LazyColumn(
                    modifier = Modifier.fillMaxWidth().padding(
                        horizontal = MainAppTheme.spacing.lg
                    ),
                    state = listMode,
                    verticalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.md)
                ) {
                    items(items = modes) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize()
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                                    .padding(
                                        horizontal = MainAppTheme.spacing.lg,
                                        vertical = MainAppTheme.spacing.lg
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    item,
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.background
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreQuizPreview() {
    AppTheme {
        PreQuizView().Content()
    }
}