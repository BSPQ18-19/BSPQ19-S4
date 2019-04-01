package es.deusto.spq.videoclub.data;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
/**
 * Clase Alquiler
 * @author Jon
 *
 */
@PersistenceCapable(detachable = "true")
public class Alquiler implements Serializable {

	private static final long serialVersionUID = 1L;
	String id_alquiler;
	String id_pelicula;
	String dni_respon;
	String fecha;
	String hora;
	
	/**
	 * Constructor vacio
	 */
	public Alquiler() {
		
	}

	/**
	 * Constructor de Alquiler.
	 * @param id_alquiler
	 * @param id_pelicula
	 * @param dni_respon
	 * @param fecha
	 * @param hora
	 */
	
	public Alquiler(String id_alquiler, String id_pelicula, String dni_respon, String fecha, String hora) {
		super();
		this.id_alquiler = id_alquiler;
		this.id_pelicula = id_pelicula;
		this.dni_respon = dni_respon;
		this.fecha = fecha;
		this.hora = hora;
	}

	public String getId_alquiler() {
		return id_alquiler;
	}

	public void setId_alquiler(String id_alquiler) {
		this.id_alquiler = id_alquiler;
	}

	public String getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(String id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getDni_respon() {
		return dni_respon;
	}

	public void setDni_respon(String dni_respon) {
		this.dni_respon = dni_respon;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Metodo To String
	 */
	
	@Override
	public String toString() {
		return "Alquiler [id_alquiler=" + id_alquiler + ", id_pelicula=" + id_pelicula + ", dni_respon=" + dni_respon
				+ ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
}
