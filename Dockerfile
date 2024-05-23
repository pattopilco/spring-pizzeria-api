# Build stage
FROM gradle:7.4-jdk17 as build
ARG DB_HOST
ARG DB_PORT
ARG DB_NAME
ENV DB_HOST $DB_HOST
ENV DB_PORT $DB_PORT
ENV DB_NAME $DB_NAME
ENV DB_USER
ENV DB_PASSWORD
WORKDIR /app
COPY . /app
RUN gradle build --no-daemon

# Run stage
FROM eclipse-temurin:17-jdk
USER 10001
VOLUME /tmp
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]