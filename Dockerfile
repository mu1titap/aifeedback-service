
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/feedback-0.0.1-SNAPSHOT.jar aifeedback-service.jar

EXPOSE 9100

ENTRYPOINT ["java", "-jar", "aifeedback-service.jar"]

ENV TZ=Asia/Seoul