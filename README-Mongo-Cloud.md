# Spring Reactive Mongo Atlas

Ingresar a su pagina oficial ,loguearse e ingresar:  https://www.mongodb.com/cloud

## Creacion de Base De Datos
- En la pagina de Mongo Atlas.
```bash
 sgt
 Build Cluster
 FREE
 aws -> free tire
 Create Cluster
```

## Creacion de Usuario
- En Security
```bash
 Database Access
 Add New Database User
 Password Authentication: 
  Rellenar con user and userpassword
 Add User
```

## Creacion de IP de acceso
- En Network Access
```bash
 ADD IP ADDRESS
 ADD CURRENT IP ADDRESS
 GUARDAR
```

### CONECTARSE A LA BASE DE DATOS
- En EL CLUSTER DE MONGO ATLAS
```bash
 CONECT
 Connect using MongoDB Compass
 copy the connection string:
        mongodb+srv://<username>:<password>@cluster0.zyw55.mongodb.net/test
```

### CONECTARSE A LA BASE DE DATOS DE MONGO COMPAS
- En DataBase : pegamos y reemplazamos por el user y password del usuario Creado.
```bash
 NEW CONECTION
 URI: mongodb+srv://user:userpassword@cluster0.zyw55.mongodb.net/test
 CONNECT
```

### CONECTARSE A SPRINGBOOT
- En INTELLIJ : pegamos y reemplazamos por el user y password del usuario Creado.
```bash
 spring.data.mongodb.uri=mongodb+srv://user:userpassword@cluster0.zyw55.mongodb.net/test
```