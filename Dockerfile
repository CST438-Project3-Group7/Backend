# Use JDK 23 image
FROM eclipse-temurin:23-jdk-alpine

# Set the working directory inside the container
WORKDIR /app
# Copy the Gradle wrapper and build configuration files first
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle/

# Copy the rest of the source code
COPY src /app/src

# Run the Gradle build inside the container to create the JAR file
RUN ./gradlew clean build

# Copy the generated JAR file from build/libs to the working directory
RUN mv /app/build/libs/project3Backend-0.0.1-SNAPSHOT.jar /app/app.jar


# Set environment variables for the database connection
ENV db_url="jdbc:mariadb://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/opm2at3ojeqbytrv"
ENV db_username="pnc1hhykoq0js3en"
ENV db_password="eqvfj8lhx7xsqstn"

EXPOSE $PORT


# Run the jar file when the container starts, use Heroku's dynamically provided port
CMD java -jar /app.jar --server.port=$PORT
