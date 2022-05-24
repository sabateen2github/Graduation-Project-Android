package gp.android.clientapp.ui.status

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import gp.android.clientapp.data.QueuesRepository
import gp.backend.model.BookedTurnQueue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

data class QueueStatusUIState(
    val queue: BookedTurnQueue
)

class QueueStatusViewModel(
    private val turnId: Int,
    private val queuesRepository: QueuesRepository
) : ViewModel() {

    private val internalUIState =
        MutableStateFlow(QueueStatusUIState(queue = queuesRepository.getQueueByTurnId(turnId)));

    val uiState = internalUIState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        internalUIState.value
    )


    companion object {
        fun provideFactory(
            turnId: Int,
            repository: QueuesRepository
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return QueueStatusViewModel(turnId, repository) as T
                }
            }
    }
}
