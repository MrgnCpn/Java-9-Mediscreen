# OC : Parcours Java / Project 9 ( Mediscreen )
##### Author : **_MorganCpn_**

## Description
Patient management application for healthcare professionals

## Configurations
### Edge Microservices (ems-)
#### ems-eureka (port :9001)
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.4.1

#### ems-zuul (port :9002)
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.3.7.RELEASE

#### ems-admin (port :9003)
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.4.1	

### App Microservice (ms-)
#### ms-authentication
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.4.1

#### ms-patientAdmin
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.4.1

#### ms-medicalRecord
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.4.1

#### ms-medicalReport
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.4.1

#### ms-clientui
	- Java 11
	- Maven 4.0.0
	- Spring Boot 2.4.1

## Install Project
**WARNING** : Check if your localhost port are available before deploy app (3306 / 3307 / 27017 / 27018 / 8080 / 8081 / 8082 / 8083 / 8888 / 9001 / 9002 / 9003)

###With Sheel script
1. Start docker
2. Run `./deploy-all.sh`
3. Remove mongo_db_data container (Container for data import in mongodb)

###Without Shell script
1. Start docker
2. Deploy docker test databases environment with `./dckr_database_test/docker-compose up -d`
3. Build all edge microservices and app microservices with `mvn clean build` command
4. Deploy docker app environment with `./docker-compose up -d`
5. Remove mongo_db_data container (Container for data import in mongodb)

## Shell Script (.sh)
* **build-all.sh** : Build all edge microservices and app microservices (You must deploy test databases before)
* **clean-all.sh** : Clean all edge microservices and app microservices
* **site-ms.sh** : Generate app microservices test report (Surfire + JaCoCo) and site (You must deploy test databases before)
* **test-ms.sh** : Run all Tests of all app microservices (You must deploy test databases before)
* **deploy-test-env.sh** : Deploy docker test databases environment
* **deploy-app.sh** : Deploy docker app environment
* **deploy-all.sh** : Deploy app
    - Deploy docker environment for test databases
    - Build edge microservices and app microservices and generate .jar
    - Deploy app docker environment

## Running App
    > Check if mongo_db_data container is remove from your docker environment
    > Start docker app environement after deploy app
    > Go to http://localhost:8888/ in your browser

## Testing
### Run test
1. Deploy test databases environment
2. Run `./test-ms.sh` **or** run `mvn clean test` for all app microservices

### Test Report
1. Deploy test database environment
2. Run `./site-ms` **or** run `mvn clean site` for all app microservices

Fro all services, you may access to :
- Project informations
- Dependencies
- Licences
- Plugins
- JaCoCo test coverage report
- Surefire  test report
- ...

## APP Architecture
![alt text]()

## URLS
### ems-eureka
  * BROWSER : http://localhost:9001/ : Eureka interface

### ems-admin
  * BROWSER : http://localhost:9003/ : Admin interface

### ms-clientui
  * BROWSER : http://localhost:8888/ : App interface

## Endpoints
### ACTUATOR (GET)
	* INFO       : http://localhost:{port}/actuator/info
	* HEALTH     : http://localhost:{port}/actuator/health
	* BEANS      : http://localhost:{port}/actuator/beans
	* METRICS    : http://localhost:{port}/actuator/metrics
	* ENV        : http://localhost:{port}/actuator/env
	* HTTP TRACE : http://localhost:{port}/actuator/httptrace
    * ...

### SWAGGER 2
    * http://localhost:{port}/v2/api-docs

### App Endpoints : `api-specification.pdf`
  

