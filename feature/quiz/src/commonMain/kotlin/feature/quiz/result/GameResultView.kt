package feature.quiz.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.DoubleArrow
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Replay
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import core.base.designsystem.theme.MainAppTheme
import core.designsystem.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

class GameResultView : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    title = {
                        Text(text = "Quiz Completion")
                    },
                    navigationIcon = {
                        TooltipBox(
                            positionProvider =
                                TooltipDefaults.rememberTooltipPositionProvider(
                                    TooltipAnchorPosition.Above
                                ),
                            tooltip = { PlainTooltip { Text("Back") } },
                            state = rememberTooltipState(),
                        ) {
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Outlined.Close,
                                    contentDescription = "Back",
                                )
                            }
                        }
                    },
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.sm)) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = MainAppTheme.spacing.md),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Nice Work!!", style = MaterialTheme.typography.displaySmall)
                        Text(
                            "You have success answer question",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    ClassicGameResult()
//                    SurvivalGameResult()
                }

                Column(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
                        vertical = MainAppTheme.spacing.lg,
                        horizontal = MainAppTheme.spacing.md
                    ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Outlined.Replay, contentDescription = "Play Again")
                        Spacer(modifier = Modifier.width(MainAppTheme.spacing.sm))
                        Text(text = "Play Again", style = MaterialTheme.typography.titleMedium)
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors().copy(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        )
                    ) {
                        Icon(imageVector = Icons.Outlined.Home, contentDescription = "Back Home")
                        Spacer(modifier = Modifier.width(MainAppTheme.spacing.sm))
                        Text(text = "Back Home", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }

    @Composable
    private fun CardAnswerResult(
        modifier: Modifier = Modifier,
        label: String,
        value: String,
        startIcon: @Composable () -> Unit
    ) {
        Card(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(
                    vertical = MainAppTheme.spacing.sm,
                    horizontal = MainAppTheme.spacing.sm
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                startIcon()

                Spacer(modifier = Modifier.width(MainAppTheme.spacing.md))

                Column {
                    Text(label, style = MaterialTheme.typography.labelMedium)
                    Text(value, style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }

    @Composable
    private fun ClassicGameResult(
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
                .padding(vertical = MainAppTheme.spacing.md),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("New Record", style = MaterialTheme.typography.displaySmall)
            Text(
                "90%",
                style = MaterialTheme.typography.displayLarge,
                fontSize = 100.sp
            )
            Text(
                "Your Score",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(MainAppTheme.spacing.sm))
        CardAnswerResult(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
                vertical = MainAppTheme.spacing.sm,
                horizontal = MainAppTheme.spacing.md
            ),
            label = "Correct Answer",
            value = "10"
        ) {
            Column(
                modifier = Modifier.wrapContentSize()
                    .background(color = Color.Green.copy(.3f), shape = CircleShape)
                    .padding(MainAppTheme.spacing.sm),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check,
                    tint = Color.Green,
                    contentDescription = "Correct Answer"
                )
            }
        }
        CardAnswerResult(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
                vertical = MainAppTheme.spacing.sm,
                horizontal = MainAppTheme.spacing.md
            ),
            label = "Wrong Answer",
            value = "10"
        ) {
            Column(
                modifier = Modifier.wrapContentSize()
                    .background(color = Color.Red.copy(.3f), shape = CircleShape)
                    .padding(MainAppTheme.spacing.sm),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    tint = Color.Red,
                    contentDescription = "Wrong Answer"
                )
            }
        }
    }

    @Composable
    private fun SurvivalGameResult(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxWidth()
                .padding(vertical = MainAppTheme.spacing.md),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("New Record", style = MaterialTheme.typography.displaySmall)
            Text(
                "1000",
                style = MaterialTheme.typography.displayLarge,
                fontSize = 100.sp
            )
            Text(
                "Your Score",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.height(MainAppTheme.spacing.sm))
        Column {
            CardAnswerResult(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
                    vertical = MainAppTheme.spacing.sm,
                    horizontal = MainAppTheme.spacing.md
                ),
                label = "Correct Answer",
                value = "10"
            ) {
                Column(
                    modifier = Modifier.wrapContentSize()
                        .background(color = Color.Green.copy(.3f), shape = CircleShape)
                        .padding(MainAppTheme.spacing.sm),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Check,
                        tint = Color.Green,
                        contentDescription = "Correct Answer"
                    )
                }
            }
            CardAnswerResult(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
                    vertical = MainAppTheme.spacing.sm,
                    horizontal = MainAppTheme.spacing.md
                ),
                label = "Wrong Answer",
                value = "10"
            ) {
                Column(
                    modifier = Modifier.wrapContentSize()
                        .background(color = Color.Red.copy(.3f), shape = CircleShape)
                        .padding(MainAppTheme.spacing.sm),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        tint = Color.Red,
                        contentDescription = "Wrong Answer"
                    )
                }
            }
            CardAnswerResult(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
                    vertical = MainAppTheme.spacing.sm,
                    horizontal = MainAppTheme.spacing.md
                ),
                label = "Accuracy",
                value = "90%"
            ) {
                Column(
                    modifier = Modifier.wrapContentSize()
                        .background(color = Color.Gray.copy(.3f), shape = CircleShape)
                        .padding(MainAppTheme.spacing.sm),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.DoubleArrow,
                        tint = Color.Gray,
                        contentDescription = "Wrong Answer"
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun GameResultPreview() {
    AppTheme {
        GameResultView().Content()
    }
}