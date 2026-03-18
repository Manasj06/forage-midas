# Midas Core

Project repo for the JPMC Advanced Software Engineering Forage program

## Project Description

Midas Core is a Spring Boot REST API application designed as part of the JPMC Advanced Software Engineering Forage program. It demonstrates core software engineering concepts including:

- **RESTful API Design**: Implements REST endpoints for data manipulation and retrieval
- **Database Integration**: Uses Spring Data JPA with Hibernate for object-relational mapping
- **Event-Driven Architecture**: Integrates Apache Kafka for asynchronous messaging
- **Data Persistence**: Leverages an in-memory H2 database for development and testing
- **Comprehensive Testing**: Includes unit tests, integration tests, and test utilities with JUnit 5 and Mockito

### Technologies Used
- **Java 17**: Modern Java with latest features
- **Spring Boot 3.2.1**: Latest Spring Boot framework
- **Spring Data JPA**: ORM and database abstraction layer
- **Apache Kafka**: Message broker for event streaming
- **H2 Database**: Lightweight in-memory database
- **Maven**: Build automation and dependency management

## Prerequisites

Before running this project, ensure you have the following installed:

- **Java 17 or later**: [Download Java](https://www.oracle.com/java/technologies/downloads/)
- **Apache Maven 3.6+**: [Download Maven](https://maven.apache.org/download.cgi) or use `brew install maven` on macOS
- **Git**: For cloning the repository

Verify installations:
```bash
java -version
mvn -version
```

## How to Run

### 1. Clone the Repository
```bash
git clone <repository-url>
cd forage-midas
```

### 2. Build the Project
```bash
mvn clean package
```

This command:
- Cleans previous build artifacts
- Compiles the source code
- Runs all tests
- Creates a JAR file in the `target/` directory

### 3. Run the Application
```bash
mvn spring-boot:run
```

Or alternatively, run the compiled JAR:
```bash
java -jar target/midas-core-1.0.0.jar
```

The application will start on **http://localhost:8080** by default.

### 4. Verify the Application is Running
You should see output similar to:
```
Started MidasCoreApplication in X.XXX seconds (JVM running for X.XXX)
```

## How to Stop the Application

### If Running with `mvn spring-boot:run`
Press **Ctrl + C** in the terminal where the application is running.

### If Running with `java -jar`
Press **Ctrl + C** in the terminal where the JAR is running.

### Graceful Shutdown
The application will perform a graceful shutdown, completing any in-flight requests before terminating.

## Project Structure

```
src/
├── main/
│   ├── java/com/jpmc/midascore/
│   │   ├── MidasCoreApplication.java    # Main Spring Boot entry point
│   │   ├── controller/                  # REST API controllers
│   │   ├── entity/                      # JPA entities
│   │   ├── repository/                  # Data access layer
│   │   ├── component/                   # Business logic components
│   │   └── foundation/                  # Utility classes
│   └── resources/
│       └── application.yml              # Application configuration
└── test/
    ├── java/com/jpmc/midascore/         # Unit and integration tests
    └── resources/
        ├── application.yml              # Test configuration
        ├── valid_users.csv              # Test data
        └── test_data/                   # Additional test fixtures
```

## Running Tests

Execute all tests:
```bash
mvn test
```

Run a specific test class:
```bash
mvn test -Dtest=TaskOneTests
```

Run a specific test method:
```bash
mvn test -Dtest=TaskOneTests#testMethod
```

Test results are available in `target/surefire-reports/`

## Configuration

Edit `src/main/resources/application.yml` to customize:
- Server port (default: 8080)
- Database settings
- Kafka broker configuration
- Spring profiles (dev, test, prod)

## Troubleshooting

**Port already in use?**
```bash
# Change the port in application.yml or via command line:
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

**Build fails with compilation errors?**
```bash
# Clean and rebuild:
mvn clean install
```

**Tests fail?**
```bash
# Run tests in verbose mode:
mvn test -X
```

## Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)

