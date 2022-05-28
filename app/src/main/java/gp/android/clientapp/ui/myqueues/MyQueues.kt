package gp.android.clientapp.ui.myqueues

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gp.android.clientapp.data.Deployment
import gp.android.clientapp.ui.NavigationActions
import gp.android.clientapp.ui.common.QueueItem
import gp.backend.model.BookedTurnQueue


@Composable
fun MyQueuesScreen(navigationActions: NavigationActions, viewModel: MyQueuesViewModel) {


    val uiState: MyQueuesUIState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            AppBar(title = "MyQueues") {
                navigationActions.navigateBack()
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.width(200.dp),
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = { navigationActions.navigateToBooking() }) {
                Text(
                    text = "Book a turn",
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    ) {
        Content(paddingValues = it,
            uiState,
            onItemClicked = { item ->
                navigationActions.navigateToQueueStatus(item.turnId!!)
            },
            onMapClicked = { item ->
                println("Map Clicked: $item")
            })
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Content(
    paddingValues: PaddingValues,
    uiState: MyQueuesUIState,
    onItemClicked: (BookedTurnQueue) -> Unit,
    onMapClicked: (BookedTurnQueue) -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = paddingValues,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        stickyHeader {
            Header(title = "Active")
        }

        items(uiState.activeQueues) { item ->
            QueueItem(
                logoURL = Deployment.backendUrl + item.logoUrl!!,
                title = item.queue!!.queueSpec!!.name!!,
                details = "${item.position!! * (item.queue!!.averageTime!! - 1)} minutes remaining",
                onMapClicked = { onMapClicked(item) },
                onClick = { onItemClicked(item) })
        }

        stickyHeader {
            Header(title = "History")
        }

        items(uiState.archivedQueues) { item ->
            QueueItem(
                logoURL = item.logoUrl!!,
                title = item.queue!!.queueSpec!!.name!!,
                details = item.state!!.value,
                onMapClicked = { onMapClicked(item) },
                onClick = { onItemClicked(item) })
        }

        item {
            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}

@Composable
fun Header(title: String) {
    Surface(
        color = MaterialTheme.colors.background,
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(8.dp)
        )
    }
}


