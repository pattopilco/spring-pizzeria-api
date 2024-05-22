# Build stage
FROM gradle:7.4-jdk17 as build
WORKDIR /app
COPY . /app
ARG DB_HOST
CMD echo "Hola ${DB_HOST}!"

RUN gradle build --no-daemon

# Run stage
FROM eclipse-temurin:17-jdk
USER 10001
VOLUME /tmp
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]