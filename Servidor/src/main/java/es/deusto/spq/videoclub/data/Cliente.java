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
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	String nombre = null;
	String correo = null;
	String cuentapaypal = null;
	float gastototal = 0;
	
	//Lista de películas? 
	//Vistas
	//Favoritas
	//Alquiladas : Tiempo restante y Tiempo total
	
	
	/**
	 * Constructor vacio
	 */
	public Cliente() {
		
	}
	
	
	
	/**
	 * Constructor de Cliente.
	 */
	public Cliente(String nombre, String correo, String cuentapaypal, float gastototal) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.cuentapaypal = cuentapaypal;
		this.gastototal = gastototal;
	}


	/**
	 * Getters & Setters
	 */
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getCuentapaypal() {
		return cuentapaypal;
	}



	public void setCuentapaypal(String cuentapaypal) {
		this.cuentapaypal = cuentapaypal;
	}



	public float getGastototal() {
		return gastototal;
	}



	public void setGastototal(float gastototal) {
		this.gastototal = gastototal;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Metodo To String
	 */

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", correo=" + correo + ", cuentapaypal=" + cuentapaypal + ", gastototal="
				+ gastototal + "]";
	}
	
	
}
