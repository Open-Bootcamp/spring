
## Medidas de seguridad en Spring 

## CSRF 

Cross-Site Request Forgery

Falsificación de solicitudes entre sitios 

Es un ataque que hace que el usuario final ejecute acciones no deseadas 
en una aplicación web en la que están autenticados actualmente. 

Mediante ingeniería social un atacante puede engañar a los usuarios de una aplicación web 
para que ejecuten acciones que elija el atacante.

## XSS 

Secuencias de comandos entre sitios

Se inyecta una secuencia de comando malintencionados en un sitio web por lo general a través
de un input para enviar código malicioso.

* Control de caché 
* Opciones de tipo de contenido
* seguridad de transporte estricta de HTTP 
* Opciones X-Frame 
* Protección X-XSS 

Spring habilita por defecto todo este tipo de medidas. 

## SQL Injection 

```sql 
"select * from table where name='" + name + "';"
```

```sql 
"select * from table where name='" + 'Pepito or 1=1;delete * from users;'
```

Sanitizar la entrada a través de parámetros: 

```
Query query = em.createQuery("SELECT * FROM table where username = :username");
query.setParameter("username", "Pepito");
```

## Más información

https://owasp.org/www-project-top-ten/


