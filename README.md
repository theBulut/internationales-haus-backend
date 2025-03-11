# International House Backend – Technical Documentation

This documentation provides a comprehensive overview of the project, its architecture, key components, and steps for local execution. It serves as the central source of information for developers, administrators, and stakeholders.

---

## **Table of Contents**
1. [Overview](#overview)
2. [Architecture and Technologies](#architecture-and-technologies)
3. [Key Components](#key-components)
    - [Authentication & Security](#authentication--security)
    - [Data Management](#data-management)
    - [Controller-Service-Entity Layers](#controller-service-entity-layers)
4. [Setup and Installation](#setup-and-installation)
    - [Prerequisites](#prerequisites)
    - [Local Execution](#local-execution)
    - [Docker-Based Environment](#docker-based-environment)
5. [API Documentation](#api-documentation)
6. [Additional Notes](#additional-notes)

---

## **Overview**

The **International House Backend** is a server-side system implemented as a **RESTful API** that manages employees, visitors, and consultation events. It also supports multilingual information storage and retrieval. The backend uses modern design patterns and technologies to ensure security, scalability, and maintainability.

Key features include:
- A **role-based security system** using JSON Web Tokens (JWT).
- Full **CRUD operations** for employees, visitors, and consultations.
- **Swagger/OpenAPI** integration for API documentation.
- A modular architecture with distinct responsibilities (controllers, services, repositories, and entities).

The structure follows the **Controller-Service-Repository (CSR)** design pattern, which ensures clean separation between business logic, data management, and API endpoints.

---

## **Architecture and Technologies**

The application uses the following frameworks and tools:
- **Spring Boot 3.4.2** – Primary backend framework.
- **Spring Security** – Provides JWT-based authentication and role-based access control.
- **Spring Data JPA** – Used for data persistence with PostgreSQL.
- **Swagger/OpenAPI** – For documenting API endpoints.
- **Jakarta EE** – Utilized for standard validation and server-side Java components.
- **Redis** – Used for session management and caching.
- **Lombok** – Eliminates boilerplate code in Java projects.
- **Docker** – For containerized deployment.
- **ModelMapper** – Simplifies mapping between DTOs and entities.

---

## **Key Components**

### **Authentication & Security**

- **JWT-Based Security:**  
  JWT tokens are used for authenticating requests. All secured endpoints validate the JWT token before processing the request.
    - The token is generated upon successful login and contains user-specific claims (e.g., role, name, etc.).
    - Tokens are validated and parsed using the `JwtUtil` class.

- **Role-Based Access Control:**  
  Access to endpoints is governed by Spring Security's pre-authorization mechanisms (e.g., `@PreAuthorize("hasRole('ADMIN')")`).
    - Example: Only `ROLE_ADMIN` users can create employees.

- **Password Hashing:**  
  User passwords are hashed using a `PasswordEncoder` for enhanced security.

---

### **Data Management**

- **Entities** act as the core data models (e.g., `Employee`, `Visitor`, `Consultation`). They are annotated with JPA annotations for database table mapping.
- **Repositories** provide database interaction via interfaces extending `JpaRepository`.

- **DTOs (Data Transfer Objects):**
    - Used to encapsulate API responses and control what data is returned to the frontend.
    - Example: `BaseResponseDto` is used across endpoints for consistent API response structures.

---

### **Controller-Service-Entity Layers**

#### **1. Controller Layer**
- The controller layer serves as the entry point for API calls and handles incoming HTTP requests.
- Each entity (e.g., Employee, Visitor, Consultation) has a corresponding REST controller.
- Controllers do not contain business logic but instead delegate it to the service layer.

**Examples:**
- `EmployeeController` handles API requests related to employee management (`/api/employees`).
- `VisitorController` manages visitor-related functionalities (`/api/visitors`).

**Common Classes:**
- `BaseResponseDto`: Standardizes responses across all endpoints.
- Example:
  ```java
  ResponseEntity<BaseResponseDto> responseEntity;
  ```

#### **2. Service Layer**
- Services implement the application's business logic, delegating data management to repositories.
- Example functionality:
    - Creating new employees (`EmployeeServiceImpl`)
    - Fetching consultations (`ConsultationServiceImpl`)

**Key Classes:**
- `EmployeeService`
- `VisitorService`
- `ConsultationService`

**Detailed Features:**
- Services ensure validation and transformations (e.g., encoding sensitive data like passwords, catching entities that don't exist, etc.).
- Use of annotations like `@Transactional` guarantees consistent database state.

#### **3. Entity Layer**
- The entity layer represents database tables using JPA.
- Each entity corresponds to one or more tables in the PostgreSQL database.
- Example Entities:
    - `Employee`: Stores information like ID, Name, Role, and Password.
    - `Visitor`: Represents visitor details with attributes like ID, name, etc.
    - `Consultation`: Represents consultations scheduled within the system.

---

### **How They Work Together**
1. **Request Flow:**
- The client sends a request to a specific endpoint managed by the controller.
- The controller passes the request to the appropriate service.
- The service layer performs business logic and communicates with the repository layer to retrieve or save data.
- The service returns the processed data back to the controller, which encapsulates it in a standard response object.

2. **Entity Mapping:**
- Controllers process request payloads into entities (if needed).
- Services map entities back or forth from DTOs, ensuring loosely coupled and secure responses.

---

### **Error Handling**

Error handling in the application ensures consistent and meaningful error responses. The following components are used:

#### **1. BaseException**
- Serves as the foundation for all custom exceptions.
- Provides attributes like `httpStatus` and `errorCode` to standardize error messages across different exceptions.

**Attributes:**
- `httpStatus`: HTTP response status for the error.
- `message`: Error message conveyed to the client.
- `errorCode`: A unique integer code for each type of error.

Example custom exceptions extending `BaseException`:
- `EmployeeAlreadyExistException`: Triggered when attempting to create an employee that already exists.
- `EmployeeNotFoundException`: Thrown when an employee cannot be found in the database.
- `InvalidCredentialsException`: Raised during authentication for invalid username or password.

#### **2. GlobalExceptionFilter**
- A centralized exception-handling mechanism using `@ControllerAdvice`.
- Captures and processes exceptions globally, ensuring clients receive consistent JSON error responses.
- Handles various exception types, including:
    - `BaseException`: Returns structured error responses for business exceptions.
    - `MethodArgumentNotValidException`: Captures validation errors for input payloads and returns detailed validation error messages.
    - `AccessDeniedException`: Handles unauthorized access attempts.
    - Generic `RuntimeException`s: Provides a fallback processor for unexpected errors.

**Error Response Example:**
When a business exception occurs:
```json
{
  "errorCode": 2,
  "message": "Employee already exists",
  "path": "/api/employees",
  "status": 400,
  "timestamp": "2023-10-20T12:34:56"
}
```

#### **3. Validation**
- Validation errors for incoming requests are handled by `MethodArgumentNotValidException`, which maps field-level validation errors into descriptive JSON objects.

**Example Validation Error Response:**
```json
{
  "errorCode": 1,
  "message": "Validation error",
  "data": {
    "name": "Name must not be empty",
    "email": "Email is not valid"
  },
  "status": 400,
  "timestamp": "2023-10-20T12:34:56"
}
```

#### **Custom Exception Highlights:**
- `EmployeeAlreadyExistException`: Thrown if an employee with the given properties already exists.
- `EmployeeNotFoundException`: Thrown when a resource is missing from the database.
- `InvalidCredentialsException`: Used during login attempts for invalid username/password combinations.

By centralizing exception handling, the application reduces redundancy and provides a consistent developer and client experience.

---

## **Setup, Installation and Development**

### **Prerequisites**
- Install **Java 17** or higher.
- Install **Docker** for containerized execution.
- Install a PostgreSQL database locally or ensure access to a cloud instance.
- Use an IDE like IntelliJ IDEA or VS Code with Java support.

### Development ###
- During development it is recommended to use the profile `dev`. In IntelliJ `-Dspring.profiles.active=dev` can be
  added in the VM options of the Run Configuration after enabling this property in "Modify options".

Lombok must be supported by your IDE. For IntelliJ install the Lombok plugin and enable annotation processing -
[learn more about Lombok](https://bootify.io/next-steps/spring-boot-with-lombok.html).
### **Local Execution**

Follow these steps to run the application locally:


#### **1. Install Maven**
Ensure Maven is installed. Maven is required to manage dependencies and build the project. Installation guide:
- [Official Maven Installation Guide](https://maven.apache.org/install.html)

After installing Maven, verify the installation by running the following command in your terminal:
```bash
mvn -v
```

---

#### **2. Install Dependencies**
Synchronize and install the dependencies defined in the `pom.xml` file by running:
```bash
mvn clean install
```
This step downloads the required libraries for the project and creates the necessary JAR files in your local Maven repository.

---

#### **3. Install Docker**
Install Docker to run the required services such as PostgreSQL and Redis in containers. Installation guide:
- [Official Docker Installation Guide](https://docs.docker.com/get-docker/)

Verify Docker installation by running:
```bash
docker --version
```

---

#### **4. Start PostgreSQL and Redis with Docker**
The database services are configured using the `docker-compose.yml` file. Start them by running:
```bash
docker-compose up
```

- **PostgreSQL:** Runs on port `5432`.
- **Redis:** Runs on port `6379`.

> Alternatively, you can also start these services using individual Docker commands:
```bash
docker run -d --rm --name postgres -e POSTGRES_DB=international-house -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres

docker run -d --rm --name redis -p 6379:6379 redis
```

Once the services are running, you can verify their status using appropriate tools or commands:
- Check PostgreSQL: Use a GUI tool like pgAdmin or the command `docker logs <container-id>` to ensure the database is up and running.
- Check Redis: Use Redis CLI or check the container logs to confirm Redis is running.

---

#### **5. Start the Backend**
1. Import the project into an IDE like IntelliJ IDEA.
2. Navigate to the entry point of the application: `BackendApplication.java` in `src/main/java/com/international_house/backend`.
3. Run the `BackendApplication` class:
    - Click on the main method and run the application within the IDE.
    - Alternatively, start the application in the command line:
      ```bash
      mvn spring-boot:run
      ```

---

#### **6. Verify the Application**
Once the application starts successfully, all necessary services should be running. Verify the following:
- **Backend API Status:** The API documentation should be available at `http://localhost:<port>/documentation`.
- **Docker Services:** Ensure PostgreSQL and Redis are still active by checking Docker's active containers:
  ```bash
  docker ps
  ```

---

With these steps, you can successfully set up and run the application. If any issue arises, check the application logs in the IDE or the terminal for troubleshooting.


## **API Documentation**

The application is documented using **Swagger/OpenAPI**. Accessible at:

 ```
  http://localhost:8080/swagger-ui/index.html
  ```

This interface allows you to view and test all available endpoints.

Endpoints:
- `/api/auth/*` – Authentication and profile management.
- `/api/employees/*` – Employee CRUD operations.
- `/api/visitors/*` – Visitor management.
- `/api/informations/*` – Multilingual system information.
- `/api/consultations/*` – Manage scheduled consultations.

---

## **Future Features & Development Plans**

This section outlines planned features and improvements for the project. These represent ongoing efforts to enhance functionality and scalability.

### **Planned Features**
1. **Accessibility Features:**  
   Introduce enhanced accessibility features to better support handicapped users, such as optimized navigation and additional tools.

2. **Support for More Languages:**  
   Expand frontend language support beyond English and German, providing international users with a more inclusive experience.

3. **3D Room Model of Consultations & Events:**  
   Implement real-time 3D visualization of rooms holding consultation events to help users better locate and navigate scheduled events.

### **Development Plans**
1. **Enhanced Data Transfer Objects (DTOs):**  
   Extend the project with more dedicated DTO classes for all endpoints, improving request validations and ensuring consistent API responses.

2. **Better Password Encryption:**  
   Upgrade password encryption to use cutting-edge methods to guard against increasingly powerful attackers, ensuring higher levels of security.

---

## **Further Readings**

Here are some useful links to official documentation and resources for the technologies used in the project:

- **PostgreSQL Documentation:**  
  https://www.postgresql.org/docs/

- **Docker Documentation:**  
  https://docs.docker.com/

- **Redis Documentation:**  
  https://redis.io/docs/

- **Apache Maven Documentation:**  
  https://maven.apache.org/guides/index.html

- **Spring Boot Reference Documentation:**  
  https://docs.spring.io/spring-boot/docs/current/reference/html/

- **Spring Security (JWT):**  
  https://spring.io/projects/spring-security

- **Spring Data JPA Reference:**  
  https://docs.spring.io/spring-data/jpa/reference/jpa.html

---

## Additional Notes
- **Initialization:**  
  The system includes automatic **admin creation** at startup via the `AppInitializerServiceImpl`. Default admin credentials are fetched from environment variables.\
  The application supports **CORS configurations** (`WebConfig.java`) for cross-origin requests, allowing frontend integrations.

- **Error Handling:**  
  The application employs an error-handling Spring Boot Starter that ensures consistent HTTP error codes and detailed error descriptions are returned.

- **Security:**  
  Robust security is enforced via modern authentication and authorization mechanisms, including JWT validation, Redis-backed session management, and Spring Security to protect endpoints from unauthorized access.

- **Logging and Monitoring:**  
  The application is production-ready with support for HTTP/2, comprehensive logging configurations, and Actuator endpoints for monitoring.

- **Extensibility and Maintainability:**  
  With a modular design and clearly separated concerns, the system is highly extensible and maintainable, facilitating the addition of new features and modifications with minimal impact on existing functionality.

---

This technical documentation details the structure and functioning of the International House Backend System, along with the necessary steps for local and containerized deployment. For any further questions, please contact the development or operations team.
