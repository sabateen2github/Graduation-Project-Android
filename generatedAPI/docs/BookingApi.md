# BookingApi

All URIs are relative to *http://petstore.swagger.io/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bookATurn**](BookingApi.md#bookATurn) | **POST** /branches/{id}/book | 


<a name="bookATurn"></a>
# **bookATurn**
> bookATurn(id, bookTurn)



Nothing.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = BookingApi()
val id : kotlin.String = id_example // kotlin.String | branchID
val bookTurn : BookTurn =  // BookTurn | The UUID and the category
try {
    apiInstance.bookATurn(id, bookTurn)
} catch (e: ClientException) {
    println("4xx response calling BookingApi#bookATurn")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BookingApi#bookATurn")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**| branchID |
 **bookTurn** | [**BookTurn**](BookTurn.md)| The UUID and the category |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

