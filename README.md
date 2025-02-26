# 🩺 ApiMedica - API REST para Gestión Médica

## 📌 Descripción  
ApiMedica es una API REST desarrollada en **Java con Spring Boot**, diseñada para gestionar información de pacientes, médicos y citas médicas. Implementa autenticación, autorización y documentación de endpoints, facilitando su integración con otros sistemas médicos.

---

## 🚀 Características principales  
✅ **Gestión CRUD** de **pacientes, médicos y citas médicas**.  
✅ **Autenticación y Autorización** con **Spring Security** y JWT.  
✅ **Persistencia de datos** con **PostgreSQL**.  
✅ **Documentación de API** con **Swagger UI**.  
✅ **Arquitectura basada en capas**, facilitando mantenimiento y escalabilidad.

---

## 🛠️ Tecnologías utilizadas  
- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **PostgreSQL**
- **Swagger UI**
- **Maven**
- **Docker (opcional)**

---

## 🏗️ Instalación y Configuración  
### 🔹 1. Clonar el repositorio  
```bash
git clone https://github.com/LeandroMelchiori/ApiMedica.git
cd ApiMedica
```
## 🔹 2. Configurar la base de datos
Asegúrate de tener PostgreSQL instalado y crea una base de datos con el siguiente comando:
```sql
CREATE DATABASE apimedica;
```
Edita el archivo application.properties o application.yml para configurar tu conexión:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/apimedica
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

## 🔹 3. Ejecutar la aplicación
Compila y ejecuta el proyecto con Maven:
```bash
mvn spring-boot:run
```

## 🔍 Documentación de la API
La documentación de los endpoints está disponible en Swagger UI:
📌 http://localhost:8080/swagger-ui.html

## 🛠️ Endpoints principales
| Método | Endpoint       | Descripción                         |
|--------|--------------|---------------------------------|
| **POST**  | `/auth/login`   | Autenticación con JWT         |
| **POST**  | `/auth/register` | Registro de usuarios         |
| **GET**   | `/pacientes`    | Listar todos los pacientes    |
| **POST**  | `/pacientes`    | Crear un paciente            |
| **GET**   | `/medicos`      | Listar todos los médicos      |
| **POST**  | `/medicos`      | Crear un médico              |
| **GET**   | `/citas`        | Obtener todas las citas médicas |
| **POST**  | `/citas`        | Agendar una cita médica      |

