## System Requirement
- Java 23
- Maven 3.9.9


## How To Run

Before you start this project, you must clean maven before you star with :

```
mvn clean package  
```

For run the apps , you can start with
```
mvn spring-boot:run
```

ass default your program run on port 8000

## API Reference

#### Create


```http
  Post http://localhost:8000/api/examples
```

```body
{
    "name": {string},
    "description": {string}
}
```

#### Get

Get all data

```http
  GET http://localhost:8000/api/examples
```

Get data by name

```http
  GET http://localhost:8000/api/examples/{name}
```

#### Update

```http
  Put http://localhost:8000/api/examples/{name}
```

```body
{
    "name": {string},
    "description": {string}
}
```


#### Delete

```http
  DELETE http://localhost:8000/api/examples/{name}
```



