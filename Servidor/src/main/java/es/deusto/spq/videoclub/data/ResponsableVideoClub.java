package es.deusto.spq.videoclub.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase Cliente
 * @author Jon
 *
 */

@PersistenceCapable(detachable = "true")
public class ResponsableVideoClub implements Serializable{

	private static final long serialVersionUID = 1L;
	String nombrerespon = null;
	String correorespon = null;
	
	
	/**
	 * Constructor vacio
	 */
	public ResponsableVideoClub() {
		
	}
	
	
	/**
	 * Constructor de la clase Administrador.
	 */
	public ResponsableVideoClub(String nombrerespon, String correorespon) {
		super();
		this.nombrerespon = nombrerespon;
		this.correorespon = correorespon;
	}


	/**
	 * Getters & Setters
	 */
	public String getNombrerespon() {
		return nombrerespon;
	}


	public void setNombrerespon(String nombrerespon) {
		this.nombrerespon = nombrerespon;
	}


	public String getCorreorespon() {
		return correorespon;
	}


	public void setCorreorespon(String correorespon) {
		this.correorespon = correorespon;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * Metodo To String
	 */
	@Override
	public String toString() {
		return "ResponsableVideoClub [nombrerespon=" + nombrerespon + ", correorespon=" + correorespon + "]";
	}
	
	
	
	
}
