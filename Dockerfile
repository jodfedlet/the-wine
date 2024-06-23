# Stage 1: Build the application
FROM maven:3.9.5-amazoncorretto-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and the source code to the working directory
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (adjust as necessary)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]