FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/UserConsumerService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} UserConsumerService.jar
ENTRYPOINT ["java","-jar","UserConsumerService.jar"]
EXPOSE 8081