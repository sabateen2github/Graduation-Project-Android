package gp.android.clientapp.common

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import gp.android.clientapp.data.Deployment
import gp.android.clientapp.data.QueuesRepository
import gp.backend.api.QueueControllerApi
import kotlinx.coroutines.Dispatchers

class DependencyContainer(private val context: Context) {

    private val queueControllerApi by lazy { QueueControllerApi(Deployment.backendUrl) }
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

