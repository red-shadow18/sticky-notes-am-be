# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Make mvnw executable (only if using Maven Wrapper)
RUN chmod +x mvnw

# Build the application (creates JAR file)
RUN ./mvnw clean package -DskipTests

# Expose application port
EXPOSE 8080

# Find the built JAR file and run it
CMD ["sh", "-c", "java -jar target/*.jar"]
