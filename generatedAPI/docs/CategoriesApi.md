# CategoriesApi

All URIs are relative to *http://petstore.swagger.io/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCategories**](CategoriesApi.md#getCategories) | **GET** /branches/{id}/categories | 


<a name="getCategories"></a>
# **getCategories**
> kotlin.collections.List&lt;QueueCategory&gt; getCategories(id)



Nothing.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = CategoriesApi()
val id : kotlin.String = id_example // kotlin.String | the branch Id
try {
    val result : kotlin.collections.List<QueueCategory> = apiInstance.getCategories(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CategoriesApi#getCategories")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CategoriesApi#getCategories")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**| the branch Id |

### Return type

[**kotlin.collections.List&lt;QueueCategory&gt;**](QueueCategory.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

