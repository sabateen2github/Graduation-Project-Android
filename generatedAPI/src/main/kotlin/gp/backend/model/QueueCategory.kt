/**
 * Smartphone Backend
 *
 * Smartphone Customer backend specification
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: alsabateen.alaa@gmail.com
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
 * @param name 
 * @param duration 
 * @param category 
 * @param queueSize 
 * @param physicalSize 
 * @param remoteQueueSize 
 * @param averageTime 
 */

data class QueueCategory (

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "duration")
    val duration: kotlin.Int,

    @Json(name = "category")
    val category: kotlin.String,

    @Json(name = "queueSize")
    val queueSize: kotlin.Int,

    @Json(name = "physicalSize")
    val physicalSize: kotlin.Int,

    @Json(name = "remoteQueueSize")
    val remoteQueueSize: kotlin.Int,

    @Json(name = "averageTime")
    val averageTime: kotlin.Int

)
