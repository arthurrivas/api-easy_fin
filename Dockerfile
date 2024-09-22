# Use a base image with Java 11
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application's jar file into the container
COPY target/easyfin-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]