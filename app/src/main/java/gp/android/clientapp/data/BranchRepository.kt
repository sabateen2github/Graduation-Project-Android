import gp.backend.api.BranchesControllerApi
import gp.backend.model.Branch
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BranchRepository(
    private val dispatcher: CoroutineDispatcher,
    private val branchesControllerApi: BranchesControllerApi
) {

    suspend fun getAllBranches(): Result<List<Branch>> {
        return withContext(dispatcher) {
            try {
                val branches = branchesControllerApi.getAllBranches()
                Result.success(branches)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

}