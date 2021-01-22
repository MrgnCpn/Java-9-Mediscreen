#!/bin/sh
cd ./dckr_database_test
docker-compose up -d

cd ../ms-authentication
mvn clean test

cd ../ms-patientAdmin
mvn clean test

cd ../ms-medicalrecord
mvn clean test

cd ../ms-medicalreport
mvn clean test

cd ../ms-clientui
mvn clean test