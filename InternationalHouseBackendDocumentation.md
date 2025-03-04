# International House Backend – Technical Documentation

This documentation provides a comprehensive overview of the project, its architecture, key components, and steps for local execution. This README file serves as the central source of information for developers, administrators, and clients.

---

## Table of Contents

1. [Overview](#overview)
2. [Architecture and Technologies](#architecture-and-technologies)
3. [Key Components](#key-components)
   - [Authentication & Security](#authentication--security)
   - [Data Management](#data-management)
   - [Configuration & Initialization](#configuration--initialization)
4. [Setup and Installation](#setup-and-installation)
   - [Prerequisites](#prerequisites)
   - [Local Execution](#local-execution)
   - [Docker-Based Environment](#docker-based-environment)
5. [API Documentation](#api-documentation)
6. [Additional Notes](#additional-notes)

---

## Overview

The **International House Backend** is a server-side system implemented as a RESTful API that handles the management of employee and visitor data. The application leverages modern security mechanisms using JSON Web Tokens (JWT) and employs a clear separation into service, repository, and controller layers, ensuring maintainability and extensibility.

---

## Architecture and Technologies

The application is built using the following technologies and frameworks:

- **Spring Boot 3.4.2** – The foundation of the application, providing auto-configuration and production-ready features.
- **Spring Data JPA** – Handling data persistence in a PostgreSQL database.
- **Spring MVC** – Implementation of REST endpoints.
- **Spring Security** – Implementing authentication and authorization using JSON Web Tokens (JWT).
- **Jakarta EE** – Utilized for Jakarta imports in validations and other components.
- **Lombok** – Reduces boilerplate code in Java classes.
- **Redis** – In-memory data store used for session management.
- **ModelMapper** – Simplifies the conversion between DTOs and entities.

---

## Key Components

### Authentication & Security

- **JWT Filter:**  
  A `JwtFilter` intercepts every request to check for a provided JWT token. It extracts the employee information, validates the token, and sets the Spring Security context accordingly.

- **CustomAuthenticationEntryPoint:**  
  This component handles authentication errors by returning consistent JSON-based error responses to the client.

- **SecurityConfig:**  
  Configures the security of the endpoints by allowing public access to endpoints like `/api/auth/**`, `/documentation`, and `/health`, while securing all other endpoints. It also ensures that sessions are stateless.

### Data Management

- **Entities and DTOs:**  
  - The `Employee` entity manages user information and defines roles such as ADMIN and USER.
  - Other entities (e.g., `Visitor`) support CRUD operations, implemented via their corresponding service layers.

- **Service Layers:**  
  - The `VisitorServiceImpl` handles create, read, update, and delete operations for visitor data.
  - The `InformationService` (along with its implementation) provides multilingual information and supports transactional operations.

### Configuration & Initialization

- **Admin User Initialization:**  
  The `AppInitializerServiceImpl` ensures that an admin user exists at application startup. If no admin record is found, a new one is created automatically.

- **Jackson Configuration:**  
  Custom configuration for Jackson ensures robust JSON (de)serialization by ignoring unknown properties and properly formatting date values.

- **ModelMapper Configuration:**  
  Configures an instance of ModelMapper to facilitate easy mapping between DTOs and underlying entities.

- **Spring Profiles and Environment Variables:**  
  Configuration is managed through YAML files (e.g., `application-dev.yml` and `application.yml`), utilizing profiles to distinguish between development and production environments.

---

## Setup and Installation

### Prerequisites

- **Java SDK:** Version 17 (Compatible with Version 19)
- **Maven:** For build and dependency management
- **Docker & Docker Compose:** To start necessary services (PostgreSQL and Redis)

### Local Execution

1. **Start Service Containers:**  
   Ensure that PostgreSQL and Redis are available. Alternatively, start the containers using Docker Compose:

   ```bash
   docker-compose up -d
   ```

2. **Build and Run the Project:**  
   From the project root directory, execute the following commands:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Access the Application:**  
   By default, the application runs on port `8080`, unless otherwise specified in the configuration files.

### Docker-Based Environment

For a containerized execution, the entire setup (including the database and Redis) can be provided via Docker Compose. Build the Spring Boot image and run the container as follows:

1. **Build the Image:**

   ```bash
   mvn clean package
   docker build -t international-house-backend .
   ```

2. **Start the Containers:**  
   Make sure the `docker-compose.yml` file is correctly configured, then start:

   ```bash
   docker-compose up -d
   ```

---

## API Documentation

The API documentation is generated using Springdoc OpenAPI:

- **Swagger UI:**  
  Once the application is running, the interactive API documentation is available at:

  ```
  http://localhost:8080/documentation
  ```

This interface allows you to view and test all available endpoints.

---

## Additional Notes

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