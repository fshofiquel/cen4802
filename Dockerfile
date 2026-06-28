FROM gradle:7.6.4-jdk17 AS build

WORKDIR /home/gradle/project

COPY --chown=gradle:gradle . .

RUN gradle clean build --no-daemon

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
