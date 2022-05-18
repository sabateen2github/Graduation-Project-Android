package gp.android.clientapp.ui.book

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import gp.android.clientapp.ui.NavigationActions


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BookTurnScreen(navigationActions: NavigationActions, viewModel: BookingViewModel) {
    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )

    if (locationPermissionsState.allPermissionsGranted) {
        BookTurnContent(navigationActions, viewModel)
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val allPermissionsRevoked =
                locationPermissionsState.permissions.size ==
                        locationPermissionsState.revokedPermissions.size

            val textToShow = if (!allPermissionsRevoked) {
                // If not all the permissions are revoked, it's because the user accepted the COARSE
                // location permission, but not the FINE one.
                "Yay! Thanks for letting me access your approximate location. " +
                        "But you know what would be great? If you allow me to know where you " +
                        "exactly are. Thank you!"
            } else if (locationPermissionsState.shouldShowRationale) {
                // Both location permissions have been denied
                "Getting your exact location is important for this app. " +
                        "Please grant us fine location. Thank you :D"
            } else {
                // First time the   user sees this feature or the user doesn't want to be asked again
                "This feature requires location permission"
            }

            val buttonText = if (!allPermissionsRevoked) {
                "Allow precise location"
            } else {
                "Request permissions"
            }

            Text(text = textToShow)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { locationPermissionsState.launchMultiplePermissionRequest() }) {
                Text(buttonText)
            }
        }
    }
}

@Composable
fun BookTurnContent(navigationActions: NavigationActions, bookingViewModel: BookingViewModel) {

    val userLocation: CurrentLocationState by bookingViewModel.locationState.collectAsState()
    val uiState: BookingUIState by bookingViewModel.uiState.collectAsState()

    var selectedMarker: BranchDescription? by remember {
        mutableStateOf(null)
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(userLocation.latLng, userLocation.zoom.toFloat())
    }

    LaunchedEffect(cameraPositionState.position) {
        if (!cameraPositionState.isMoving)
            bookingViewModel.onMapBoundsChanged(cameraPositionState.position)
    }

    LaunchedEffect(userLocation) {
        cameraPositionState.move(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition.fromLatLngZoom(
                    userLocation.latLng,
                    userLocation.zoom.toFloat()
                )
            )
        )
    }

    val launcher = rememberLauncherForActivityResult(PlacesAutoComplete()) { searchResult ->
        searchResult?.let {
            bookingViewModel.handleSearchResultSelected(it)
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            onMapClick = {
                selectedMarker = null
            }
        ) {
            for (item in uiState.branches) {
                Marker(
                    position = item.latLng,
                    tag = item,
                    title = "${item.name}",
                    onClick = {
                        selectedMarker = item
                        it.showInfoWindow()
                        true
                    })
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            MapSearchBar(navigationActions) {
                launcher.launch("AutoComplete")
            }
            Spacer(modifier = Modifier.weight(1.0f))

            AnimatedVisibility(
                visible = selectedMarker != null,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                FloatingActionButton(
                    modifier = Modifier.width(200.dp),
                    backgroundColor = MaterialTheme.colors.secondary,
                    onClick = { navigationActions.navigateToBranch(selectedMarker!!) }) {
                    Text(
                        text = "Book a turn",
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.h6
                    )
                }
            }


            Spacer(modifier = Modifier.height(8.dp))

        }

    }
}


@Composable
fun MapSearchBar(navigationActions: NavigationActions, callback: () -> Unit) {

    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(25.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            TopAppBar(
                title = { Text("Map search") },
                backgroundColor = MaterialTheme.colors.surface,
                navigationIcon = {
                    IconButton(onClick = navigationActions.navigateBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Arrow Back")
                    }
                },
                actions = {
                    IconButton(onClick = callback) {
                        Icon(Icons.Filled.Search, contentDescription = "Search Places")
                    }
                }
            )
        }
    }


}