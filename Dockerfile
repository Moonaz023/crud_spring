# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jre

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/crud-0.0.1-SNAPSHOT.jar /app/crud.jar

# Expose the port your app will run on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "crud.jar"]
