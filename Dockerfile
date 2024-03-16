# Stage 1: Build Stage
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project's POM file
COPY pom.xml .

# Copy the entire project source code
COPY src ./src

# Package the application into a JAR file
RUN mvn clean package -DskipTests

# Stage 2: Runtime Stage
FROM openjdk:17-jdk-slim AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built in the previous stage to the container
COPY --from=build /app/target/dockersringboot-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 9000

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]



# # Stage 1: Build Stage
# FROM maven:3.8.4-openjdk-17 AS build

# # Set the working directory in the container
# WORKDIR /app

# # Copy the Maven project's POM file
# COPY pom.xml .

# # Copy the entire project source code
# COPY src ./src

# # Package the application into a JAR file
# RUN mvn clean package -DskipTests

# # Stage 2: Runtime Stage
# FROM openjdk:17-jdk-slim AS runtime

# # Set the working directory in the container
# WORKDIR /app

# # Copy the JAR file built in the previous stage to the container
# COPY --from=build /app/target/dockersringboot-0.0.1-SNAPSHOT.jar app.jar

# # Expose the port on which the Spring Boot application will run
# EXPOSE 9000

# # Command to run the Spring Boot application
# # CMD ["java", "-jar", "app.jar"]
# CMD ["sh", "-c", "java -jar app.jar &"]


# # Stage 1: Build the application
# # FROM adoptopenjdk:17-jdk-hotspot AS buildpimage
# # WORKDIR /app
# # COPY . .
# # RUN ./mvnw clean package -DskipTests

# # # Stage 2: Create the final image
# # FROM adoptopenjdk:17-jre-hotspot
# # WORKDIR /app
# # COPY --from=build /app/target/dockersringboot.jar ./dockersringboot.jar
# # EXPOSE 8080
# # CMD ["java", "-jar", "dockersringboot.jar"]

# # Use a base image with Java and Maven installed
# FROM maven:3.8.4-openjdk-17 AS build

# # Set the working directory in the container
# WORKDIR /app

# # Copy the pom.xml to download dependencies
# COPY pom.xml .

# # Download dependencies
# RUN mvn dependency:go-offline

# # Copy the rest of the application source code
# COPY src ./src

# # Build the application
# RUN mvn package -DskipTests

# # Second stage: Use a lighter base image
# FROM adoptopenjdk/openjdk17:alpine-jre

# # Set the working directory in the container
# WORKDIR /app

# # Copy the built JAR file from the previous stage
# COPY --from=build /app/target/*.jar app.jar

# # Expose the port your application runs on
# EXPOSE 9000

# # Command to run the application
# CMD ["java", "-jar", "app.jar"]
