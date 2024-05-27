# java-mensageria-spring-
um projeto java com mensageria usando spring e rabbitMQ 

- usando https://customer.cloudamqp.com/instance

- Exceções  tratadas com ControllerAdvice e Problem Details (RFC 7807)
- exemplo de entrada para salvar um usuario 

```
localhost:9082/user
```

```
{
    "name": "mario",
    "nome": "mario",
    "email": "hen9@ymail.com"
}
```