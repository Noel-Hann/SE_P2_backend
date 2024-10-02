# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set environment variables
ENV JAVA_OPTS="-Xms512m -Xmx1024m"

# Set the working directory inside the container
WORKDIR /app

COPY target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]