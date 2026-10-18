# Sistema de Administración de Cadetes

Sistema web desarrollado como proyecto académico durante la realización del servicio social, orientado a la administración y gestión de información de cadetes de la Escuela Militar de Transmisiones.

## Descripción

El sistema permite centralizar y administrar información relacionada con los cadetes y sus procesos de ingreso, facilitando el registro, la consulta y la gestión de datos académicos y administrativos.

Entre sus funcionalidades se contempla la gestión de información de aspirantes y cadetes, el seguimiento de requisitos de ingreso, la identificación de antecedentes familiares relacionados con personal militar para la aplicación de criterios de admisión y la exportación de información a archivos de Excel.

El proyecto tiene como objetivo mejorar la organización de la información y facilitar las tareas administrativas mediante una aplicación web conectada a una base de datos relacional.

## Funcionalidades principales

- Registro y administración de cadetes.
- Consulta y actualización de información.
- Gestión de información de aspirantes y procesos de ingreso.
- Registro de antecedentes familiares relacionados con personal militar.
- Administración de información relacionada con exámenes de ingreso.
- Exportación de información a archivos de Excel.
- Persistencia de datos mediante una base de datos relacional.

## Tecnologías utilizadas

| Tecnología | Uso |
|---|---|
| Java | Lenguaje de programación principal |
| JavaServer Faces (JSF) | Desarrollo de la interfaz web |
| PrimeFaces 5.0 | Componentes visuales e interacción de la interfaz |
| Hibernate 4.3.1 | Mapeo objeto-relacional (ORM) y persistencia de datos |
| MariaDB | Sistema gestor de base de datos |
| MySQL Connector/J 5.1.23 | Conectividad JDBC con la base de datos |
| CSS | Estilos y presentación de la interfaz |
| JDK 8 | Entorno de desarrollo de Java |
| GlassFish Server 4.1 | Servidor de aplicaciones Java |

## Arquitectura general

La aplicación utiliza una arquitectura web basada en Java, con una interfaz construida mediante JSF y PrimeFaces, una capa de persistencia gestionada por Hibernate y una base de datos MariaDB para almacenar la información del sistema.

## Instalación y ejecución

Para configurar el proyecto en un entorno compatible:

1. Instalar el JDK 8.
2. Instalar NetBeans IDE 8.2 o un entorno compatible con el proyecto.
3. Configurar GlassFish Server 4.1.
4. Instalar y configurar MariaDB.
5. Crear la base de datos correspondiente e importar el esquema o los datos necesarios, si están disponibles.
6. Configurar las credenciales y la conexión JDBC en el proyecto.
7. Verificar las dependencias de JSF, PrimeFaces, Hibernate y MySQL Connector/J.
8. Compilar y desplegar la aplicación en GlassFish Server.

**Nota:** Los nombres de la base de datos, las credenciales y los scripts de inicialización dependen de la configuración específica del proyecto.

## Contexto del proyecto

Proyecto desarrollado con fines académicos durante el servicio social, enfocado en aplicar conocimientos de programación Java, desarrollo web, persistencia de datos y administración de bases de datos para atender necesidades de gestión escolar y administrativa.

## Autor
Junio 2024
Ing. en Computación Joshua Sebastian Aboytes Uribe
Ing. en Computación Sergio Axel Cazares Hernandez 

## Licencia

Proyecto académico. No se especifica una licencia de distribución.
