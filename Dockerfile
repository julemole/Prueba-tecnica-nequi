# Img
FROM openjdk:21-jdk-slim as build

# DIR
WORKDIR /app

COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml ./

RUN ./mvnw dependency:go-offline -B

COPY src ./src

# COMPILED
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/myapp-0.0.1-SNAPSHOT.jar app.jar

#PORT
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
