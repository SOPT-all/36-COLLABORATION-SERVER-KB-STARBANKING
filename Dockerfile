FROM gradle:8.0.2-jdk17 AS build
WORKDIR /app/kaswhy

COPY . /app/kaswhy
RUN ls -l
RUN chmod +x gradlew
RUN ./gradlew build -x test

RUN cp $(ls /app/kaswhy/build/libs/*.jar | head -n 1) /app/kaswhy/build/libs/app.jar

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/kaswhy/build/libs/app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]