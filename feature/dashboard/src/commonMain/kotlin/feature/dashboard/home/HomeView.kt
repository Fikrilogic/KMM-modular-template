package feature.dashboard.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import core.base.designsystem.theme.MainAppTheme
import core.designsystem.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


class HomeView : Screen {
    @Composable
    override fun Content() {
        Scaffold {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text("Flag Quizz", style = MaterialTheme.typography.displayMedium)
                    Text(
                        "Guest The Country Name by Flag",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                Spacer(modifier = Modifier.height(MainAppTheme.spacing.xxl))

                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(onClick = {}){
                        Text("Start a Game")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeViewPreview() {
    AppTheme {
        HomeView().Content()
    }
}