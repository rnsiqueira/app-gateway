# APP Gateway

This project is a gateway example for the APP project.


## Getting Started

The Gateway Project is an API Gateway designed to act as an entry point to a microservices architecture. It handles requests from clients, routing them to the appropriate microservice, and managing cross-cutting concerns such as authentication, authorization, rate limiting, and monitoring.

### Architecture

The App gateway is built using gradle, spring boot, spring cloud gateway, and resilience4j. It is a reactive gateway that routes requests to the appropriate microservice based on the request path. The gateway is also responsible for handling cross-cutting concerns such as authentication, authorization, rate limiting, and monitoring.

### Prerequisites

Java 21
MongoDB
Docker
Docker Compose

### Installing

Run docker-compose up to install the database MongoDB.

```
docker-compose up -d

```
completed, check if the database is running.

```
docker ps -a

```
![docker-runing](file:///home/rafael.siqueira/Pictures/Screenshots/Screenshot%20from%202024-07-05%2016-08-17.png)

### Running application at local environment

use Java 21 Version

```

gradle clean build bootRun
    
``` 