FROM openjdk:9-jdk-slim
ARG JAR_FILE=target/CarsApi.jar
ADD ${JAR_FILE} CarsApi.jar
ENTRYPOINT ["java","-jar","CarsApi.jar"]
EXPOSE 8082