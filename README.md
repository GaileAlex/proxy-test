# **Proxy**

## Test Task

## Introduction

Create a simple web application having CRUD-operations based on
proxy-model.
Required fields of Proxy model should be:
id text,
name unique text with length restriction (120 symbols),
type is a one of enum: "HTTP", "HTTPS", "SOCKS4", "SOCKS5",
hostname unique text with length restriction (120 symbols),
port numeric,
username text with length restriction,
password text with length restriction,
active boolean flag
The application should have the following REST API features:
1. Create a proxy entry
* Make proper validations
* Save it to Database
2. View a proxy entry
* Return all proxy entries saved in Database with pagination
* Return one proxy entry by id
* Return all proxy entries filtered by name and type
3. Edit a proxy entry
* Make proper validations
* Edit proxy entry in database by id
4. Remove a proxy entry
* Remove proxy by id
  Application main requirements:
  Use Java 14 with Gradle.
  Use Flyway for database migration.
  Use Spring Boot with manual datasource configuration.
  Use PostgreSQL in Docker environment as a data storage.
  Integration and unit tests (decide on your own what is the best
  approach to test controllers and mappings).

## Prerequisites
The following technologies required:
* Java 14 
* Postgres 

## Building & setup (production)

Follow the steps below:
1. install docker
2. cd etc/docker/proxy
3. docker-compose up
4. launch the project
5. Open the following url in the browser - http://localhost:8080/swagger-ui.html

