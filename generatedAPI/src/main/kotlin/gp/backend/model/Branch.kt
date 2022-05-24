/**
 * OpenAPI definition
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
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
 * @param name 
 * @param id 
 * @param phone 
 * @param instituteId 
 */

data class Branch (

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "id")
    val id: kotlin.String? = null,

    @Json(name = "phone")
    val phone: kotlin.String? = null,

    @Json(name = "instituteId")
    val instituteId: kotlin.String? = null

)
