package feature.quiz.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import core.base.designsystem.theme.MainAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


class HistoryLeaderboard : Screen {

    private val listTab = listOf(
        HistoryLeaderboardTab(
            screen = HistoryClassicLeaderboard,
            name = "Classic"
        ),
        HistoryLeaderboardTab(
            screen = HistorySurvivalLeaderboard,
            name = "Survival"
        ),
    )

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() {
        TabNavigator(HistoryClassicLeaderboard) {
            Scaffold(
                topBar = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    "Leaderboard",
                                    style = MaterialTheme.typography.headlineLarge,
                                    modifier = Modifier.background(Color.Green)
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                        contentDescription = "Back"
                                    )
                                }
                            },
                        )
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                        )
                    }
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(it),
                    verticalArrangement = Arrangement.spacedBy(
                        MainAppTheme.spacing.md
                    )
                ) {
                    Spacer(modifier = Modifier.height(MainAppTheme.spacing.xs))
                    RowNavigationTab(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = MainAppTheme.spacing.md),
                        listTab = listTab
                    )

                    CurrentTab()
                }
            }
        }
    }


    @Composable
    private fun RowNavigationTab(
        modifier: Modifier,
        listTab: List<HistoryLeaderboardTab> = emptyList()
    ) {
        val tabNavigator = LocalTabNavigator.current
        Row(
            modifier = modifier.wrapContentHeight(),
            horizontalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.md)) {
                listTab.map { tab ->
                    Button(modifier = Modifier.weight(.5f), onClick = {
                        tabNavigator.current = tab.screen
                    }, enabled = tabNavigator.current.key == tab.screen.key) {
                        Text(tab.name, style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun HistoryLeaderboardPreview() {
    HistoryLeaderboard().Content()
}