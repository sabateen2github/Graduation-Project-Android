package gp.android.clientapp.ui.myqueues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import gp.android.clientapp.data.QueuesRepository
import gp.backend.model.Queue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class MyQueuesUIState(
    val isLoading: Boolean,
    val activeQueues: List<Queue>,
    val archivedQueues: List<Queue>
)

class MyQueuesViewModel(
    private val userId: String,
    private val queuesRepository: QueuesRepository
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
            val result = queuesRepository.getActiveQueues(userId)
            result.onSuccess { newList ->
                internalUIState.update {
                    it.copy(
                        isLoading = false,
                        activeQueues = newList,
                        archivedQueues = fakeQueues()
                    )
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    companion object {
        fun provideFactory(
            userId: String,
            repository: QueuesRepository
        ): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MyQueuesViewModel(userId, repository) as T
                }
            }
    }
}


fun fakeQueue(state: Queue.State = Queue.State.completed): Queue {
    return Queue(
        name = "Bank al Etihad",
        logo = "https://financialallianceforwomen.org/wp-content/uploads/2015/07/BAE-Logo-600x600-profile-picture.jpg",
        duration = 43,
        state = state,
        queueSize = 1,
        remoteQueueSize = 1,
        averageTime = 1,
        turnId = 1,
        category = "sd",
        physicalSize = 1,
        position = 1
    )
}

fun fakeQueues(active: Boolean = false): List<Queue> {
    if (active)
        return (1..30).map { fakeQueue(Queue.State.active) }
    return (1..30).map { fakeQueue() }
}