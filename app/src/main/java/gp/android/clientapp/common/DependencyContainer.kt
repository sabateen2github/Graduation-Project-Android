package gp.android.clientapp.common

import android.content.Context
import gp.android.clientapp.data.Deployment
import gp.android.clientapp.data.QueuesRepository
import gp.backend.api.ActiveQueuesApi
import kotlinx.coroutines.Dispatchers

class DependencyContainer(val context: Context) {
    val activeQueuesApi: ActiveQueuesApi by lazy { ActiveQueuesApi(Deployment.backendUrl) }

    val repository: QueuesRepository by lazy { QueuesRepository(Dispatchers.IO, activeQueuesApi) }

    companion object {
        fun createInstance(context: Context) = DependencyContainer(context)
    }

}

