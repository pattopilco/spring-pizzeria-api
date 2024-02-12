## SPRING MICROSERVICES - SECURITY
# 
* Java 17


## DataDource

```bash 
spring.datasource.drive-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/pizzeria?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=mysecret
spring.jpa.hibernate.ddl-auto=update
# Develop settings
spring.jpa.show-sql=true   
logging.level.org.springframework.security.web.*=debug
```

```bash
spring.datasource.drive-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}?createDatabaseIfNotExist=true
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true
#logging.level.org.springframework.security.web.*=debug
```



## Security

Dependencia de seguridad

build.gradle

Observar logs que realizar spring security, esta configuracion se la realiza en develop en el archivo application.properties
```bash
implementation 'org.springframework.boot:spring-boot-starter-security'
```
```bash
logging.level.org.springframework.security.web.*=debug
```


## DOCKER

```bash
version: '3'

services:

  mysql:
    image: mysql
    container_name: mysql
    environment:
      - MYSQL_ROOT_PASSWORD=mysecret
    volumes:
      - mysqldata:/var/lib/mysql
    ports:
      - "3306:3306"
    networks:
      - mysqlnet
    restart: on-failure

  adminer:
    image: adminer
    container_name: adminer
    depends_on:
      - mysql
    ports:
      - "8080:8080"
    networks:
      - mysqlnet
    restart: on-failure

volumes:
  mysqldata:

networks:
  mysqlnet:
```

```bash
docker-compose up
```
## DOCKERFILE

```bash
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
#ARG JAR_FILE
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

${JAR_FILE}

```bash

docker build --build-arg JAR_FILE=build/libs/*.jar -t ppilco/pizzeria .
```

## SWAGGER

http://localhost:8080/swagger-ui/index.html


## CREAR IMAGEN DOCKER

```bash
chmod +x ./gradlew
./gradlew build
docker build -t ppilco/pizzeria .
```