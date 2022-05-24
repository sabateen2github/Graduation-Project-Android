# EmployeesControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEmployee**](EmployeesControllerApi.md#createEmployee) | **POST** /employees | 
[**editEmployee**](EmployeesControllerApi.md#editEmployee) | **PUT** /employees/{id} | 
[**getEmployee**](EmployeesControllerApi.md#getEmployee) | **GET** /employees/{id} | 
[**searchEmployees**](EmployeesControllerApi.md#searchEmployees) | **GET** /employees | 


<a name="createEmployee"></a>
# **createEmployee**
> createEmployee(employee)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = EmployeesControllerApi()
val employee : Employee =  // Employee | 
try {
    apiInstance.createEmployee(employee)
} catch (e: ClientException) {
    println("4xx response calling EmployeesControllerApi#createEmployee")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmployeesControllerApi#createEmployee")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **employee** | [**Employee**](Employee.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="editEmployee"></a>
# **editEmployee**
> editEmployee(id, employee)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = EmployeesControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
val employee : Employee =  // Employee | 
try {
    apiInstance.editEmployee(id, employee)
} catch (e: ClientException) {
    println("4xx response calling EmployeesControllerApi#editEmployee")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmployeesControllerApi#editEmployee")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |
 **employee** | [**Employee**](Employee.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getEmployee"></a>
# **getEmployee**
> Employee getEmployee(id)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = EmployeesControllerApi()
val id : kotlin.String = id_example // kotlin.String | 
try {
    val result : Employee = apiInstance.getEmployee(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmployeesControllerApi#getEmployee")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmployeesControllerApi#getEmployee")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.String**|  |

### Return type

[**Employee**](Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="searchEmployees"></a>
# **searchEmployees**
> kotlin.collections.List&lt;Employee&gt; searchEmployees(searchTerm)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = EmployeesControllerApi()
val searchTerm : kotlin.String = searchTerm_example // kotlin.String | 
try {
    val result : kotlin.collections.List<Employee> = apiInstance.searchEmployees(searchTerm)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling EmployeesControllerApi#searchEmployees")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling EmployeesControllerApi#searchEmployees")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **searchTerm** | **kotlin.String**|  |

### Return type

[**kotlin.collections.List&lt;Employee&gt;**](Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

