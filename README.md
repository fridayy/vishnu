# Vishnu

Vishnu is a proof of concept application based on a microservice archtitecture realised with Privotals [Spring Framework](http://www.spring.io).
Its main purpose is to serve as a POC and reference for the Bachelor Thesis _"Microservices with Spring Boot"_ written to achieve a Bachelor of 
Science degree in Software Design at the [FH Joanneum](http://www.fh-joanneum.at).

This prototype simulates a flight booking system with real-time flight monitoring: 

![Visualization](https://i.imgur.com/ywptHFa.png)

Architectural Overview:
![Architectural Overview](https://i.imgur.com/qbjAPey.png)

### Goals
Vishnu showcases the following characteristics, architectures and techniques:
* Distributed microservices based on the JVM
* Inter-Service Communication with RESTful HTTP APIs
* Distributed logging and tracing with Spring Sleuth and Netflix Zipkin
* Fault tolerance with Netflix Hystrix
* Service gateway with Netflix Zuul
* Deployment of services with Docker

All of the mentioned characteristics are implemented using [Spring Boot](http://projects.spring.io/spring-boot/), 
[Spring Cloud](http://projects.spring.io/spring-cloud/), [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/) and other Spring related projects.

The paper referencing this project can be found [here](https://github.com/fridayy/vishnu/blob/master/docs/bakk2-paper.pdf).