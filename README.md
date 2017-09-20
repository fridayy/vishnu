# Vishnu

Vishnu is a proof of concept application based on a microservice archtitecture realised with Privotals [Spring Framework](http://www.spring.io).
Its main purpose is to serve as a POC and reference for the Bachelor Thesis _"Microservices with Spring Boot"_ written to achieve a Bachelor of Science degree in Software Design at the [FH Joanneum](http://www.fh-joanneum.at).

This prototype simulates a flight booking system with real-time flight monitoring: 

![Visualization](https://i.imgur.com/ywptHFa.png)

Architectural Overview:
![Architectural Overview](https://i.imgur.com/qbjAPey.png)

### Goals
Vishnu showcases the following characteristics, architectures and techniques:
* Distributed microservices based on the JVM
* Inter-Service Communication with RESTful HTTP APIs
* Distributed logging and tracing **Spring Sleuth**, **Netflix Zipkin** and **Papertrail**
* Fault tolerance with **Netflix Hystrix**
* Service gateway with **Netflix Zuul**
* Deployment of services with Docker


### Run for Development
In order to run Vishnu a running [MongoDB](https://www.mongodb.com/) instance is required!

Do run from with IDE the following **Bootstrap classes** must be started **in the given order**:

1. Config Server
```java
ninja.harmless.vishnu.config.BootstrapConfig
```
2. Discovery Service
```java
ninja.harmless.vishnu.discovery.BootstrapDiscovery
```

3. Zuul
```java
ninja.harmless.vishnu.BootstrapZuul
```

4. Zipkin
```java
ninja.harmless.vishnu.BootstrapZipkin
```

5. Flight-Service (requires MongoDB)
```java
ninja.harmless.vishnu.BootstrapFlightServiceApplication
```

6. Flight-Monitoring-Service
```java
ninja.harmless.vishnu.BootstrapFlightMonitoringApplication
```

7. Start the Flight-Service UI with: ```ng serve --port=3000```
8. Start the Flight-Monitoring-Service UI with: ```ng serve --port=3100```

### Run for Production
tbd

All of the mentioned characteristics are implemented using [Spring Boot](http://projects.spring.io/spring-boot/), 
[Spring Cloud](http://projects.spring.io/spring-cloud/), [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/) and other Spring related projects.

The paper referencing this project can be found [here](https://github.com/fridayy/vishnu/blob/master/docs/bakk2-paper.pdf).
