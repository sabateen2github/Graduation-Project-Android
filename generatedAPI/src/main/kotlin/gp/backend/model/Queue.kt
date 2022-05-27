/**
 * My API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1
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

import gp.backend.model.QueueSpec

import com.squareup.moshi.Json

/**
 * 
 *
 * @param queueSpec 
 * @param queueSize 
 * @param physicalSize 
 * @param remoteSize 
 * @param averageTime 
 * @param currentTurnId 
 */

data class Queue (

    @Json(name = "queueSpec")
    val queueSpec: QueueSpec? = null,

    @Json(name = "queueSize")
    val queueSize: kotlin.Int? = null,

    @Json(name = "physicalSize")
    val physicalSize: kotlin.Int? = null,

    @Json(name = "remoteSize")
    val remoteSize: kotlin.Int? = null,

    @Json(name = "averageTime")
    val averageTime: kotlin.Int? = null,

    @Json(name = "currentTurnId")
    val currentTurnId: kotlin.String? = null

)

