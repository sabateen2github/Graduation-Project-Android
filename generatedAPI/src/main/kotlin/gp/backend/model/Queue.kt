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
 * @param logo 
 * @param state 
 * @param category 
 * @param turnId 
 * @param position 
 * @param queueSize 
 * @param physicalSize 
 * @param remoteQueueSize 
 * @param averageTime 
 */

data class Queue (

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "duration")
    val duration: kotlin.Int,

    @Json(name = "logo")
    val logo: kotlin.String,

    @Json(name = "state")
    val state: Queue.State,

    @Json(name = "category")
    val category: kotlin.String,

    @Json(name = "turnId")
    val turnId: kotlin.Int,

    @Json(name = "position")
    val position: kotlin.Int,

    @Json(name = "queueSize")
    val queueSize: kotlin.Int,

    @Json(name = "physicalSize")
    val physicalSize: kotlin.Int,

    @Json(name = "remoteQueueSize")
    val remoteQueueSize: kotlin.Int,

    @Json(name = "averageTime")
    val averageTime: kotlin.Int

) {

    /**
     * 
     *
     * Values: active,cancelled,completed
     */
    enum class State(val value: kotlin.String) {
        @Json(name = "Active") active("Active"),
        @Json(name = "Cancelled") cancelled("Cancelled"),
        @Json(name = "Completed") completed("Completed");
    }
}
