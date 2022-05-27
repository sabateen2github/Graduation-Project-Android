# FileServingControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getFile**](FileServingControllerApi.md#getFile) | **GET** /files/{filename} | 


<a name="getFile"></a>
# **getFile**
> java.io.File getFile(filename)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = FileServingControllerApi()
val filename : kotlin.String = filename_example // kotlin.String | 
try {
    val result : java.io.File = apiInstance.getFile(filename)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FileServingControllerApi#getFile")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FileServingControllerApi#getFile")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filename** | **kotlin.String**|  |

### Return type

[**java.io.File**](java.io.File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

