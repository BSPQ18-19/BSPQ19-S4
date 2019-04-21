package servidor.es.deusto.spq.jdo;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.identity.LongIdentity;

@PersistenceCapable
public class Peliculas_Cuenta{

    private String fAlq;    //Fecha hasta que se alquila la peli
    private String tAql;    //Tiempo de alquiler de la peli

    public Peliculas_Cuenta(String fAlq, String tAlq){

        this.fAlq = fAlq;
        this.tAql = tAlq;
    }
    
}