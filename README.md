## 🛠 Tecnologías

- **Backend:** Java, Spring Boot, Spring Security, JPA, JWT
- **Frontend:** React, TypeScript, Bootstrap
- **Base de Datos:**  (Mysql

** Acceder a la API:

- La API estará disponible en http://localhost:8080
- Ruta de API documentada  http://localhost:8080/swagger-ui.html


### Base de Datos
- `Antes de ejecutar la aplicación, asegúrate de crear la base de datos manualmente si usas MySQL`
- `Hibernate se encarga de crear las tablas automaticamente `

### Pasos 
- `Primero se deben crear datos para las marcas`
- `Luego crear Bus y ahi  le asisgnas una marca`


## Este es un ejemplo del cuerpo que debes enviar para registrar una nueva marca  en el sistema.

- `POST  http://localhost:8080/marca`
```json
{
  "nombre": "Volvo"
}
```


## Este es un ejemplo del cuerpo que debes enviar para registrar un nuevo bus  en el sistema.
- `POST  http://localhost:8080/bus`
```json
{
  "numeroBus": "B-4567",
  "placa": "XYZ-789",
  "caracteristicas": "Bus moderno con WiFi y aire acondicionado",
  "marca": {
    "id": 1
  }
}

```

## 🧩 Estructura de Entidades

### 🚍 Bus

- `id`: Long
- `numeroBus`: String
- `placa`: String
- `caracteristicas`: String
- `fechaCreacion`: LocalDateTime (se genera automáticamente)
- `activo`: Boolean (se maneja automáticamente)
- `marca`: MarcaDTO

### 🏷 Marca

- `id`: Long
- `nombre`: String
- `buses`: List<BusDTO>

### 🧑 Usuario

- `id`: Long
- `username`: String
- `password`: String
- `rol`: RolDTO

### 🛡 Rol

- `id`: Long
- `nombre`: String

---

## 📦 Funcionalidad CRUD

Cada una de las entidades cuenta con endpoints REST que permiten su gestión básica (CRUD):

### 📘 Bus

| Método | Endpoint       | Descripción             |
|--------|----------------|-------------------------|
| GET    | `/bus`         | Listar todos los buses (paginado) |
| GET    | `/bus/{id}`    | Buscar bus por ID       |
| POST   | `/bus`         | Crear nuevo bus         |
| PUT    | `/bus/{id}`    | Actualizar un bus       |
| DELETE | `/bus/{id}`    | Eliminar un bus         |

### 📗 Marca

| Método | Endpoint      | Descripción             |
|--------|---------------|-------------------------|
| GET    | `/marca`      | Listar marcas           |
| POST   | `/marca`      | Crear marca             |
| PUT    | `/marca/{id}` | Actualizar marca        |
| DELETE | `/marca/{id}` | Eliminar marca          |

### 📕 Usuario

| Método | Endpoint       | Descripción            |
|--------|----------------|------------------------|
| POST   | `/auth/login`  | Iniciar sesión         |
| POST   | `/auth/singin` | Registrar nuevo usuario|

> ⚠ La autenticación se realiza mediante JWT.

### 📙 Rol

| Método | Endpoint   | Descripción       |
|--------|------------|-------------------|
| GET    | `/role`    | Listar roles      |
| POST   | `/role`    | Crear rol         |

---

## 🔐 Seguridad

La aplicación protege todos los endpoints excepto los siguientes:

- `/auth/login`
- `/auth/singin`
- `/role`
- `/bus` (GET sin token, configurable)

La autenticación usa JWT y Spring Security para proteger las rutas.

---

## 🚀 Instrucciones para levantar el proyecto

### Backend

1. Clonar el repositorio
2. Importar como proyecto Maven o Gradle
3. Ejecutar `RetoTecnicoApplication.java`

