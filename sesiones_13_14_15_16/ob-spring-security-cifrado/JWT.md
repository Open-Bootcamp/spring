
## JWT 

https://jwt.io/introduction

Es un estándar abierto que permite transmitir información entre dos partes.

JSON Web Token

## Funcionamiento Session

1. Cliente envía una petición a un servidor (/api/login)
2. Servidor valida username y password, si no son válidos devolverá una respuesta 401 unauthorized
3. Servidor valida username y password, si sí son válidos entonces se almacena el usuario en session
4. Se genera una cookie en el Cliente
5. En próximas peticiones se comprueba que el cliente está en session 

Desventajas: 

* La información de la session se almacena en el servidor, lo cual consume recursos.


## Funcionamiento JWT

1. Cliente envía una petición a un servidor (/api/login)
2. Servidor valida username y password, si no son válidos devolverá una respuesta 401 unauthorized
3. Servidor valida username y password, si sí son válidos entonces genera un token JWT utilizando una secret key
4. Servidor devuelve el token JWT generado al Cliente 
5. Cliente envía peticiones a los endpoints REST del servidor utilizando el token JWT en las cabeceras
6. Servidor valida el token JWT en cada petición y si es correcto permite el acceso a los datos

Ventajas: 

* El token se almacena en el Cliente, de manera que consume menos recursos en el Servidor, lo cual permite mejor escalabilidad

Desventajas: 

* El token está en el navegador, no podríamos invalidarlo antes de la fecha de expiración asignada cuando se creó
  * Lo que se realiza es dar la opción de logout, lo cual simplemente borra el token

## Estructura del token JWT 

3 partes separadas por un punto (.) y codificadas en base 64 cada una: 

1. Header

```json
{   
    "alg": "HS512",
    "typ": "JWT"
}
```

2. Payload (información, datos del usuario, no sensibles)

```json
{
  "name": "John Doe",
  "admin": true
}
```

3. Signatura

```
HMACKSHA256(
base64UrlEncode(header) + "." + base64UrlEncode(payload), secret
)
```

Ejemplo del token generado: 

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

El User-Agent envía el token JWT en las cabeceras: 

```
Authorization: Bearer <token>
```

## Configuración Spring

Crear proyecto Spring Boot con:

* Spring Security 
* Spring Web 
* Spring boot devtools
* Spring Data JPA 
* PostgreSQL 
* Dependencia jwt (se añade manualmente en pom.xml)

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
```