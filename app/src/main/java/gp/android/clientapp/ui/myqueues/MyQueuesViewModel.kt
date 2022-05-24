package gp.android.clientapp.ui.myqueues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import gp.android.clientapp.data.QueuesRepository
import gp.backend.model.BookedTurnQueue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class MyQueuesUIState(
    val isLoading: Boolean,
    val activeQueues: List<BookedTurnQueue>,
    val archivedQueues: List<BookedTurnQueue>
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
            val activeQueues = queuesRepository.getActiveQueues(userId)
            val archivedQueues = queuesRepository.getArchivedQueues(userId)

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


