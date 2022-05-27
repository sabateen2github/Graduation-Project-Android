# QueueControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**advanceQueue**](QueueControllerApi.md#advanceQueue) | **PUT** /queues/queue/advance | 
[**bookQueue**](QueueControllerApi.md#bookQueue) | **PUT** /queues/queue/book | 
[**cancelTurn**](QueueControllerApi.md#cancelTurn) | **DELETE** /queues/queue/book | 
[**deleteQueue**](QueueControllerApi.md#deleteQueue) | **DELETE** /queues/queue | 
[**editQueueSpec**](QueueControllerApi.md#editQueueSpec) | **PUT** /queues/queue | 
[**getActiveQueues**](QueueControllerApi.md#getActiveQueues) | **GET** /queues/active/{userId} | 
[**getAllQueueSpecs**](QueueControllerApi.md#getAllQueueSpecs) | **GET** /queues/spec/all | 
[**getAllQueues**](QueueControllerApi.md#getAllQueues) | **GET** /queues/queues/all | 
[**getArchivedQueues**](QueueControllerApi.md#getArchivedQueues) | **GET** /queues/archived/{userId} | 
[**getQueue**](QueueControllerApi.md#getQueue) | **GET** /queues/queue | 
[**resetQueue**](QueueControllerApi.md#resetQueue) | **PUT** /queues/queue/reset | 
[**switchUserLocationMode**](QueueControllerApi.md#switchUserLocationMode) | **PUT** /queues/queue/book/toggle | 


<a name="advanceQueue"></a>
# **advanceQueue**
> advanceQueue(id, branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    apiInstance.advanceQueue(id, branchId)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#advanceQueue")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#advanceQueue")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **branchId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="bookQueue"></a>
# **bookQueue**
> bookQueue(userId, queueId, branchId, location)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val userId : kotlin.String = userId_example // kotlin.String | 
val queueId : kotlin.String = queueId_example // kotlin.String | 
val branchId : kotlin.String = branchId_example // kotlin.String | 
val location : LatLng =  // LatLng | 
try {
    apiInstance.bookQueue(userId, queueId, branchId, location)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#bookQueue")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#bookQueue")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |
 **queueId** | **kotlin.String**|  |
 **branchId** | **kotlin.String**|  |
 **location** | [**LatLng**](.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="cancelTurn"></a>
# **cancelTurn**
> cancelTurn(userId, queueId, branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val userId : kotlin.String = userId_example // kotlin.String | 
val queueId : kotlin.String = queueId_example // kotlin.String | 
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    apiInstance.cancelTurn(userId, queueId, branchId)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#cancelTurn")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#cancelTurn")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |
 **queueId** | **kotlin.String**|  |
 **branchId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteQueue"></a>
# **deleteQueue**
> deleteQueue(id, branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    apiInstance.deleteQueue(id, branchId)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#deleteQueue")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#deleteQueue")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **branchId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="editQueueSpec"></a>
# **editQueueSpec**
> editQueueSpec(queueSpec)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val queueSpec : QueueSpec =  // QueueSpec | 
try {
    apiInstance.editQueueSpec(queueSpec)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#editQueueSpec")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#editQueueSpec")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queueSpec** | [**QueueSpec**](QueueSpec.md)|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getActiveQueues"></a>
# **getActiveQueues**
> kotlin.collections.List&lt;BookedTurnQueue&gt; getActiveQueues(userId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : kotlin.collections.List<BookedTurnQueue> = apiInstance.getActiveQueues(userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#getActiveQueues")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#getActiveQueues")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |

### Return type

[**kotlin.collections.List&lt;BookedTurnQueue&gt;**](BookedTurnQueue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getAllQueueSpecs"></a>
# **getAllQueueSpecs**
> kotlin.collections.List&lt;QueueSpec&gt; getAllQueueSpecs(branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    val result : kotlin.collections.List<QueueSpec> = apiInstance.getAllQueueSpecs(branchId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#getAllQueueSpecs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#getAllQueueSpecs")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branchId** | **kotlin.String**|  |

### Return type

[**kotlin.collections.List&lt;QueueSpec&gt;**](QueueSpec.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getAllQueues"></a>
# **getAllQueues**
> kotlin.collections.List&lt;Queue&gt; getAllQueues(branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    val result : kotlin.collections.List<Queue> = apiInstance.getAllQueues(branchId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#getAllQueues")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#getAllQueues")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branchId** | **kotlin.String**|  |

### Return type

[**kotlin.collections.List&lt;Queue&gt;**](Queue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getArchivedQueues"></a>
# **getArchivedQueues**
> kotlin.collections.List&lt;BookedTurnQueue&gt; getArchivedQueues(userId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val userId : kotlin.String = userId_example // kotlin.String | 
try {
    val result : kotlin.collections.List<BookedTurnQueue> = apiInstance.getArchivedQueues(userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#getArchivedQueues")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#getArchivedQueues")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **kotlin.String**|  |

### Return type

[**kotlin.collections.List&lt;BookedTurnQueue&gt;**](BookedTurnQueue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getQueue"></a>
# **getQueue**
> Queue getQueue(id, branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    val result : Queue = apiInstance.getQueue(id, branchId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#getQueue")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#getQueue")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **branchId** | **kotlin.String**|  |

### Return type

[**Queue**](Queue.md)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="resetQueue"></a>
# **resetQueue**
> resetQueue(id, branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    apiInstance.resetQueue(id, branchId)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#resetQueue")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#resetQueue")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **branchId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="switchUserLocationMode"></a>
# **switchUserLocationMode**
> switchUserLocationMode(instituteId, userId, queueId, branchId)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = QueueControllerApi()
val instituteId : kotlin.String = instituteId_example // kotlin.String | 
val userId : kotlin.String = userId_example // kotlin.String | 
val queueId : kotlin.String = queueId_example // kotlin.String | 
val branchId : kotlin.String = branchId_example // kotlin.String | 
try {
    apiInstance.switchUserLocationMode(instituteId, userId, queueId, branchId)
} catch (e: ClientException) {
    println("4xx response calling QueueControllerApi#switchUserLocationMode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling QueueControllerApi#switchUserLocationMode")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **instituteId** | **kotlin.String**|  |
 **userId** | **kotlin.String**|  |
 **queueId** | **kotlin.String**|  |
 **branchId** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

