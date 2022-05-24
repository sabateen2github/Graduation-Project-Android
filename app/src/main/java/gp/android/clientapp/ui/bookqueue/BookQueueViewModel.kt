package gp.android.clientapp.ui.bookqueue

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import gp.android.clientapp.data.QueuesRepository
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
    private val branchId: String,
    private val queuesRepository: QueuesRepository
) : ViewModel() {

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
            val result = queuesRepository.getAllQueues(branchId)
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


    fun bookQueue(category: QueueSpec) {
        internalUIState.update { it.copy(isLoading = true) }

        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                val adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context)
                val adId = adInfo?.id
                queuesRepository.bookATurn(category = category, adId!!)
            }
            internalUIState.update { it.copy(isLoading = false, booked = true) }
        }


    }


    companion object {
        fun provideFactory(
            context: Context,
            branchID: String,
            repository: QueuesRepository
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return BookQueueViewModel(context, branchID, repository) as T
                }
            }
    }


}