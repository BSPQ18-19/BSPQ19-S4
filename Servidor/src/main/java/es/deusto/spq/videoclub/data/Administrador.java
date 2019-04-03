package es.deusto.spq.videoclub.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase Administrador
 * @author Jon
 *
 */

@PersistenceCapable(detachable = "true")
public class Administrador implements Serializable {

	private static final long serialVersionUID = 1L;
	String nombreadmin = null;
	String correoadmin = null;
	
	
	/**
	 * Constructor vacio
	 */
	public Administrador() {
		
	}
	
	
	/**
	 * Constructor de la clase Administrador.
	 */
	public Administrador(String nombre, String correo) {
		super();
		this.nombreadmin = nombre;
		this.correoadmin = correo;
	}

	
	/**
	 * Getters & Setters
	 */
	public String getNombre() {
		return nombreadmin;
	}


	public void setNombre(String nombre) {
		this.nombreadmin = nombre;
	}


	public String getCorreo() {
		return correoadmin;
	}


	public void setCorreo(String correo) {
		this.correoadmin = correo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Metodo To String
	 */
	@Override
	public String toString() {
		return "Administrador [nombreadmin=" + nombreadmin + ", correoadmin=" + correoadmin + "]";
	}


	
	
	
	
}
