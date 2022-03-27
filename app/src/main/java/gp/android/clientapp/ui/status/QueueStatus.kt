package gp.android.clientapp.ui.status

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import gp.android.clientapp.ui.NavigationActions
import gp.android.clientapp.ui.myqueues.AppBar
import gp.backend.model.Queue


@Composable
fun QueueStatusScreen(navigationActions: NavigationActions, viewModel: QueueStatusViewModel) {

    val uiState: QueueStatusUIState by viewModel.uiState.collectAsState()


    Scaffold(
        topBar = {
            AppBar(title = "Queue Status") {
                navigationActions.navigateBack()
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.width(200.dp),
                backgroundColor = MaterialTheme.colors.error,
                onClick = { println("FAB Clicked") }) {
                Text(
                    text = "Cancel The Turn",
                    color = MaterialTheme.colors.onError,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    ) {
        Content(
            uiState,
            paddingValues = it
        )
    }
}

@Composable
fun Content(
    uiState: QueueStatusUIState,
    paddingValues: PaddingValues,
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QueueDetails(queue = uiState.queue)
        Spacer(modifier = Modifier.height(200.dp))
    }
}

@Composable
fun QueueDetails(queue: Queue) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
            .wrapContentHeight()
    ) {
        Column {
            Text(
                text = queue.category,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Divider(modifier = Modifier.height(1.dp))

            QueueStatusItem(text = "Id: #${queue.turnId}")

            QueueStatusItem(text = "Position: #${queue.position}")
            QueueStatusItem(text = "Queue Size: ${queue.queueSize}")
            QueueStatusItem(text = "Physical Queue Size: ${queue.physicalSize}")
            QueueStatusItem(text = "Waiting Remotely: ${queue.remoteQueueSize}")
            QueueStatusItem(text = "Average Service Time: ${queue.averageTime} minutes")
            when {
                queue.duration < 60 -> QueueStatusItem(text = "Estimated Waiting Time: ${queue.duration} minutes")
                queue.duration % 60 == 0 -> QueueStatusItem(text = "Estimated Waiting Time: ${queue.duration / 60} hours")
                else -> QueueStatusItem(text = "Estimated Waiting Time: ${queue.duration / 60} hours and ${queue.duration % 60} minutes")
            }
        }
    }
}

@Composable
fun QueueStatusItem(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}