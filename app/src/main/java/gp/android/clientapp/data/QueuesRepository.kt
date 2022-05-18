package gp.android.clientapp.data

import gp.backend.api.ActiveQueuesApi
import gp.backend.api.BookingApi
import gp.backend.api.CategoriesApi
import gp.backend.model.BookTurn
import gp.backend.model.Queue
import gp.backend.model.QueueCategory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class QueuesRepository(
    private val dispatcher: CoroutineDispatcher,
    private val activeQueuesApi: ActiveQueuesApi,
    private val categoriesApi: CategoriesApi,
    private val bookingApi: BookingApi
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

    suspend fun getBranchCategories(branchId: String): Result<List<QueueCategory>> {
        return withContext(dispatcher) {
            try {
                val queues = categoriesApi.getCategories(branchId)
                Result.success(queues)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun bookATurn(branchId: String, category: String, uuid: String): Result<Int> {
        return withContext(dispatcher) {
            try {
                val bookTurnRequest = BookTurn(uuid = uuid, category = category)
                bookingApi.bookATurn(branchId, bookTurnRequest)
                Result.success(201)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    fun getQueueByTurnId(turnId: Int): Queue {
        return cache[turnId]!!
    }
}


