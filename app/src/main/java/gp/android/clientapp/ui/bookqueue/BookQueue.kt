package gp.android.clientapp.ui.bookqueue

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import gp.android.clientapp.ui.NavigationActions
import gp.android.clientapp.ui.myqueues.AppBar
import gp.backend.model.QueueCategory

@Composable
fun BookQueueScreen(
    viewModel: BookQueueViewModel,
    navigationActions: NavigationActions
) {

    val uiState: BookQueueUIState by viewModel.uiState.collectAsState()

    var viewFAB by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            AppBar(title = "MyQueues") {
                navigationActions.navigateBack()
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            if (viewFAB) {
                FloatingActionButton(
                    modifier = Modifier.width(200.dp),
                    backgroundColor = MaterialTheme.colors.secondary,
                    onClick = { println("FAB Clicked") }) {
                    Text(
                        text = "Book a turn",
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    ) {
        Content(
            paddingValues = it,
            uiState = uiState,
            onCategoryClicked = { queueCategory ->
                viewFAB = true
            },
            onCategoryCancelled = {
                viewFAB = false;
            }
        )
    }
}

@Composable
fun Content(
    paddingValues: PaddingValues,
    uiState: BookQueueUIState,
    onCategoryClicked: (QueueCategory) -> Unit,
    onCategoryCancelled: () -> Unit
) {

    var selected by remember {
        mutableStateOf(null as Any?)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = paddingValues,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        items(uiState.categories) { item ->
            QueueCategory(
                queue = item, checked = (item == selected), onCheck = {
                    if (it) {
                        selected = item;
                        onCategoryClicked(item)
                    } else {
                        selected = null;
                        onCategoryCancelled()
                    }
                })
        }

        item {
            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QueueCategory(queue: QueueCategory, checked: Boolean, onCheck: (Boolean) -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
            .wrapContentHeight(),
        onClick = {
            onCheck(!checked)
        }
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

            AnimatedVisibility(visible = checked) {
                Column {
                    Divider(modifier = Modifier.height(1.dp))
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