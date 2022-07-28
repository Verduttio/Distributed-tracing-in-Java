#!/bin/bash

printf "Building services\n"
./build_services_jar.sh

printf "Starting docker-compose\n"
docker-compose up --force-recreate --build -d --remove-orphans
docker image prune -f
docker-compose up


