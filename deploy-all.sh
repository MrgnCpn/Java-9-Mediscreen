#!/bin/sh
cd ./dckr_database_test
docker-compose up -d

cd ..
./build-all.sh

docker-compose up -d