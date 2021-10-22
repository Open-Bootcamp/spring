
## Cifrado 

Es el proceso de codificar la información de su representación original (texto plano) 
a texto cifrado, de manera que solamente pueda ser descifrado utilizando una clave.

Historia del cifrado: 

1. Almacenar contraseñas en texto plano
2. Almacenar contraseñas cifradas con una función hash
3. Almacenar contraseñas cifradas con una función hash + salt
4. Almacenar contraseñas cifradas con una función adaptativa + factor de trabajo

La seguridad se gana haciendo que la validación de contraseñas sea costosa computacionalmente. 

## Algoritmos en Spring Security

* BCrypt 
* PBKDF2
* scrypt 
* argon2

