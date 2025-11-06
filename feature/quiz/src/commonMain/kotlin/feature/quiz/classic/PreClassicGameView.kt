package feature.quiz.classic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import core.base.designsystem.theme.MainAppTheme
import core.designsystem.theme.AppTheme
import core.ui.button.DynamicButtonAnswer
import org.jetbrains.compose.ui.tooling.preview.Preview

class PreClassicGameView : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    title = {
                        Text(text = "Classic Mode")
                    },
                    navigationIcon = {
                        TooltipBox(
                            positionProvider =
                                TooltipDefaults.rememberTooltipPositionProvider(
                                    TooltipAnchorPosition.Above
                                ),
                            tooltip = { PlainTooltip { Text("Cancel The Game") } },
                            state = rememberTooltipState(),
                        ) {
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Outlined.Close,
                                    contentDescription = "Cancel The Game",
                                )
                            }
                        }
                    },
                    actions = {
                        TooltipBox(
                            positionProvider =
                                TooltipDefaults.rememberTooltipPositionProvider(
                                    TooltipAnchorPosition.Above
                                ),
                            tooltip = { PlainTooltip { Text("Stop The Game") } },
                            state = rememberTooltipState(),
                        ) {
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Stop,
                                    contentDescription = "Stop The Game",
                                )
                            }
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.xl)) {
                    CountryFlagContent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(.4f)
                            .padding(horizontal = MainAppTheme.spacing.md)
                            .background(
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = MaterialTheme.shapes.large
                            )
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Get Ready to Play!", style = MaterialTheme.typography.headlineLarge)

                        Spacer(modifier = Modifier.height(MainAppTheme.spacing.md))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier.background(
                                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = .5f),
                                    shape = MaterialTheme.shapes.large
                                )
                                    .padding(
                                        vertical = MainAppTheme.spacing.sm,
                                        horizontal = MainAppTheme.spacing.md
                                    )
                            ) {

                                Text(
                                    "DIFFICULT MEDIUM",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
                        vertical = MainAppTheme.spacing.lg,
                        horizontal = MainAppTheme.spacing.md
                    ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Next Question", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }

    @Composable
    private fun CountryFlagContent(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
        ) {

        }
    }

    @Composable
    private fun AnswerGridButtons(
        modifier: Modifier = Modifier,
        answerList: List<String> = listOf(),
        isAnswer: Boolean = false
    ) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.md),
            horizontalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.md)
        ) {
            items(answerList) { item ->
                DynamicButtonAnswer(
                    text = "Correct Answer",
                    onClick = {}, isAnswer = isAnswer, isCorrect = true
                )
            }
        }
    }
}

@Composable
@Preview
fun PreClassicGamePreview() {
    AppTheme {
        PreClassicGameView().Content()
    }
}