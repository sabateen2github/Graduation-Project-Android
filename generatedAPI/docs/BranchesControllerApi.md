# BranchesControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBranch**](BranchesControllerApi.md#createBranch) | **POST** /branches | 
[**getAllBranches**](BranchesControllerApi.md#getAllBranches) | **GET** /branches | 
[**getBranch**](BranchesControllerApi.md#getBranch) | **GET** /branches/{id} | 
[**updateBranch**](BranchesControllerApi.md#updateBranch) | **PUT** /branches/{id} | 


<a name="createBranch"></a>
# **createBranch**
> createBranch(branch)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = BranchesControllerApi()
val branch : Branch =  // Branch | 
try {
    apiInstance.createBranch(branch)
} catch (e: ClientException) {
    println("4xx response calling BranchesControllerApi#createBranch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BranchesControllerApi#createBranch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | [**Branch**](Branch.md)|  | [optional]

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getAllBranches"></a>
# **getAllBranches**
> kotlin.collections.List&lt;Branch&gt; getAllBranches()



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = BranchesControllerApi()
try {
    val result : kotlin.collections.List<Branch> = apiInstance.getAllBranches()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BranchesControllerApi#getAllBranches")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BranchesControllerApi#getAllBranches")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;Branch&gt;**](Branch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getBranch"></a>
# **getBranch**
> Branch getBranch(id)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = BranchesControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : Branch = apiInstance.getBranch(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BranchesControllerApi#getBranch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BranchesControllerApi#getBranch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**Branch**](Branch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateBranch"></a>
# **updateBranch**
> updateBranch(id, branch)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = BranchesControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val branch : Branch =  // Branch | 
try {
    apiInstance.updateBranch(id, branch)
} catch (e: ClientException) {
    println("4xx response calling BranchesControllerApi#updateBranch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BranchesControllerApi#updateBranch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **branch** | [**Branch**](Branch.md)|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

