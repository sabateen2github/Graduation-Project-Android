package gp.android.clientapp.data

import gp.backend.api.ActiveQueuesApi
import gp.backend.model.Queue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class QueuesRepository(
    private val dispatcher: CoroutineDispatcher,
    private val activeQueuesApi: ActiveQueuesApi
) {

    private val cache: MutableMap<Int, Queue> = HashMap()

    suspend fun getActiveQueues(userId: String): Result<List<Queue>> {
        return withContext(dispatcher) {
            try {
                val queues = activeQueuesApi.getActiveQueues(userId)
                cache.clear()
                queues.forEach { cache[it.turnId] = it }
                Result.success(queues)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    fun getQueueByTurnId(turnId: Int): Queue {
        return cache[turnId]!!
    }
}


