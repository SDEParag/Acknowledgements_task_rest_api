# Acknowledgements_task_rest_api
This Spring Boot application provides a REST API for managing user acknowledgements. It allows users to submit, retrieve, update, and delete acknowledgements related to different clients.

# Features

* Save user acknowledgements

* Fetch acknowledgements by username

* Update an acknowledgement

* Delete an acknowledgement

* Centralized exception handling

* Logging with SLF4J Logger

* Uses HashMap

# Technologies Used

* Java 8

* Spring Boot

* Spring Data JPA

* MySQL Database

* SLF4J Logger

* REST API

* Exception Handling

# Setup Instructions

* Prerequisites

* Java 8+

* MySQL Database

* Maven

* Postman or any API testing tool

# Database Configuration

 ```http
# ===============================
# Database Configuration (MySQL)
# ===============================
spring.datasource.url=jdbc:mysql://localhost:3306/acknowledgement_db
spring.datasource.username=******
spring.datasource.password=******
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
```http
# ===============================
# Hibernate Configuration
# ===============================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=g.hibernate.dialect.MySQL8Dialect
```
# Running the Application

* Clone the repository:
  ```http
  git clone https://github.com/your-repo/acknowledgements-task-rest-api.git
  ```
* Navigate to the project directory:
  ```http
  cd acknowledgements-task-rest-api
  ``````
* Build the project:
  ```http
  mvn clean install
   ``````
* Run the application:
  ```http
  mvn spring-boot:run
  ```

# API Endpoints
```http
1. Save Acknowledgement

Endpoint: POST /api/acknowledgements

Request Body:
{
  "userName": "Anurag",
  "clientName": "Client1"
}

Response:
{
  "id": 1,
  "userName": "Anurag",
  "clientName": "Client1",
  "message": "I Anurag do acknowledge to accept the terms at 01-Mar-2025 07:11 pm IST",
  "timestamp": "01-Mar-2025 07:11 pm IST"
}
```


```http
2. Get Acknowledgements by Username

Endpoint: GET /api/acknowledgements/{userName}

Example Response:
[
  {
    "id": 1,
    "userName": "Anurag",
    "clientName": "Client1",
    "message": "I Anurag do acknowledge to accept the terms at 01-Mar-2025 07:11 pm IST",
    "timestamp": "01-Mar-2025 07:11 pm IST"
  }
]
```

```http
3. Update Acknowledgement

Endpoint: PUT /api/acknowledgements/{id}

Request Body:
{
  "userName": "Anurag Kumar",
  "clientName": "Client2"
}
Response:
{
  "id": 1,
  "userName": "Anurag Kumar",
  "clientName": "Client2",
  "message": "I Anurag Kumar agree that I have read the terms and conditions at 01-Mar-2025 07:19 pm IST",
  "timestamp": "01-Mar-2025 07:19 pm IST"
}
```

```http
4. Delete Acknowledgement

Endpoint: DELETE /api/acknowledgements/{id}

Response:
"Acknowledgement deleted successfully!"
```
# Exception Handling

The application includes centralized exception handling using AppExceptionHandler. It handles:

* AcknowledgeNotFoundException - When an acknowledgement is not found

* Generic exceptions - For unexpected errors

# Logging

Logging is implemented using SLF4J Logger for better debugging and tracking of API operations.
