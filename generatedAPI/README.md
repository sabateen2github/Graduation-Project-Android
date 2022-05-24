# org.openapitools.client - Kotlin client library for OpenAPI definition

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BranchesControllerApi* | [**createBranch**](docs/BranchesControllerApi.md#createbranch) | **POST** /branches | 
*BranchesControllerApi* | [**getAllBranches**](docs/BranchesControllerApi.md#getallbranches) | **GET** /branches | 
*BranchesControllerApi* | [**getBranch**](docs/BranchesControllerApi.md#getbranch) | **GET** /branches/{id} | 
*BranchesControllerApi* | [**updateBranch**](docs/BranchesControllerApi.md#updatebranch) | **PUT** /branches/{id} | 
*EmployeesControllerApi* | [**createEmployee**](docs/EmployeesControllerApi.md#createemployee) | **POST** /employees | 
*EmployeesControllerApi* | [**editEmployee**](docs/EmployeesControllerApi.md#editemployee) | **PUT** /employees/{id} | 
*EmployeesControllerApi* | [**getEmployee**](docs/EmployeesControllerApi.md#getemployee) | **GET** /employees/{id} | 
*EmployeesControllerApi* | [**searchEmployees**](docs/EmployeesControllerApi.md#searchemployees) | **GET** /employees | 
*InstituteControllerApi* | [**createInstitute**](docs/InstituteControllerApi.md#createinstitute) | **POST** /institute | 
*InstituteControllerApi* | [**deleteInstitute**](docs/InstituteControllerApi.md#deleteinstitute) | **DELETE** /institute/{id} | 
*InstituteControllerApi* | [**getInstitute**](docs/InstituteControllerApi.md#getinstitute) | **GET** /institute/{id} | 
*InstituteControllerApi* | [**searchInstitutes**](docs/InstituteControllerApi.md#searchinstitutes) | **GET** /institute | 
*QueueControllerApi* | [**advanceQueue**](docs/QueueControllerApi.md#advancequeue) | **PUT** /queues/queue/advance | 
*QueueControllerApi* | [**bookQueue**](docs/QueueControllerApi.md#bookqueue) | **PUT** /queues/queue/book | 
*QueueControllerApi* | [**deleteQueue**](docs/QueueControllerApi.md#deletequeue) | **DELETE** /queues/queue | 
*QueueControllerApi* | [**editQueueSpec**](docs/QueueControllerApi.md#editqueuespec) | **PUT** /queues/queue | 
*QueueControllerApi* | [**getActiveQueues**](docs/QueueControllerApi.md#getactivequeues) | **GET** /queues/active/{userId} | 
*QueueControllerApi* | [**getAllQueueSpecs**](docs/QueueControllerApi.md#getallqueuespecs) | **GET** /queues/spec/all | 
*QueueControllerApi* | [**getAllQueues**](docs/QueueControllerApi.md#getallqueues) | **GET** /queues/queues/all | 
*QueueControllerApi* | [**getArchivedQueues**](docs/QueueControllerApi.md#getarchivedqueues) | **GET** /queues/archived/{userId} | 
*QueueControllerApi* | [**getQueue**](docs/QueueControllerApi.md#getqueue) | **GET** /queues/queue | 
*QueueControllerApi* | [**resetQueue**](docs/QueueControllerApi.md#resetqueue) | **PUT** /queues/queue/reset | 


<a name="documentation-for-models"></a>
## Documentation for Models

 - [gp.backend.model.BookedTurnQueue](docs/BookedTurnQueue.md)
 - [gp.backend.model.Branch](docs/Branch.md)
 - [gp.backend.model.Employee](docs/Employee.md)
 - [gp.backend.model.Institute](docs/Institute.md)
 - [gp.backend.model.Queue](docs/Queue.md)
 - [gp.backend.model.QueueSpec](docs/QueueSpec.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

All endpoints do not require authorization.
