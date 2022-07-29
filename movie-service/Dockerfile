FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY build/libs/*SNAPSHOT.jar app.jar
COPY build/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
#ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/app.jar"]
ENTRYPOINT ["java","-javaagent:/opentelemetry-javaagent.jar","-Dotel.metrics.exporter=none","-Dotel.exporter.otlp.endpoint=http://192.168.109.159:4317","-Dotel.resource.attributes=service.name=movie-service","-Dspring.profiles.active=docker","-jar","/app.jar"]