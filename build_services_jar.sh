#!/bin/bash
printf "\nBuilding country-service\n"
cd country-service
./gradlew build -x test
cd ..

printf "\nBuilding director-service\n"
cd director-service
./gradlew build -x test
cd ..

printf "\nBuilding distribution-service\n"
cd distribution-service
./gradlew build -x test
cd ..

printf "\nBuilding genre-service\n"
cd genre-service
./gradlew build -x test
cd ..

printf "\nBuilding movie-service\n"
cd movie-service
./gradlew build -x test
cd ..

printf "\nBuilding service-registry\n"
cd service-registry
./gradlew build -x test
cd ..

printf "\nBuilding api-gateway\n"
cd api-gateway
./gradlew build -x test
cd ..