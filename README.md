# Simple REST CRUD webservice

### Available operations:
1. Create new person:
```
POST http://localhost:8080/create
body: { "name" : "Tom"     }
```
Name is validated against regexp "\\w+".
2. Read all persons:
```
GET http://localhost:8080/read
```
3. Update created person:
```
PUT http://localhost:8080/update
body: {"name": "GregUpdated", "id": 0 }
```
4. Delete person:
```
DELETE http://localhost:8080/delete/{id}
```