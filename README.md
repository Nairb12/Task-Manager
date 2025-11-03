# 🧾 --- Gestor de Tareas (Task Manager)

## 📋 Descripción del Proyecto

**Gestor de Tareas (Task Manager)** es una aplicación **CRUD**
desarrollada con **Spring Boot 3.5.7 y Java 21**, cuyo objetivo es
gestionar tareas personales, aplicando los fundamentos de desarrollo
backend con: - Controladores REST - Servicios e inyección de
dependencias - Persistencia con **Spring Data JPA** - Autenticación y
autorización con **Spring Security + JWT** - Documentación con **Swagger
UI**

El proyecto fue desarrollado como práctica formativa para reforzar los
conocimientos en arquitectura Spring Boot y principios de programación
orientada a objetos.

---

## 🎯 Objetivo del Proyecto

Crear una aplicación CRUD para gestionar tareas personales, aprendiendo los fundamentos de 
Spring Boot, como controladores, servicios, repositorios, entidades, y uso de base de datos.

------------------------------------------------------------------------

## 🧱 Estructura del Proyecto 

[src/main/java/com/example/hitss/springboot/taskmanager](taskmanager/src/main/java/com/example/hitss/springboot/taskmanager)<br>


    ├── controllers/        → Controladores REST (Auth, User, Task)
    ├── models/             → Entidades JPA (User, Role, Task)
    ├── repositories/       → Interfaces que extienden JpaRepository
    ├── security/           → Configuración de JWT y filtros de seguridad
    ├── services/           → Interfaces de servicio
    │   └── impl/           → Implementaciones de servicios
    ├── validation/         → Validaciones personalizadas
    ├── utils/              → Clase de apoyo (UtilCrud)
    ├── SwaggerConfig.java  → Clase principal, configuracion basica de Swagger
    └── TaskmanagerApplication.java → Clase principal

------------------------------------------------------------------------

## ⚙️ Tecnologías Utilizadas

| Componente                    | Tecnología                                 |
|------------------------------|---------------------------------------------|
| **Lenguaje**                 | Java 21                                     |
| **Framework Backend**        | Spring Boot 3.5.7                           |
| **Base de Datos**            | MySQL                                       |
| **ORM**                      | Spring Data JPA                             |
| **Seguridad**                | Spring Security + JWT                       |
| **Validación**               | Jakarta Validation (Hibernate Validator)    |
| **Documentación**            | Swagger (Springdoc OpenAPI 2.6.0)           |
| **Herramienta de compilación** | Maven                                     |
| **IDE**                      | Visual Studio Code / IntelliJ IDEA          |


------------------------------------------------------------------------

## 🚀 Ejecución del Proyecto

### 🔧 Requisitos previos

-   Java 21 o superior\
-   Maven instalado\
-   MySQL en ejecución

### ⚙️ Configuración de la base de datos

Modifica el archivo `src/main/resources/application.properties`:

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=tu_user
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### ▶️ Ejecución

Desde la raíz del proyecto:

``` bash
mvn spring-boot:run
```

O en VS Code/IntelliJ, ejecuta la clase:

    TaskmanagerApplication.java

La aplicación se iniciará en:

    http://localhost:8080

------------------------------------------------------------------------

## 📚 Documentación Swagger

Accede a la documentación de la API: 👉
**http://localhost:8080/swagger-ui.html**
![Documentacion Swagger](img_readme/image-14.png)

------------------------------------------------------------------------

## 🧩 Endpoints Principales

### 🔐 Autenticación

  Método   Endpoint                Descripción
  -------- ----------------------- --------------------------------------
  POST     `/login`                Autentica usuario y genera token JWT<br>
  ![imagen de post](img_readme/image.png) 
  
  POST     `/api/users/register`   Registra nuevo usuario <br>
  ![imagen de register swagger](img_readme/image-1.png)

------------------------------------------------------------------------

### 👤 Usuarios

  Método   Endpoint       Descripción
  -------- -------------- -----------------------------------------
  GET      `/api/users`   Lista todos los usuarios *(solo ADMIN)* <br>
![Muestra todos los usarios ](img_readme/image-2.png) <br>
  POST     `/api/users`   Crea un usuario Admin *(solo ADMIN)* <br>
  ![Creacion de admin](img_readme/image-4.png)
------------------------------------------------------------------------

### 📝 Tareas (Tasks) ADMIN

  Método   Endpoint            Descripción
  -------- ------------------- ---------------------------------------
  GET      `/api/tasks`        Lista todas las tareas *(USER/ADMIN)* <br>
  ![Muestra todas las tareas](img_readme/image-5.png)<br>
  GET      `/api/tasks/{id}`   Obtiene una tarea específica <br>
  ![Busca y muestra la tarea por id](img_readme/image-6.png) <br>
  POST     `/api/tasks`        Crea una nueva tarea *(USER/ADMIN)* <br>
  ![Crea una nueva tarea](img_readme/image-7.png) <br> 
  PUT      `/api/tasks/{id}`   Actualiza una tarea *(solo ADMIN)* <br>
  ![Actualizar tarea](img_readme/image-8.png) <br>
  DELETE   `/api/tasks/{id}`   Elimina una tarea *(solo ADMIN)*<br>
![Elimina una tarea](img_readme/image-9.png)
------------------------------------------------------------------------
### 📝 Tareas (Tasks) USER
![Usuario Testing](img_readme/image-10.png) <br>

  Método   Endpoint            Descripción
  -------- ------------------- ---------------------------------------
  GET      `/api/tasks`        Lista todas las tareas *(USER/ADMIN)* <br>
  ![Muestra todas las tareas](img_readme/image-5.png)<br>
  GET      `/api/tasks/{id}`   Obtiene una tarea específica <br>
  ![Busca y muestra la tarea por id](img_readme/image-6.png) <br>
  POST     `/api/tasks`        Crea una nueva tarea *(USER/ADMIN)* <br>
  ![Crea una nueva tarea como user](img_readme/image-11.png) <br> 
  PUT      `/api/tasks/{id}`   Actualiza una tarea *(solo ADMIN)* <br>
 ![Error al actualizar una tarea](img_readme/image-12.png) <br>
  DELETE   `/api/tasks/{id}`   Elimina una tarea *(solo ADMIN)*<br>
![Error al querer eliminar una tarea](img_readme/image-13.png)
------------------------------------------------------------------------
## 🧠 Roles y Permisos

  Rol         Permisos
  ----------- -----------------------------------------------
  **USER**    Crear tareas, listar tareas
  **ADMIN**   CRUD completo de tareas y gestión de usuarios

------------------------------------------------------------------------

## 🧰 Manejo de errores

Y validaciones con `@Valid`:<br>
![Error al querer eliminar una tarea](img_readme/image-3.png)

``` json
{
  "username": "El campo username el tamaño debe estar entre 5 y 20"
}
```

------------------------------------------------------------------------

## 🧱 Ejemplo de token JWT

**Login:**

``` json
POST /login
{
  "username": "Brian",
  "password": "12345"
}
```

**Respuesta:**

``` json
{
    "message": "Hola Brian has iniciado sesión con exito",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCcmlhbiIsImF1dGhvcml0aWVzIjoiW3tcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJ1c2VybmFtZSI6IkJyaWFuIiwiZXhwIjoxNzYyMTQzNzQ0LCJpYXQiOjE3NjIxNDAxNDR9.4vGmiVmrhEKXKTnMLp91oZ0OAM5Gh3Cc7BmmbqVhpto",
    "username": "Brian"
}
```

Usa este token en los encabezados:

    Authorization: Bearer <tu_token>

------------------------------------------------------------------------

## 🧩 Estructura de Base de Datos (Modelo ER)

![BD](img_readme/image-15.png)

------------------------------------------------------------------------

## 👨‍💻 Autor

**Nombre:** \[Brian Gonzalez Gayosso\]\
**Fecha:** \[Octubre / 2025\]\
**Institución o Proyecto:** HITSS / Proyecto formativo Spring Boot

------------------------------------------------------------------------
