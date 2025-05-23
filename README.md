Este proyecto es una API RESTful para la gestión de cuentas bancarias, clientes y movimientos, desarrollada con **Java**, **Spring Boot**, **Arquitectura Onion**, **MySQL** y **Swagger/OpenAPI**.

## ⚙️ Requisitos

- Java 17 o superior
- Maven 3.8+
- MySQL Server
- IDE (IntelliJ IDEA, Eclipse, VS Code)
- XAMPP/WAMP (opcional, para phpMyAdmin)

---

## 🛠️ Configuración del Entorno

1. **Clona el repositorio**:

https://github.com/Sara-Morales/PruebaConfiar

cd api-bancaria

spring.datasource.url=jdbc:mysql://localhost:3306/banco_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=confiar
spring.datasource.password=confiarprueba
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Asegúrate de tener la base de datos banco_db creada en MySQL.

## Ejecuta el proyecto:

./mvnw spring-boot:run

## Endpoints disponibles
Una vez iniciado, accede a:

Swagger UI:
http://localhost:8080/swagger-ui/index.html

phpMyAdmin (si usas XAMPP/WAMP):
http://localhost/phpmyadmin/

## 🧑‍💻 Autor
Desarrollado por Sara Melissa Morales
📧 Contacto: moralessaramelissa@gmail.com
Celular: 3127803113
