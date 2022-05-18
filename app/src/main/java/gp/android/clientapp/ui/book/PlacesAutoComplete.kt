package gp.android.clientapp.ui.book

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode

data class PlacesAutoCompleteResult(val latLng: LatLng?, val latLngBounds: LatLngBounds?)

class PlacesAutoComplete : ActivityResultContract<String?, PlacesAutoCompleteResult?>() {

    override fun createIntent(context: Context, input: String?): Intent {
        val fields = listOf(Place.Field.LAT_LNG, Place.Field.VIEWPORT)

        // Start the autocomplete intent.
        return Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields)
            .build(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): PlacesAutoCompleteResult? {

        if (resultCode == Activity.RESULT_OK) {
            intent?.let {
                val place = Autocomplete.getPlaceFromIntent(intent)
                return PlacesAutoCompleteResult(place.latLng, place.viewport)
            }
        }
        return null
    }
}