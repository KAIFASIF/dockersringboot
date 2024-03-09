# Use the official Maven image as the base image for the build stage
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project's POM file
COPY pom.xml .

# Copy the entire project source code
COPY src ./src

# Package the application into a JAR file
RUN mvn clean package -DskipTests

# Use the official OpenJDK image as the base image for the runtime environment
FROM openjdk:17-jdk-slim AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built in the previous stage to the container
COPY --from=build /app/target/dockersringboot-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 9000
# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
