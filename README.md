# Vishnu

Vishnu is a proof of concept application based on a microservice archtitecture realised with Privotals [Spring Framework](www.spring.io).
Its main purpose is to serve as a POC and reference for the Bachelor Thesis _"Microservices with Spring Boot"_ written to achieve a Bachelor of 
Science degree in Software Design at the [FH Joanneum](www.fh-joanneum.at).

This prototype simulates a flight booking system with real-time flight monitoring (like seen on airports). 

Architecture Overview (v1):

![Architectural Overview](http://i.imgur.com/UFEBqUw.png)

### Goals
Vishnu showcases the following characteristics, architectures and points:
* Distributed microservices based on the JVM
* Unit and integration testing of microservices
* Monitoring of services
* Distributed logging
* Distributed tracing
* Fault tolerance
* Edge gateway

All of the mentioned characteristics are going to implemented using [Spring Boot](http://projects.spring.io/spring-boot/), 
[Spring Cloud](http://projects.spring.io/spring-cloud/), [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/) and other Spring related projects.