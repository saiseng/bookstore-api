
### Background
This is a simple REST API bootstrap using https://start.spring.io, with the following components
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* MySql Driver
* MySQL DB


### Setup
* Setup DB instance with the script found in resource folder
* Build command: mvn package
* Start command: java -jar target/bookstore-api-0.0.1-SNAPSHOT.jar
* URL endpoint : http://localhost:8080/book


### API EndPoint
* (POST) /book/add
* (POST) /book/update
* (POST) /book/find-by-author
* (POST) /book/find-by-title
* (POST) /book/delete

