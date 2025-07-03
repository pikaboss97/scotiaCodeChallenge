# 📘 Scotia Code Challenge

Este proyecto es una API REST reactiva construida con **Java 11**, **Spring Boot 2.7.7**, y **WebFlux**, implementando buenas prácticas de arquitectura limpia y separando responsabilidades por capas funcionales.

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura modular y escalable, inspirada en Clean Architecture, pero organizada por funcionalidades. Utiliza **RouterFunctions y Handlers** en lugar de controladores con anotaciones (`@RestController`), en línea con los principios de la programación funcional reactiva.

```
src/
├── main/
│   ├── java/com/example/codeChallenge/
│   │   ├── controller/         # (Opcional) Punto de entrada si decides usar anotaciones tradicionales
│   │   ├── config/             # Configuración general (Beans, Routers, etc.)
│   │   ├── exceptions/         # Manejo centralizado de errores y excepciones
│   │   ├── handler/            # HandlerFunctions para procesar las rutas REST
│   │   ├── mapper/             # Conversión entre entidades y DTOs
│   │   ├── model/              # Clases del dominio (entidades, DTOs)
│   │   ├── repository/         # Interfaces de acceso a datos (ReactiveCrudRepository)
│   │   ├── service/            # Casos de uso o lógica de negocio
│   │   ├── util/               # Funciones utilitarias, validaciones, helpers
│   │   └── StudentApplication.java  # Clase principal
│   └── resources/
│       └── application.yml     # Configuración de Spring (DB, puerto, logging)
```

## ⚙️ Tecnologías utilizadas

- Java 11
- Spring Boot 2.7.7
- Spring WebFlux
- R2DBC con H2 (base de datos en memoria)
- Gradle
- JUnit 5 + Mockito para testing

## 🧪 Endpoints disponibles

Ejemplo:

- `GET /api/v1/student/list` – Lista todos los estudiantes activos
- `POST /api/v1/student` – Registra un nuevo estudiante

(Dependerá de lo definido en `RouterRest.java` y `StudentHandler.java`)

## 🚀 ¿Cómo ejecutar?

```bash
./gradlew clean build
./gradlew bootRun
```

La aplicación se ejecutará en: [http://localhost:8080](http://localhost:8080)

## 🗃️ Base de Datos H2 (R2DBC)

Este proyecto usa una base de datos en memoria (`H2`) con conexión reactiva. Si deseas usar un archivo persistente, modifica el `application.yml` con:

```yaml
spring:
  r2dbc:
    url: r2dbc:h2:file:///./data/demo
```

## 🧪 Pruebas

Para ejecutar los tests:

```bash
./gradlew test
```

Los casos de uso principales (servicios) están cubiertos con pruebas unitarias usando JUnit y Mockito.

## ✍️ Autor

Desarrollado como parte de un challenge técnico. Estructurado para ser limpio, escalable y fácilmente testeable.
