package es.deusto.spq.videoclub.data;

import java.io.Serializable;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
/**
 * Clase de Alquilar Pelicula
 * @author Jon
 *
 */
@PersistenceCapable(detachable = "true")
public class AlquilerPelicula implements Serializable {

	String id_pelicula;

	/**
	 * Constructor vacio.
	 */
	public AlquilerPelicula() {
		
	}

	
	/**
	 * Constructor de AlquilerPelicula.
	 * @param id_pelicula 
	 */
	public AlquilerPelicula(String id_pelicula) {
		super();
		this.id_pelicula = id_pelicula;
	}

	
	/**
	 * Devuelve id_pelicula
	 * @return id de la película alquilada.
	 */
	public String getId_pelicula() {
		return id_pelicula;
	}

	/**
	 * Pone el id_pelicula
	 * @param id de la película que se va a alquilar.
	 */
	public void setId_pelicula(String id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	
	//Aquí no pongo el toString
	
}
