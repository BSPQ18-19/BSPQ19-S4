package es.deusto.spq.videoclub.dao;

import java.util.ArrayList;

import es.deusto.spq.videoclub.data.Pelicula;
import es.deusto.spq.videoclub.data.Alquiler;
import es.deusto.spq.videoclub.data.AlquilerPelicula;

/**
 * Clase de creación de interfaz DAO de Pelicula
 * @author Jon
 */
public interface IPeliculaDAO {

	public Pelicula getPelicula (String titulo);
	public ArrayList<String> getPeliculas();
	public void almacenarPelicula (Pelicula p);
	public Pelicula verPelicula(String titulo);
	public void anyadirPuntuacion(String id_pelicula, int puntuacion);
	public void anyadirOpinion(String id_pelicula, String opiniones);
	
	
}
