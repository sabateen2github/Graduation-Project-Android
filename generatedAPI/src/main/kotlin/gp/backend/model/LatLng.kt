/**
 * backend-api
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package gp.backend.model


import com.squareup.moshi.Json

/**
 * 
 *
 * @param lng 
 * @param lat 
 */

data class LatLng (

    @Json(name = "lng")
    val lng: kotlin.Double? = null,

    @Json(name = "lat")
    val lat: kotlin.Double? = null

)

