# Build stage
FROM gradle:7.4-jdk17 as build
ENV SPRING_PROFILES_ACTIVE=production
WORKDIR /app
COPY . /app
RUN gradle build --no-daemon

# Run stage
FROM eclipse-temurin:17-jdk
ENV SPRING_PROFILES_ACTIVE=production
USER 10001
VOLUME /tmp
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]