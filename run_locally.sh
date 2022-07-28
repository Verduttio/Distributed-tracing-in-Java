#!/bin/bash

printf "\nPreparing local environment..\n"
rm -rf local
mkdir local
cp opentelemetry-javaagent.jar local/opentelemetry-javaagent.jar

printf "\nBuilding country-service\n"
cd country-service
./gradlew build -x test
cd ..
cp country-service/build/libs/*SNAPSHOT.jar local/country-service.jar


printf "\nBuilding director-service\n"
cd director-service
./gradlew build -x test
cd ..
cp director-service/build/libs/*SNAPSHOT.jar local/director-service.jar

printf "\nBuilding distribution-service\n"
cd distribution-service
./gradlew build -x test
cd ..
cp distribution-service/build/libs/*SNAPSHOT.jar local/distribution-service.jar

printf "\nBuilding genre-service\n"
cd genre-service
./gradlew build -x test
cd ..
cp genre-service/build/libs/*SNAPSHOT.jar local/genre-service.jar

printf "\nBuilding movie-service\n"
cd movie-service
./gradlew build -x test
cd ..
cp movie-service/build/libs/*SNAPSHOT.jar local/movie-service.jar

printf "\nBuilding service-registry\n"
cd service-registry
./gradlew build -x test
cd ..
cp service-registry/build/libs/*SNAPSHOT.jar local/service-registry.jar

printf "\nBuilding api-gateway\n"
cd api-gateway
./gradlew build -x test
cd ..
cp api-gateway/build/libs/*SNAPSHOT.jar local/api-gateway.jar


printf "\n\n\n --Starting apps--\n\n\n"
cd local
printf "\nStarting service-registry\n" &
java -javaagent:opentelemetry-javaagent.jar \
 -Dotel.metrics.exporter=none \
 -Dotel.exporter.otlp.endpoint=http://192.168.0.80:4317 \
 -Dotel.resource.attributes="service.name=service-registry" \
 -jar service-registry.jar &

printf "\nStarting api-gateway\n" &
java -javaagent:opentelemetry-javaagent.jar \
-Dotel.metrics.exporter=none \
-Dotel.exporter.otlp.endpoint=http://192.168.0.80:4317 \
-Dotel.resource.attributes="service.name=api-gateway" \
-jar api-gateway.jar &

printf "\nStarting country-service\n" &
java -javaagent:opentelemetry-javaagent.jar \
 -Dotel.metrics.exporter=none \
 -Dotel.exporter.otlp.endpoint=http://192.168.0.80:4317 \
 -Dotel.resource.attributes="service.name=country-service" \
 -jar country-service.jar &

printf "\nStarting genre-service\n" &
java -javaagent:opentelemetry-javaagent.jar \
 -Dotel.metrics.exporter=none \
 -Dotel.exporter.otlp.endpoint=http://192.168.0.80:4317 \
 -Dotel.resource.attributes="service.name=genre-service" \
 -jar genre-service.jar &

printf "\nStarting director-service\n" &
java -javaagent:opentelemetry-javaagent.jar \
 -Dotel.metrics.exporter=none \
 -Dotel.exporter.otlp.endpoint=http://192.168.0.80:4317 \
 -Dotel.resource.attributes="service.name=director-service" \
 -jar director-service.jar &

printf "\nStarting distribution-service\n" &
java -javaagent:opentelemetry-javaagent.jar \
 -Dotel.metrics.exporter=none \
 -Dotel.exporter.otlp.endpoint=http://192.168.0.80:4317 \
 -Dotel.resource.attributes="service.name=distribution-service" \
 -jar distribution-service.jar &


printf "\nStarting movie-service\n" &
java -javaagent:opentelemetry-javaagent.jar \
 -Dotel.metrics.exporter=none \
 -Dotel.exporter.otlp.endpoint=http://192.168.0.80:4317 \
 -Dotel.resource.attributes="service.name=movie-service" \
 -jar movie-service.jar & wait