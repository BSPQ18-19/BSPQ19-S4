package es.deusto.spq.videoclub.data;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
/**
 * Clase Pelicula
 * @author Jon
 *
 */
@PersistenceCapable(detachable = "true")
public class Pelicula implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String id_pelicula = null;
	String titulo = null;
	String genero = null;
	String fechaestreno = null;
	String fichatecnica = null;
	String opiniones = null;
	int puntuacion = 0;
	int vecesalquilada = 0;
	
	/**
	 * Constructor vacio
	 */
	public Pelicula() {
		
	}
	
	/**
	 * Constructor de Película.
	 * @param titulo Nombre de la peñicula.
	 * @param genero Género de la película (Acción, Ciencia Ficción, Romance, Cómica, Terror, Drama.. etc).
	 * @param fechaestreno Fecha en la que se estrenó la película.
	 * @param fichatecnica Breve sinópsis junto con los miembros del reparto.
	 * @param opiniones Las opiniones publicadas por la gente.
	 * @param puntuacion La puntuación dada por la gente.
	 */
	
	public Pelicula(String titulo, String genero, String fechaestreno, String fichatecnica, String opiniones,
			int puntuacion, int vecesalquilada) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.fechaestreno = fechaestreno;
		this.fichatecnica = fichatecnica;
		this.opiniones = opiniones;
		this.puntuacion = puntuacion;
		this.vecesalquilada = vecesalquilada;
	}


	/*
	 * Getters & Setters
	 */
	
	


	public String getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(String id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getFechaestreno() {
		return fechaestreno;
	}


	public void setFechaestreno(String fechaestreno) {
		this.fechaestreno = fechaestreno;
	}


	public String getFichatecnica() {
		return fichatecnica;
	}


	public void setFichatecnica(String fichatecnica) {
		this.fichatecnica = fichatecnica;
	}


	public String getOpiniones() {
		return opiniones;
	}


	public void setOpiniones(String opiniones) {
		this.opiniones = opiniones;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


	public int getVecesalquilada() {
		return vecesalquilada;
	}


	public void setVecesalquilada(int vecesalquilada) {
		this.vecesalquilada = vecesalquilada;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Película [id_pelicula=" + id_pelicula + ", titulo=" + titulo + ", genero=" + genero + ", fechaestreno="
				+ fechaestreno + ", fichatecnica=" + fichatecnica + ", opiniones=" + opiniones + ", puntuacion="
				+ puntuacion + ", vecesalquilada=" + vecesalquilada + "]";
	}

	/**
	 * Metodo To String
	 */
	

}
