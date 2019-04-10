package es.deusto.spq.dao;

import java.util.ArrayList;
import es.deusto.spq.jdo.Pelicula;


public interface IPeliculaDAO {

	//He borrado todos los métodos extra que no sean el de almacenar peliculas
	public void almacenarPelicula (Pelicula p);
	
	
}
