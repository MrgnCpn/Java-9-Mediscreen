#!/bin/sh
cd ./ms-authentication
mvn clean site

cd ../ms-patientAdmin
mvn clean site

cd ../ms-medicalrecord
mvn clean site

cd ../ms-medicalreport
mvn clean site

cd ../ms-clientui
mvn clean site