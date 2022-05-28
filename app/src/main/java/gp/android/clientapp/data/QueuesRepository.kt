package gp.android.clientapp.data

import gp.backend.api.QueueControllerApi
import gp.backend.model.BookedTurnQueue
import gp.backend.model.LatLng
import gp.backend.model.Queue
import gp.backend.model.QueueSpec
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class QueuesRepository(
    private val dispatcher: CoroutineDispatcher,
    private val queueControllerApi: QueueControllerApi
) {

    private val cache: MutableMap<String, BookedTurnQueue> = HashMap()

    suspend fun getActiveQueues(userId: String): Result<List<BookedTurnQueue>> {
        return withContext(dispatcher) {
            try {
                val queues = queueControllerApi.getActiveQueues(userId)
                cache.clear()
  
                queues.forEach { cache[it.turnId!!] = it }
                Result.success(queues)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun getArchivedQueues(userId: String): Result<List<BookedTurnQueue>> {
        return withContext(dispatcher) {
            try {
                val queues = queueControllerApi.getArchivedQueues(userId)
                cache.clear()
                queues.forEach { cache[it.turnId!!] = it }
                Result.success(queues)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun getBranchCategories(branchId: String): Result<List<QueueSpec>> {
        return withContext(dispatcher) {
            try {
                val queues = queueControllerApi.getAllQueueSpecs(branchId)
                Result.success(queues)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun getAllQueues(instituteId: String, branchId: String): Result<List<Queue>> {
        return withContext(dispatcher) {
            try {
                val queues = queueControllerApi.getAllQueues(instituteId, branchId)
                Result.success(queues)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun bookATurn(category: QueueSpec, uuid: String, latlng: LatLng): Result<Int> {

        return withContext(dispatcher) {
            try {
                queueControllerApi.bookQueue(
                    userId = uuid,
                    branchId = category.branchId!!,
                    queueId = category.id!!,
                    location = latlng
                );
                println("Book a turn ${category} ${uuid} ${latlng} sucess")
                Result.success(201)
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure(e)
            }
        }
    }

    fun getQueueByTurnId(turnId: String): BookedTurnQueue {
        return cache[turnId]!!
    }
}


