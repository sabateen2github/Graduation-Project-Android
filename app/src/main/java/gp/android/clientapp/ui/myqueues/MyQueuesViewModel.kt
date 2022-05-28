package gp.android.clientapp.ui.myqueues

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import gp.android.clientapp.data.QueuesRepository
import gp.backend.model.BookedTurnQueue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


data class MyQueuesUIState(
    val isLoading: Boolean,
    val activeQueues: List<BookedTurnQueue>,
    val archivedQueues: List<BookedTurnQueue>
)

class MyQueuesViewModel(
    private val queuesRepository: QueuesRepository,
    private val context: Context
) : ViewModel() {

    private val internalUIState = MutableStateFlow(MyQueuesUIState(true, listOf(), listOf()))

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

            withContext(Dispatchers.IO) {
                val adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context)
                val userId = adInfo?.id

                val activeQueues = queuesRepository.getActiveQueues(userId!!)
                val archivedQueues = queuesRepository.getArchivedQueues(userId!!)
                withContext(Dispatchers.Main) {
                    activeQueues.onSuccess { active ->
                        archivedQueues.onSuccess { archived ->
                            internalUIState.update {
                                it.copy(
                                    isLoading = false,
                                    activeQueues = active,
                                    archivedQueues = archived
                                )
                            }
                        }.onFailure {
                            it.printStackTrace()
                        }
                    }.onFailure {
                        it.printStackTrace()
                    }
                }
            }

        }
    }

    companion object {
        fun provideFactory(
            repository: QueuesRepository,
            context: Context
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MyQueuesViewModel(context = context, queuesRepository = repository) as T
                }
            }
    }
}


