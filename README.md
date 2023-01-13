# alticci-api

## Requisitos para rodar localmente:
- Java 17+ ou docker instalados na máquina

## Passo a passo (Java 17+/ Maven)
1 - Abra e execute no terminal os passos.
```
2 - git clone git@github.com:lmmiranda/alticci-api.git
```
```
3 - cd alticci-api/
```
```
4 - ./mvnw package 
```
```
5 - java -jar target/alticci-api-0.0.1-SNAPSHOT.jar 
```
6 - aceder no navegador: http://localhost:8080/swagger-ui/index.html#/


## Passo a passo (Docker)
1 - Abra e execute no terminal os passos.
```
2 - sudo docker run -p 8080:8080 -d lmmiranda0/alticci-api
```
3 - aceder no navegador: http://localhost:8080/swagger-ui/index.html#/
