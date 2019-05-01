package servidor.es.deusto.spq.jdo;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable
public class Peliculas_Cuenta{

    private String fAlq;    //Fecha hasta que se alquila la peli
    private int tAql;    //Tiempo de alquiler de la peli

    public Peliculas_Cuenta(String fAlq, int tAlq){

        this.fAlq = fAlq;
        this.tAql = tAlq;
    }
    
}