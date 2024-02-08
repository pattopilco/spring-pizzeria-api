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
docker-compose up
```

## SWAGGER

http://localhost:8080/swagger-ui/index.html


