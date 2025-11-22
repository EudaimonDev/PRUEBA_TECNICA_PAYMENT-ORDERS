🚀 Payment Initiation Application

Aplicación de ejemplo para la gestión de órdenes de pago, desarrollada con Spring Boot, PostgreSQL y enfocada en buenas prácticas de ingeniería de software:
tests unitarios, cobertura de código, estilo, análisis estático y arquitectura limpia.

📌 Requisitos previos

Java 17+

Maven 3.8+

Docker y Docker Compose

OpenAPI 3.0.3 (archivo incluido)

📄 API Contract (OpenAPI)

El archivo openapi/openapi.yaml define el contrato completo de la API Payment Initiation.

Funcionalidades principales:

Crear órdenes de pago

Consultar una orden por ID

Consultar estado de una orden

Esquemas completos para Request/Response

Ejemplos incluidos para facilitar pruebas

🐳 1. Levantar la base de datos PostgreSQL con Docker

Ubícate en el directorio raíz del proyecto:

cd C:\tu_ruta\payment-initiation


Levanta el contenedor (requiere Docker Desktop encendido):

docker compose up -d


Verifica que PostgreSQL está corriendo:

docker ps

🛠️ 2. Limpiar y compilar el proyecto
mvn clean install

▶️ 3. Ejecutar la aplicación Spring Boot
mvn spring-boot:run

🧪 4. Ejecutar tests y análisis de calidad
Ejecutar tests unitarios
mvn test

Generar informe de cobertura (JaCoCo)
mvn jacoco:report


Disponible en:
target/site/jacoco/index.html

Revisar estilo de código (Checkstyle)
mvn checkstyle:check


Informe en:
target/site/checkstyle.html

Análisis estático de código (SpotBugs)
mvn spotbugs:check


Informe en:
target/spotbugs.html

Ejecutar todo en un solo comando
mvn clean verify

📁 Estructura del proyecto
src/
└── main/
    └── java/com/tuempresa/payment_initiation
        ├── application       # Casos de uso y servicios
        ├── api               # Interfaces generadas por OpenAPI
        ├── domain            # Entidades y lógica de negocio
        ├── infrastructure    # Adapters, repositorios, controller
        └── model             # Modelos generados por OpenAPI

🧱 Buenas prácticas implementadas

Arquitectura Hexagonal (Ports & Adapters)

Tests unitarios con JUnit 5 + Mockito

Cobertura de código con JaCoCo

Estilo de código asegurado con Checkstyle

Análisis estático con SpotBugs

Separación clara de capas

Contrato API definido con OpenAPI 3.0.3
