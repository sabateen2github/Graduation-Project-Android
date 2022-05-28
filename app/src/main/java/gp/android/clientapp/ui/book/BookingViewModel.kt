package gp.android.clientapp.ui.book

import BranchRepository
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.OnTokenCanceledListener
import gp.android.clientapp.data.QueuesRepository
import gp.backend.model.Branch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.*


data class BookingUIState(val branches: List<Branch>)

data class CurrentLocationState(var latLng: LatLng, var zoom: Int)

class BookingViewModel(
    private val queuesRepository: QueuesRepository,
    private val branchRepository: BranchRepository
) :
    ViewModel() {

    val locationState =
        MutableStateFlow(CurrentLocationState(LatLng(31.98437874654624, 35.85229584918632), 12))
    val uiState = MutableStateFlow(
        BookingUIState(
            listOf(
                Branch(
                    instituteId = "1",
                    id = "1",
                    phone = "0790332791",
                    location = gp.backend.model.LatLng(
                        31.98437874654624,
                        35.85229584918632
                    ),
                    name = "My first branch"
                )
            )
        )
    )


    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            val branches = branchRepository.getAllBranches()
            branches.onSuccess { branchesList ->
                uiState.update {
                    it.copy(branches = branchesList)
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }


    internal fun handleSearchResultSelected(autoCompleteResult: PlacesAutoCompleteResult) {
        locationState.update {
            it.copy(
                latLng = autoCompleteResult.latLng!!,
                zoom = getBoundsZoomLevel(
                    autoCompleteResult.latLngBounds!!,
                    Resources.getSystem().displayMetrics.widthPixels,
                    Resources.getSystem().displayMetrics.heightPixels
                )
            )
        }
    }

    internal fun onMapBoundsChanged(cameraPosition: CameraPosition) {
        // TODO: Empty Implementation
        println(cameraPosition)
    }


    companion object {
        fun provideFactory(
            queuesRepository: QueuesRepository,
            branchRepository: BranchRepository
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return BookingViewModel(queuesRepository, branchRepository) as T
                }
            }
    }
}

private const val LN2 = 0.6931471805599453
private const val WORLD_PX_HEIGHT = 256
private const val WORLD_PX_WIDTH = 256
private const val ZOOM_MAX = 21

fun getBoundsZoomLevel(bounds: LatLngBounds, mapWidthPx: Int, mapHeightPx: Int): Int {
    val ne = bounds.northeast
    val sw = bounds.southwest
    val latFraction = (latRad(ne.latitude) - latRad(sw.latitude)) / Math.PI
    val lngDiff = ne.longitude - sw.longitude
    val lngFraction = (if (lngDiff < 0) lngDiff + 360 else lngDiff) / 360
    val latZoom = zoom(mapHeightPx, WORLD_PX_HEIGHT, latFraction)
    val lngZoom = zoom(mapWidthPx, WORLD_PX_WIDTH, lngFraction)
    val result = min(latZoom.toInt(), lngZoom.toInt())
    return min(result, ZOOM_MAX)
}

private fun latRad(lat: Double): Double {
    val sin = sin(lat * Math.PI / 180)
    val radX2 = ln((1 + sin) / (1 - sin)) / 2
    return max(min(radX2, Math.PI), -Math.PI) / 2
}

private fun zoom(mapPx: Int, worldPx: Int, fraction: Double): Double {
    return floor(ln(mapPx / worldPx / fraction) / LN2)
}

class CancellationTokenLocation : CancellationToken() {
    override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken {
        println("cancellation requested")
        return this;
    }

    override fun isCancellationRequested(): Boolean {
        println("is Cancellation requested")
        return false;
    }
}