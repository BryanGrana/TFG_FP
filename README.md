# Gestión de Trabajadores y Proyectos - Java Swing
## Descripción
Este repositorio contiene una aplicación de gestión de trabajadores y proyectos desarrollada en Java utilizando la biblioteca Swing para la interfaz gráfica. La aplicación está diseñada como Trabajo de Fin de Grado (TFG) para el ciclo formativo de grado superior en Desarrollo de Aplicaciones Multiplataforma (DAM). La aplicación permite gestionar la relación N
entre trabajadores y proyectos, facilitando la asignación y seguimiento de proyectos a los trabajadores.

## Características
- Gestión de Trabajadores: Alta, baja, modificación y consulta de trabajadores.
- Gestión de Proyectos: Alta, baja, modificación y consulta de proyectos.
- Asignación de Trabajadores a Proyectos: Asignar y desasignar trabajadores a uno o varios proyectos.
- Interfaz Gráfica: Desarrollada con Java Swing, proporcionando una experiencia de usuario intuitiva y fácil de usar.
- Persistencia de Datos: Utilización de bases de datos para almacenar y gestionar la información de trabajadores y proyectos.
## Instalación
### Prerrequisitos
JDK 8 o superior
Un entorno de desarrollo integrado (IDE) como IntelliJ IDEA, Eclipse o NetBeans
Biblioteca JDBC para la conexión a la base de datos
Pasos para la instalación
Clona este repositorio en tu máquina local:
```
git clone https://github.com/tu-usuario/gestion-trabajadores-proyectos.git
```
Abre el proyecto en tu IDE preferido.
Configura la conexión a la base de datos en el archivo config.properties.
Ejecuta la aplicación desde tu IDE.
## Uso
- Panel principal: Navega por las distintas secciones utilizando el menú desplegable.
- Gestión de Trabajadores: Agrega, modifica, elimina y consulta la información de los trabajadores.
- Gestión de Proyectos: Agrega, modifica, elimina y consulta la información de los proyectos.
- Asignación de Proyectos: Asigna trabajadores a proyectos y visualiza las asignaciones existentes.

## Tecnologías Utilizadas
- Java: Lenguaje de programación principal.
- Swing: Biblioteca para la creación de la interfaz gráfica.
- JDBC: API para la conexión a la base de datos.
- MySQL/PostgreSQL: Sistema de gestión de bases de datos relacional.
## Estructura del Proyecto
- src/: Código fuente de la aplicación.
- main/java/: Paquetes y clases principales.
- main/resources/: Archivos de recursos y configuración.
- lib/: Librerías necesarias para la ejecución.
- README.md: Este archivo.
## Base de datos
```
-- Create Worker table
CREATE TABLE Workers (
 ID INT AUTO_INCREMENT PRIMARY KEY,
 Image_Path VARCHAR(255) NOT NULL,
 First_Name VARCHAR(25) NOT NULL,
 Last_Name VARCHAR(50) NOT NULL,
 Email VARCHAR(100),
 Date_of_Birth DATE NOT NULL,
 Phone VARCHAR(9) NOT NULL CHECK (Phone REGEXP '^[0-9]{9}$'),
 Address VARCHAR(100) NOT NULL
);

-- Create Projects table
CREATE TABLE Projects (
 ID INT AUTO_INCREMENT PRIMARY KEY,
 Name VARCHAR(100) NOT NULL,
 Description VARCHAR(255) NOT NULL,
 Budget DECIMAL(10,2),
 Start_Date DATE NOT NULL,
 End_Date DATE
);

-- Create project_worker relationship table with composite primary key
CREATE TABLE project_worker (
 Worker_ID INT,
 Project_ID INT,
 Role ENUM('Leader','Member','Collaborator') DEFAULT 'Member',
 Assigned_Hours_Per_Week TINYINT CHECK (Assigned_Hours_Per_Week BETWEEN 0 AND 40),
 Assignment_Date DATE DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (Worker_ID) REFERENCES Workers(ID) ON UPDATE CASCADE ON DELETE NO ACTION,
 FOREIGN KEY (Project_ID) REFERENCES Projects(ID) ON UPDATE CASCADE ON DELETE NO ACTION,
 PRIMARY KEY (Worker_ID, Project_ID)
);
```
## Contribuciones
¡Las contribuciones son bienvenidas! 
#### Por favor, sigue los siguientes pasos para contribuir:
- Realiza un fork del repositorio.
- Crea una nueva rama para tu funcionalidad (git checkout -b nueva-funcionalidad).
- Realiza los cambios necesarios y realiza commit (git commit -m 'Añadir nueva funcionalidad').
- Empuja los cambios a tu rama (git push origin nueva-funcionalidad).
- Crea un Pull Request en GitHub.

## Autor
Bryan Graña Martínez
## Contacto
Para cualquier duda o sugerencia, contáctame por correo electrónico:
- [Email](mailto:bryangranamartinez@gmail.com)
