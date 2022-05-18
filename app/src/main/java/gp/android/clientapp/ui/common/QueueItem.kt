package gp.android.clientapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import gp.android.clientapp.R

@Composable
fun QueueItem(
    logoURL: String,
    title: String,
    details: String,
    onMapClicked: () -> Unit,
    onClick: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth(0.95f)
        .clickable { onClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {


            GlideImage(
                imageModel = logoURL,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
                contentDescription = title,
                modifier = Modifier.size(96.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .weight(1.0f)
            ) {
                Text(text = title, style = MaterialTheme.typography.h6)
                Text(text = details, style = MaterialTheme.typography.h6)
            }
            FloatingActionButton(
                modifier = Modifier.size(36.dp),
                onClick = onMapClicked
            ) {
                Image(
                    painter = painterResource(id = R.drawable.maps_icon),
                    contentDescription = "maps icon",
                )
            }
        }
    }
}