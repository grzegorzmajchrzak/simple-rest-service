# Simple REST CRUD webservice
How to run:
```
$ mvn clean install
$ java -jar target/simple-rest-service-0.1.0.jar
```

## Available operations:
### Create new person:
```
POST http://localhost:8080/api/create
body: { "name" : "Tom"     }
```
Name is validated against regexp "\\w+".
### Read all persons:
```
GET http://localhost:8080/api/read
```
### Update created person:
```
PUT http://localhost:8080/update
body: {"name": "GregUpdated", "id": 0 }
```
### Delete person:
```
DELETE http://localhost:8080/api/delete/{id}
```
