package gp.android.clientapp.common

import BranchRepository
import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import gp.android.clientapp.data.Deployment
import gp.android.clientapp.data.QueuesRepository
import gp.backend.api.BranchesControllerApi
import gp.backend.api.QueueControllerApi
import kotlinx.coroutines.Dispatchers

class DependencyContainer(private val context: Context) {

    private val queueControllerApi by lazy { QueueControllerApi(Deployment.backendUrl) }
    private val branchesControllerApi by lazy { BranchesControllerApi(Deployment.backendUrl) }


    val branchRepository: BranchRepository by lazy {
        BranchRepository(Dispatchers.IO, branchesControllerApi)
    }

    val repository: QueuesRepository by lazy {
        QueuesRepository(
            Dispatchers.IO,
            queueControllerApi
        )
    }

    val fusedLocationProviderClient: FusedLocationProviderClient by lazy {
        FusedLocationProviderClient(
            context
        )
    }

    companion object {
        fun createInstance(context: Context) = DependencyContainer(context)
    }

}

