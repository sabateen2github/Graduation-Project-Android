package gp.android.clientapp.common

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import gp.android.clientapp.data.Deployment
import gp.android.clientapp.data.QueuesRepository
import gp.backend.api.ActiveQueuesApi
import gp.backend.api.BookingApi
import gp.backend.api.CategoriesApi
import kotlinx.coroutines.Dispatchers

class DependencyContainer(private val context: Context) {

    private val activeQueuesApi: ActiveQueuesApi by lazy { ActiveQueuesApi(Deployment.backendUrl) }
    private val categoriesApi: CategoriesApi by lazy { CategoriesApi(Deployment.backendUrl) }
    private val bookingApi: BookingApi by lazy { BookingApi(Deployment.backendUrl) }
    val repository: QueuesRepository by lazy {
        QueuesRepository(
            Dispatchers.IO,
            activeQueuesApi,
            categoriesApi,
            bookingApi
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

