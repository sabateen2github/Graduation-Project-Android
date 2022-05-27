# InstituteControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInstitute**](InstituteControllerApi.md#createInstitute) | **POST** /institute | 
[**deleteInstitute**](InstituteControllerApi.md#deleteInstitute) | **DELETE** /institute/{id} | 
[**getInstitute**](InstituteControllerApi.md#getInstitute) | **GET** /institute/{id} | 
[**searchInstitutes**](InstituteControllerApi.md#searchInstitutes) | **GET** /institute | 
[**updateInstitute**](InstituteControllerApi.md#updateInstitute) | **PUT** /institute | 


<a name="createInstitute"></a>
# **createInstitute**
> createInstitute(inlineObject1)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = InstituteControllerApi()
val inlineObject1 : InlineObject1 =  // InlineObject1 | 
try {
    apiInstance.createInstitute(inlineObject1)
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
 **inlineObject1** | [**InlineObject1**](InlineObject1.md)|  | [optional]

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

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


Configure bearerAuth:
    ApiClient.accessToken = ""

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
> updateInstitute(inlineObject)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = InstituteControllerApi()
val inlineObject : InlineObject =  // InlineObject | 
try {
    apiInstance.updateInstitute(inlineObject)
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
 **inlineObject** | [**InlineObject**](InlineObject.md)|  | [optional]

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

