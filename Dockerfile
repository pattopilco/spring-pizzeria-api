# Build stage
FROM gradle:7.4-jdk17 as build
ENV DB_HOST=34.70.125.230
ENV DB_PORT=3306
ENV DB_NAME=pizzeria
ENV DB_USER=userdev
ENV DB_PASSWORD=userdev2024
WORKDIR /app
COPY . /app
RUN gradle build --no-daemon

# Run stage
FROM eclipse-temurin:17-jdk
USER 10001
VOLUME /tmp
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]