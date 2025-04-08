🚍 BusApp - Gestión de buses y rutas

Aplicación Spring Boot RESTful que permite gestionar marcas de buses, buses, usuarios y roles, con autenticación JWT. Ideal para proyectos de transporte o flotas vehiculares.

## Tecnologias Usadas
- Java 17
- Spring Boot 3+
- Spring Security + JWT
- MySQL
- Maven
- JPA / Hibernate


## Configuración de Variables de Entorno

Debes definir las siguientes variables en tu entorno de desarrollo

```env
DB_URL=jdbc:mysql://localhost:3306/busapp_db
DB_USERNAME=***
DB_PASSWORD= ***

## Paso 1: Crear la base de datos `buses_db`

Asegúrate de tener una instancia de MySQL corriendo y crea una base de datos vacía llamada `buses_db`:
```sql
CREATE DATABASE buses_db;


## Paso 2: Crear un Role

Antes de registrar usuarios, es necesario crear al menos un Role en la base de datos. Esto se puede hacer de dos maneras:

- **Desde la base de datos**: ejecutando directamente un `INSERT` en la tabla `roles`:
  
  ```sql
  INSERT INTO roles (nombre) VALUES ('ROLE_USER');

-- ** O Mediante la ruta 
  
  ``` POST http://localhost:8080/roles
Authorization: Bearer <tu_token>

{
  "nombre": "ADMIN"
}

## Rutas públicas disponibles

Las siguientes rutas están accesibles sin autenticación JWT:

- `POST /auth/singin` – Registro de un nuevo usuario
- `POST /auth/login` – Inicio de sesión (devuelve un token JWT)
- `POST /role` – Creación de un nuevo rol
- `GET /bus` – Listado de buses y  su crud

Todas las demás rutas requieren autenticación con un token JWT válido.