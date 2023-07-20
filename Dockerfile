# Use a base image with Java 17 installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/edhaut.jar app.jar

# Expose the port that the application will listen on
EXPOSE 5002

# Set the command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]
