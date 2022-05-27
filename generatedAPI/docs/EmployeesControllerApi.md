# EmployeesControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createEmployee**](EmployeesControllerApi.md#createEmployee) | **POST** /employees | 
[**editEmployee**](EmployeesControllerApi.md#editEmployee) | **PUT** /employees | 
[**getEmployee**](EmployeesControllerApi.md#getEmployee) | **GET** /employees/{id} | 
[**searchEmployees**](EmployeesControllerApi.md#searchEmployees) | **GET** /employees | 


<a name="createEmployee"></a>
# **createEmployee**
> createEmployee(employee, profilePic)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = EmployeesControllerApi()
val employee : Employee =  // Employee | 
val profilePic : java.io.File = BINARY_DATA_HERE // java.io.File | 
try {
    apiInstance.createEmployee(employee, profilePic)
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
 **employee** | [**Employee**](Employee.md)|  |
 **profilePic** | **java.io.File**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="editEmployee"></a>
# **editEmployee**
> editEmployee(employee, profilePic)



### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import gp.backend.model.*

val apiInstance = EmployeesControllerApi()
val employee : Employee =  // Employee | 
val profilePic : java.io.File = BINARY_DATA_HERE // java.io.File | 
try {
    apiInstance.editEmployee(employee, profilePic)
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
 **employee** | [**Employee**](Employee.md)|  |
 **profilePic** | **java.io.File**|  |

### Return type

null (empty response body)

### Authorization


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: multipart/form-data
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


Configure bearerAuth:
    ApiClient.accessToken = ""

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


Configure bearerAuth:
    ApiClient.accessToken = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

