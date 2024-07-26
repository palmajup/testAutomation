# Proyecto de Pruebas de Contact List

## Introducción

Este proyecto de prueba incluye la verificación de las funcionalidades de alta, baja y modificación tanto en la interfaz de usuario (front) como en la API. En las pruebas de API, se incluye un servicio adicional para la creación del usuario.

### Objetivos de las Pruebas

El principal objetivo es realizar un smoke test rápido de los servicios y la integración con el front, asegurando que las funcionalidades críticas de la aplicación funcionan correctamente.

## Configuración del Entorno

### Requisitos Previos

- IntelliJ IDEA
- Java 17
- Selenium
- RestAssured

### Instalación de Dependencias

Para instalar las dependencias necesarias, utiliza las siguientes herramientas y versiones:

- Java 17
- Selenium
- RestAssured
- Libreria Bonigarcia para manejo de webDriver

### Configuración de Variables de Entorno

Asegúrate de configurar las siguientes variables de entorno:

- `JAVA_HOME`: Apunta al directorio de instalación de Java.
- `PATH`: Incluye el directorio bin de Java.

## Estructura del Proyecto
src
└── main
└── java
└── com
└── example
└── contactlist
├── ApiTest.java
├── BaseTest.java
├── CreateContactTest.java
├── DeleteContactTest.java
└── UpdateContactTest.java




