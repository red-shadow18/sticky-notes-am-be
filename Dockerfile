# Use OpenJDK 17 as the base image
FROM eclipse-temurin:17

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar  # Use `build/libs/*.jar` for Gradle

# Expose the application port
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]