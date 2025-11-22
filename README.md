# PRUEBA_TECNICA_PAYMENT-ORDERS
Payment Initiation Application

Aplicación de ejemplo para la gestión de órdenes de pago con Spring Boot, PostgreSQL y buenas prácticas de desarrollo Java (tests unitarios, cobertura de código, análisis estático y estilo de código).

🔹 Requisitos previos

Java 17+

Maven 3.8+

Docker y Docker Compose:
Este proyecto incluye un archivo docker-compose.yml que levanta un contenedor de PostgreSQL 15.

Archivo Openapi.yaml:
El proyecto incluye un archivo openapi/openapi.yaml que define todo el contrato de la API Payment Initiation, utilizando OpenAPI 3.0.3.

✨ Características principales del contrato:

-Creación de órdenes de pago

-Consulta de una orden por su ID

-Consulta del estado de una orden

-Esquemas definidos para todas las entidades (Request y Response)

-Ejemplos incluidos para facilitar pruebas

✅ 1. Levantar la base de datos PostgreSQL con Docker

Ubícate en el directorio raiz del proyecto una vez descargado del repositorio de github:

cd C:\tu_ruta\payment-initiation

Levanta el contenedor (teenr docker desktop encendido):

docker compose up -d

Verifica que PostgreSQL esté corriendo:

docker ps

✅ 2. Limpiar y compilar el proyecto
mvn clean
mvn install

✅ 3. Levantar la aplicación Spring Boot
mvn spring-boot:run

✅ 4. Ejecutar tests y análisis de calidad
Ejecutar tests unitarios
mvn test

Generar informe de cobertura con JaCoCo
mvn jacoco:report


Informe en: target/site/jacoco/index.html

Revisar estilo de código con Checkstyle
mvn checkstyle:check


Informe en: target/site/checkstyle.html

Analizar código con SpotBugs
mvn spotbugs:check


Informe en: target/spotbugs.html

Ejecutar todo en un solo comando
mvn clean verify

🔹 Estructura del proyecto
src/main/java/com/tuempresa/payment_initiation
├── application        # Casos de uso y servicios
|───api                #modelos generados por OPENAPI
├── domain             # Entidades y lógica de negocio
├── infrastructure     # Repositorios y adaptadores
└── model                # modelos generados por OPENAPI

🔹 Buenas prácticas incluidas

Arquitectura Hexagonal (Ports & Adapters)

Tests unitarios con JUnit 5 y Mockito

Cobertura de tests con JaCoCo

Estilo de código con Checkstyle

Análisis estático de código con SpotBugs
