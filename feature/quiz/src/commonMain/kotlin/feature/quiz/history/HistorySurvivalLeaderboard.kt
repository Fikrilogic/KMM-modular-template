package feature.quiz.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import core.base.designsystem.theme.MainAppTheme
import kotlin.random.Random

object HistorySurvivalLeaderboard : Tab {

    private val listColor: List<Color>
        @Composable
        get() = listOf(
            MainAppTheme.colorScheme.primary,
            MainAppTheme.colorScheme.error,
            MainAppTheme.colorScheme.scrim,
            MainAppTheme.colorScheme.tertiary,
        )

    private val listLevel: List<String>
        @Composable
        get() = listOf(
            "Easy",
            "Medium",
            "Hard",
        )

    override val options: TabOptions
        @Composable
        get() {
            val title = "Survival"

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                )
            }
        }

    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = MainAppTheme.spacing.md),
                horizontalArrangement = Arrangement.spacedBy(
                    MainAppTheme.spacing.sm
                )
            ) {
                listLevel.map { level ->
                    Button(
                        onClick = {},
                        modifier = Modifier.width(80.dp),
                        contentPadding = PaddingValues(
                            horizontal = MainAppTheme.spacing.xs,
                            vertical = MainAppTheme.spacing.xs
                        )
                    ) {
                        Text(level, style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
            Spacer(modifier = Modifier.height(MainAppTheme.spacing.sm))
            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(horizontal = MainAppTheme.spacing.md),
                verticalArrangement = Arrangement.spacedBy(MainAppTheme.spacing.sm)
            ) {
                items(2) {

                    val randomColorIndex = Random.nextInt(0, listColor.size)
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(
                                vertical = MainAppTheme.spacing.md,
                                horizontal = MainAppTheme.spacing.sm
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column(
                                modifier = Modifier.size(40.dp).fillMaxHeight()
                                    .clip(shape = CircleShape)
                                    .background(listColor[randomColorIndex]),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.WorkspacePremium,
                                    contentDescription = "award"
                                )
                            }
                            Spacer(modifier = Modifier.width(MainAppTheme.spacing.md))
                            Column {
                                Text("Sandi", style = MaterialTheme.typography.titleLarge)
                                Text("1000", style = MaterialTheme.typography.bodyLarge)
                            }
                        }
                    }
                }
            }
        }
    }
}