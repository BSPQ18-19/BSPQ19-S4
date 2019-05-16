# BSPQ19-S4
[![Build Status](https://travis-ci.com/koldou98/BSPQ19-S4LK.svg?token=DAto13p3rDajGqmgtHt8&branch=master)](https://travis-ci.com/koldou98/BSPQ19-S4LK)
# Videoclub online

## Descripción
Este es un programa para gestionar un videoclub online. Gracias al él, los usuarios registrados podrán buscar y alquilar películas durante un periodo de tiempo determinado por ellos, y pagarlas utilizando sus cuentas de paypal.

## Instalación
##### Creación de la base de datos 
- Crear una base de datos la ruta 127.0.0.1:3306 (localhost) con nombre: **bspq19-s4**
- Crear un usuario con privilegios sobre la base de datos. El nombre y contraseña del usuario ha de ser en ambos campos: **spq**
##### Cargar schema
Para cargar el schema es necesario ejecutar unos comando de Maven, en la parte del Servidor.
- Primero es necesario compilar el proyecto para hacer el enhance de las clases.
 ``` sh
    mvn clean compile 
 ```
- A continuación se creará el schema
 ``` sh
    mvn datanucleus:schema-create
 ```
