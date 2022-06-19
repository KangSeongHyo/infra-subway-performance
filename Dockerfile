FROM openjdk:8-jdk-alpine as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar
RUN apk add --no-cache bash

FROM openjdk:8-jdk-alpine
# copy arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas
COPY --from=builder build/libs/*.jar app.jar
ENTRYPOINT ["nohup","java","-jar","/app.jar"]
