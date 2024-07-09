# Use AdoptOpenJDK 17 as base image
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/barbershop-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]
