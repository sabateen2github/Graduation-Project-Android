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
 * @param name 
 * @param id 
 * @param fullName 
 * @param dateOfBirth 
 * @param username 
 * @param password 
 * @param profilePic 
 * @param email 
 * @param phone 
 * @param branchId 
 * @param accountType 
 */

data class Employee (

    @Json(name = "name")
    val name: kotlin.String? = null,

    @Json(name = "id")
    val id: kotlin.String? = null,

    @Json(name = "fullName")
    val fullName: kotlin.String? = null,

    @Json(name = "dateOfBirth")
    val dateOfBirth: java.time.OffsetDateTime? = null,

    @Json(name = "username")
    val username: kotlin.String? = null,

    @Json(name = "password")
    val password: kotlin.String? = null,

    @Json(name = "profilePic")
    val profilePic: kotlin.String? = null,

    @Json(name = "email")
    val email: kotlin.String? = null,

    @Json(name = "phone")
    val phone: kotlin.String? = null,

    @Json(name = "branchId")
    val branchId: kotlin.String? = null,

    @Json(name = "accountType")
    val accountType: Employee.AccountType? = null

) {

    /**
     * 
     *
     * Values: hELPDESK,mANAGEMENT,aDMIN
     */
    enum class AccountType(val value: kotlin.String) {
        @Json(name = "ROLE_HELP_DESK") hELPDESK("ROLE_HELP_DESK"),
        @Json(name = "ROLE_MANAGEMENT") mANAGEMENT("ROLE_MANAGEMENT"),
        @Json(name = "ROLE_ADMIN") aDMIN("ROLE_ADMIN");
    }
}

