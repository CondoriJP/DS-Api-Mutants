FROM alpine:latest AS build

RUN apk update && apk add --no-cache openjdk17 gradle

COPY . .

RUN chmod +x ./gradlew

RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-alpine

EXPOSE 8080

COPY --from=build ./build/libs/*.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]