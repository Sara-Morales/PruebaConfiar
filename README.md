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

Antes de ejecutar el proyecto, crea la base de datos y un usuario con los siguientes comandos SQL:

```sql
CREATE DATABASE banco_db;

CREATE USER 'confiar'@'localhost' IDENTIFIED BY 'confiarprueba';
GRANT ALL PRIVILEGES ON banco_db.* TO 'confiar'@'localhost';
FLUSH PRIVILEGES;

User:confiar
password: confiarprueba
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
