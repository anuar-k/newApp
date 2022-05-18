# GET http://localhost:8080/user/
 {
        "id":1,
        "name": "Test",
        "surname": "Test",
        "email": "mike@gmail.com",
        "phone": "12313",
        "photo": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Mike_Tyson_2019_by_Glenn_Francis.jpg/1024px-Mike_Tyson_2019_by_Glenn_Francis.jpg",
        "password": "Test"
    }
    
#UPDATE 
POST http://localhost:8080/user/update/{id}
 {
        "name": "1",
        "surname": "1",
        "email": "1",
        "phone": "1",
        "photo": "1"
}

#DELETE
GET http://localhost:8080/user/update/1111
