### Overview
- The 'task-logging-api' is responsible for the task status.In order to implement this functionality I have created some API's which enables TLA to save and query task status.

### task-logging-api
- In addition, this is a simple UI to create, view an update tasks using react as front end and spring boot as back end. Hence, React(Client) for building user interfaces and Spring boot(Server) to develop RESTful web services and microservices.

### Prerequisites
- JDK 11
- Spring Boot
- Swagger
- Respective libraries to run and execute the Unit Test cases. for example : In order to make http/Rest API calls we need to use third party library i.e. 'axios'

### Repository
- [repo](https://github.com/supriya1254/TaskLoggingApi.git)

### Build

- Java 11
- Maven

The following commands will build and run the unit test:

```BAT
mvn verify
```

### Deploy:

in the project root issue:
```BAT
mvn install
```

### IntelliJ Configuration
To run different profiles without IntelliJ Ultimate, use the following command
```BASH
mvn verify spring-boot:run -Dspring-boot.run.profiles={profile name}
```

### These are API's

- Create task : /api/createTask
- Edit task : /api/editTask
- Delete task : /api/deleteTask/taskId
- Get all task : /api/getTask
- Get task by ID : /api/getTask/taskId


### Testing
The manual tests in the Test folder can be done using local profile.