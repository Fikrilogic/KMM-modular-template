package feature.dashboard.prequiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import core.base.designsystem.theme.MainAppTheme
import core.designsystem.theme.AppTheme
import core.ui.generated.resources.Res
import core.ui.generated.resources.ic_timer
import core.ui.generated.resources.ic_trophy
import core.ui.segment.SegmentButton
import core.ui.segment.SegmentTextButton
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.collections.listOf

class PreQuizView : Screen {

    @Composable
    override fun Content() {
        val listMode = rememberLazyListState(
            initialFirstVisibleItemIndex = 0,
            initialFirstVisibleItemScrollOffset = 0
        )
        val modes = listOf(
            GameModeItem(
                title = "Classic",
                description = "Guest country as you know",
                image = Res.drawable.ic_trophy
            ),
            GameModeItem(
                title = "Survival",
                description = "How long you can run?",
                image = Res.drawable.ic_timer
            )
        )

        var selectedLevel by remember { mutableStateOf("Easy") }

        Scaffold {
            Column(
                modifier = Modifier.fillMaxSize().padding(
                    start = MainAppTheme.spacing.md,
                    end = MainAppTheme.spacing.md,
                    top = MainAppTheme.spacing.lg,
                    bottom = MainAppTheme.spacing.lg
                ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Choose The Game", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(MainAppTheme.spacing.md))
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        state = listMode,
                        verticalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.md),
                    ) {
                        items(items = modes) { item ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize()
                                        .background(MaterialTheme.colorScheme.primaryContainer),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp)
                                            .background(
                                                MaterialTheme.colorScheme.secondaryContainer
                                            ),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Image(
                                            painter = painterResource(item.image),
                                            modifier = Modifier.size(50.dp),
                                            contentDescription = item.title // Improved content description
                                        )
                                    }
                                    Column(
                                        modifier = Modifier.fillMaxWidth().height(70.dp)
                                            .padding(
                                                vertical = MainAppTheme.spacing.sm,
                                                horizontal = MainAppTheme.spacing.sm
                                            )
                                    ) {
                                        Text(
                                            item.title,
                                            style = MaterialTheme.typography.titleLarge,
                                            color = MaterialTheme.colorScheme.background
                                        )
                                        Spacer(modifier = Modifier.height(MainAppTheme.spacing.sm))
                                        Text(
                                            item.description,
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.background
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(MainAppTheme.spacing.lg))
                    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Select Difficulty", style = MaterialTheme.typography.headlineMedium)
                        Spacer(modifier = Modifier.height(MainAppTheme.spacing.md))
                        SegmentButton(
                            items = listOf("Easy", "Medium", "Hard"),
                            onItemSelection = { selectedLevel = it },
                            modifier = Modifier.fillMaxWidth(),
                            isSelected = selectedLevel
                        )
                    }
                }

                Button(onClick = {}, modifier = Modifier.fillMaxWidth()){
                    Text("Start The Game")
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