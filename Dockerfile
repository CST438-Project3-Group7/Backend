# Use JDK 23 image
FROM eclipse-temurin:23-jdk-alpine

# Add a volume to store the logs (optional)
VOLUME /tmp

# Copy the built JAR into the container
COPY build/libs/project3Backend-0.0.1-SNAPSHOT.jar app.jar

# Set environment variables for the database connection
ENV db_url="jdbc:mariadb://un0jueuv2mam78uv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/opm2at3ojeqbytrv"
ENV db_username="pnc1hhykoq0js3en"
ENV db_password="eqvfj8lhx7xsqstn"

EXPOSE $PORT


# Run the jar file when the container starts, use Heroku's dynamically provided port
CMD java -jar /app.jar --server.port=$PORT
