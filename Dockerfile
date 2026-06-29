FROM gradle:9.3.0-jdk21 AS build

WORKDIR /home/gradle/project

COPY --chown=gradle:gradle . .

RUN gradle clean build --no-daemon

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
