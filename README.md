# Spring Reactive MySQL 

Creacion de un crud en Mongo Reactivo con webflux

## Mongo-Reactivo
- En el application 
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/bootcamp_customer
```

### Postman

Crear: 
- http://localhost:8080/customer/create
```bash
  {
    "name": "Giancarlos",
    "lastName": "Perez Malca",
    "dni": "71702619",
    "edad": 17,
    "sexo": "M"
}
```

Listar:
- http://localhost:8080/customer/list

Listar por Id:
- http://localhost:8080/customer/find/{id}

Actualizar:
- http://localhost:8080/customer/update/{id}
```bash
  {
        "name": "Giancarlos",
        "lastName": "Perez Malca",
        "dni": "71702619",
        "edad": 27,
        "sexo": "M"
  }
```

Borrar:
- http://localhost:8080/customer/delete/{id}

