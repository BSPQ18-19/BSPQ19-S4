# BSPQ19-S4
[![Build Status](https://travis-ci.com/BSPQ18-19/BSPQ19-S4.svg?branch=master)](https://travis-ci.com/BSPQ18-19/BSPQ19-S4)

# Videoclub online

## Descripción
Este es un programa para gestionar un videoclub online. Gracias al él, los usuarios registrados podrán buscar y alquilar películas durante un periodo de tiempo determinado por ellos, y pagarlas utilizando sus cuentas de paypal.

## Instalación
### Creación de la base de datos 
- Primero es necesario borrar si existe el schema y el usuario de la base de datos.
 ``` sh
    DROP SCHEMA IF EXISTS bspq19s4;
    DROP USER IF EXISTS 'spq'@'%';
 ```
- A continuación se creará el schema y se le asignará el usuario.
 ``` sh
    CREATE SCHEMA bspq19s4;
    CREATE USER IF NOT EXISTS 'spq'@'%' IDENTIFIED BY 'spq';
 ```
- Finalmente se le concederan permisos al usuario
 ``` sh
    GRANT ALL ON bspq19s4.* TO 'spq'@'%';
 ```
 
### Creación de las tablas:
- Primero es necesario compilar el proyecto para hacer el enhance de las clases.
 ``` sh
    mvn clean compile 
 ```
- A continuación se crearán las tablas
 ``` sh
    mvn datanucleus:schema-create
 ```
