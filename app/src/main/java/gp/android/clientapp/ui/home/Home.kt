package gp.android.clientapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gp.android.clientapp.R
import gp.android.clientapp.ui.NavigationActions


@Composable
fun HomeScreen(navigationActions: NavigationActions) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardButton(text = "My Queues", iconId = R.drawable.queue) {
                navigationActions.navigateToMyQueues()
            }
            Spacer(modifier = Modifier.height(16.dp))
            CardButton(text = "Book a turn", iconId = R.drawable.join_queue) {
                println("ds 1")
            }
        }
    }
}

@Composable
fun CardButton(text: String, iconId: Int, onClick: () -> Unit) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { onClick() }
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = "Join Queue",
                modifier = Modifier.size(96.dp, 96.dp)
            )
            Spacer(modifier = Modifier.height(36.dp))
            Text(text = text, style = MaterialTheme.typography.h6)
        }
    }
}