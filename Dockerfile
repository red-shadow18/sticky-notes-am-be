# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the application (compiles and creates JAR file)
RUN ./mvnw clean package -DskipTests

# Expose application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/*.jar"]
