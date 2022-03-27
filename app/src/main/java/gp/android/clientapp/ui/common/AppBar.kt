package gp.android.clientapp.ui.myqueues

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun AppBar(title: String, onBack: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        backgroundColor = MaterialTheme.colors.surface,
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Arrow Back")
            }
        })
}