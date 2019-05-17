package servidor.es.deusto.spq.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable
public class Peliculas_Cuenta implements Serializable{

    private String fAlq;    //Fecha hasta que se alquila la peli
    private int tAql;    //Tiempo de alquiler de la peli
    private String nombre;
    private String titulo;
    
    public Peliculas_Cuenta(String fAlq, int tAlq, String nombre, String titulo){

        this.fAlq = fAlq;
        this.tAql = tAlq;
        this.nombre = nombre;
        this.titulo = titulo;
    }
    
}