# Spring WebFlux Demo

A reactive REST API built with Spring WebFlux and MongoDB, demonstrating non-blocking, asynchronous data streaming.

## Features

- **Reactive Streams**: Uses Spring WebFlux with Project Reactor for fully non-blocking I/O
- **Server-Sent Events (SSE)**: Real-time streaming of Student data via `text/event-stream`
- **MongoDB Reactive**: Async database operations with `ReactiveMongoRepository`
- **Auto-initialization**: Sample data loaded on application startup

## Tech Stack

- Java 25
- Spring Boot 4.0.6
- Spring WebFlux
- Spring Data MongoDB Reactive
- MongoDB

## Prerequisites

Start MongoDB before running the application:

```bash
docker run -d -p 27017:27017 --name mongo mongo:latest
```

## Running the Application

```bash
./mvnw spring-boot:run
```

## API Endpoints

### GET /

Returns a stream of all students with 1-second delay between elements.

**Response**: `text/event-stream` (SSE)
```json
{"id":"...","name":"Jacob"}
{"id":"...","name":"Anna"}
{"id":"...","name":"Ron"}
{"id":"...","name":"Przemek"}
```

## Project Structure

```
src/main/java/com/example/demo/
├── DemoApplication.java   # Spring Boot entry point
├── Student.java           # MongoDB document entity
├── StudentRepo.java       # Reactive MongoDB repository
├── StudentApi.java        # REST controller with SSE endpoint
└── InitService.java       # Data initialization on startup
```

## License

MIT

## Credits

This project is based on the tutorial: [Spring WebFlux - programowanie reaktywne w Spring](https://bykowski.pl/spring-webflux-programowanie-reaktywne-w-spring/)