# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**agentic-embabel** is a Spring Boot 3.5.7 application written in Kotlin 1.9.25 that integrates the Embabel Agent framework (version 0.2.0) for agentic capabilities. The project uses Java 21 and Maven for dependency management.

## Technology Stack

- **Language**: Kotlin (with Spring plugin for all-open support)
- **Framework**: Spring Boot 3.5.7
- **Build Tool**: Maven (use `./mvnw` wrapper)
- **Java Version**: 21 (managed via SDKMAN with `.sdkmanrc`)
- **Key Dependency**: Embabel Agent Starter (com.embabel.agent:embabel-agent-starter:0.2.0)
- **Docker**: Docker Compose support enabled via spring-boot-docker-compose

## Build and Development Commands

### Build and Run
```bash
# Clean and build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run

# Package the application
./mvnw package
```

### Testing
```bash
# Run all tests
./mvnw test

# Run a specific test class
./mvnw test -Dtest=AgenticEmbabelApplicationTests

# Run tests with coverage
./mvnw test jacoco:report
```

### Code Quality
```bash
# Compile Kotlin sources
./mvnw kotlin:compile

# Verify the build
./mvnw verify
```

## Project Structure

- **Main Source**: `src/main/kotlin/com/ggardet/agenticembabel/`
  - Contains Kotlin source files
  - Package structure: `com.ggardet.agenticembabel`

- **Test Source**: `src/test/kotlin/com/ggardet/agenticembabel/`
  - Test classes using JUnit 5 and kotlin-test-junit5

- **Resources**: `src/main/resources/`
  - `application.properties`: Spring Boot configuration (application name: agentic-embabel)

- **Docker Compose**: `compose.yaml` (currently empty but available for services)

## Kotlin Configuration

The project uses Kotlin Maven plugin with:
- JSR-305 strict mode (`-Xjsr305=strict`)
- Spring compiler plugin for all-open (required for Spring proxies)
- kotlin-maven-allopen for Spring support

## Important Notes

- Source and test directories are configured explicitly in pom.xml to use Kotlin directories
- The application uses Spring Boot Docker Compose integration (runtime scope)
- Embabel Agent is the core dependency for agentic functionality
