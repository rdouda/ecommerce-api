# Ecommerce API

This is an e-commerce API built with Spring Boot. It provides basic functionality for managing products, users, and orders in an e-commerce application.
### Configuration

Before running the application, make sure to update the following properties in the application.properties file to match your environment.
Edit the following properties:
```bash
spring.application.name=rayen
# Database Connection Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/rayen
spring.datasource.username=rayenuser
spring.datasource.password=rayen

spring.mvc.contentnegotiation.media-types.json=application/json
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update
```
    spring.datasource.url: Set the database connection URL, replace localhost with the appropriate host if not running locally.
    spring.datasource.username: Set your database username.
    spring.datasource.password: Set your database password.
    spring.jpa.hibernate.ddl-auto: This property controls the schema generation. Use update for automatic schema updates.

### Java Version

This application requires Java 21.

Once the application is running, you can access the Swagger UI for API documentation at:

    http://localhost:8080/swagger-ui/index.html

This interface allows you to explore and interact with the API endpoints.
Running the Application

    Clone the repository.

    Update the application.properties with your database configuration.

    Build and run the application:

    ./mvnw spring-boot:run
