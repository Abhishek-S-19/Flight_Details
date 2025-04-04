# Use Eclipse Temurin JDK 17
FROM eclipse-temurin:17-jdk-focal

# Set working directory inside the container
WORKDIR /app

# Expose port 8081
EXPOSE 8081

# Copy the JAR file into the container
COPY target/flights.jar /flights.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/flights.jar"]
