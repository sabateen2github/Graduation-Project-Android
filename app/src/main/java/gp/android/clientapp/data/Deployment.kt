package gp.android.clientapp.data

object Deployment {

    val profile = Profile.LocalTesting

    var backendUrl = ""
        private set

    init {
        backendUrl = when (profile) {
            Profile.LocalTesting -> "http://10.0.2.2:8080"
            else -> "invalid"
        }
    }

}

enum class Profile {
    UnitTesting, AndroidTesting, Production, LocalTesting
}
