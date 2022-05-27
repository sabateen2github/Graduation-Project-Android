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

import gp.backend.model.Institute

import com.squareup.moshi.Json

/**
 * 
 *
 * @param institute 
 * @param profilePic 
 */

data class InlineObject (

    @Json(name = "institute")
    val institute: Institute,

    @Json(name = "profilePic")
    val profilePic: java.io.File

)
