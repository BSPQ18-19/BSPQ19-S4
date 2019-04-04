/* DELETE 'bspq19-s4' database*/
DROP SCHEMA bspq19-s4;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER 'spq'@'localhost';

/* CREATE 'bspq19-s4' DATABASE */
CREATE SCHEMA bspq19-s4;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER 'spq'@'localhost' IDENTIFIED BY 'spq';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'spq' AT LOCAL SERVER*/
GRANT ALL ON bspq19-s4.* TO 'spq'@'localhost';
