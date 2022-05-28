package gp.android.clientapp.ui.bookqueue

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.model.LatLng
import gp.android.clientapp.data.QueuesRepository
import gp.android.clientapp.ui.book.CancellationTokenLocation
import gp.android.clientapp.ui.book.CurrentLocationState
import gp.backend.model.Queue
import gp.backend.model.QueueSpec
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class BookQueueUIState(
    val booked: Boolean,
    val isLoading: Boolean,
    val categories: List<Queue>
)

class BookQueueViewModel(
    private val context: Context,
    private val instituteId: String,
    private val branchId: String,
    private val queuesRepository: QueuesRepository,
    private val fusedLocationProviderClient: FusedLocationProviderClient
) : ViewModel() {

    val locationState =
        MutableStateFlow(CurrentLocationState(LatLng(31.98437874654624, 35.85229584918632), 12))

    private val internalUIState = MutableStateFlow(
        BookQueueUIState(
            booked = false,
            isLoading = true,
            categories = listOf()
        )
    )

    val uiState = internalUIState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        internalUIState.value
    )


    init {
        refresh()
    }

    private fun refresh() {
        internalUIState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = queuesRepository.getAllQueues(instituteId, branchId)
            result.onSuccess { newList ->
                internalUIState.update {
                    it.copy(
                        isLoading = false,
                        categories = newList,
                    )
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }


    @SuppressLint("MissingPermission")
    fun bookQueue(category: QueueSpec) {
        internalUIState.update { it.copy(isLoading = true) }


        val locationTask =
            fusedLocationProviderClient.getCurrentLocation(
                LocationRequest.PRIORITY_HIGH_ACCURACY,
                CancellationTokenLocation()
            )
        locationTask.addOnSuccessListener { location ->
            locationState.update {
                it.copy().apply {
                    latLng = LatLng(location.latitude, location.longitude)
                    zoom = 12
                }
            }
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    val adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context)
                    val adId = adInfo?.id

                    queuesRepository.bookATurn(
                        category = category,
                        uuid = adId!!,
                        gp.backend.model.LatLng(
                            lat = locationState.value.latLng.latitude,
                            lng = locationState.value.latLng.longitude
                        )
                    )
                }
                internalUIState.update { it.copy(isLoading = false, booked = true) }
            }
        }.addOnFailureListener {
            it.printStackTrace();
            internalUIState.update { it.copy(isLoading = false, booked = false) }
        }
    }


    companion object {
        fun provideFactory(
            context: Context,
            branchID: String,
            instituteId: String,
            repository: QueuesRepository,
            fusedLocationProviderClient: FusedLocationProviderClient
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return BookQueueViewModel(
                        context = context,
                        branchId = branchID,
                        instituteId = instituteId,
                        queuesRepository = repository,
                        fusedLocationProviderClient = fusedLocationProviderClient
                    ) as T
                }
            }
    }


}