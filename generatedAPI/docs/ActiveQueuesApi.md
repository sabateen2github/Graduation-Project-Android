# ActiveQueuesApi

All URIs are relative to *http://petstore.swagger.io/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActiveQueues**](ActiveQueuesApi.md#getActiveQueues) | **GET** /activeQueues/{id} | 


<a name="getActiveQueues"></a>
# **getActiveQueues**
> kotlin.collections.List&lt;Queue&gt; getActiveQueues(id)



Nothing. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = ActiveQueuesApi()
val id : kotlin.String = id_example // kotlin.String | the user ID
try {
    val result : kotlin.collections.List<Queue> = apiInstance.getActiveQueues(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ActiveQueuesApi#getActiveQueues")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActiveQueuesApi#getActiveQueues")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**| the user ID |

### Return type

[**kotlin.collections.List&lt;Queue&gt;**](Queue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

