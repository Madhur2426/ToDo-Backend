# Use an official Maven image to build the application
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app

# Copy the necessary files for building
COPY pom.xml .
COPY src/ /app/src/

# Build the application
RUN mvn clean package

# Create a smaller runtime image
FROM openjdk:17-alpine
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the application's port
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java","-jar","app.jar"]
