# File Service

This is a backend service that zips a file and return it to the user 

### Tools & Frameworks

* Spring boot 2
* maven3
* java17
* Swagger
* Docker

### Running the application

* `git clone https://github.com/sltet/ebie-file-service.git`
* `cd ebie-file-service && mvn clean install`
* `mvn spring-boot:run`

The application will be listening on port `8080` and the api documentation available at `http://localhost:8080/swagger-ui.html`

### Running in Docker

* `git clone https://github.com/sltet/ebie-file-service.git`
* `cd ebie-file-service && mvn clean install package`
* `docker build -t {IMAGE_NAME} .`
* `docker run -d --name {IMAGE_NAME} -p 8080:8080 {IMAGE_NAME}`

The application will be listening on port `8080` and the api documentation available at `http://localhost:8080/swagger-ui.html`


