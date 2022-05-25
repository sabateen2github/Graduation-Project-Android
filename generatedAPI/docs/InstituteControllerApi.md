# InstituteControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInstitute**](InstituteControllerApi.md#createInstitute) | **POST** /institute | 
[**deleteInstitute**](InstituteControllerApi.md#deleteInstitute) | **DELETE** /institute/{id} | 
[**getInstitute**](InstituteControllerApi.md#getInstitute) | **GET** /institute/{id} | 
[**searchInstitutes**](InstituteControllerApi.md#searchInstitutes) | **GET** /institute | 
[**updateInstitute**](InstituteControllerApi.md#updateInstitute) | **PUT** /institute/{id} | 


<a name="createInstitute"></a>
# **createInstitute**
> createInstitute(institute)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = InstituteControllerApi()
val institute : Institute =  // Institute | 
try {
    apiInstance.createInstitute(institute)
} catch (e: ClientException) {
    println("4xx response calling InstituteControllerApi#createInstitute")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstituteControllerApi#createInstitute")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **institute** | [**Institute**](Institute.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteInstitute"></a>
# **deleteInstitute**
> deleteInstitute(id)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = InstituteControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    apiInstance.deleteInstitute(id)
} catch (e: ClientException) {
    println("4xx response calling InstituteControllerApi#deleteInstitute")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstituteControllerApi#deleteInstitute")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getInstitute"></a>
# **getInstitute**
> Institute getInstitute(id)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = InstituteControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : Institute = apiInstance.getInstitute(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InstituteControllerApi#getInstitute")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstituteControllerApi#getInstitute")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**Institute**](Institute.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="searchInstitutes"></a>
# **searchInstitutes**
> kotlin.collections.List&lt;Institute&gt; searchInstitutes(searchTerms)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = InstituteControllerApi()
val searchTerms : kotlin.String = searchTerms_example // kotlin.String | 
try {
    val result : kotlin.collections.List<Institute> = apiInstance.searchInstitutes(searchTerms)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InstituteControllerApi#searchInstitutes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstituteControllerApi#searchInstitutes")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **searchTerms** | **kotlin.String**|  | [optional]

### Return type

[**kotlin.collections.List&lt;Institute&gt;**](Institute.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="updateInstitute"></a>
# **updateInstitute**
> updateInstitute(id, institute)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = InstituteControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val institute : Institute =  // Institute | 
try {
    apiInstance.updateInstitute(id, institute)
} catch (e: ClientException) {
    println("4xx response calling InstituteControllerApi#updateInstitute")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstituteControllerApi#updateInstitute")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **institute** | [**Institute**](Institute.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

