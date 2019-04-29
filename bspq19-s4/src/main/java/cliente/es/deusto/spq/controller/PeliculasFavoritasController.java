package cliente.es.deusto.spq.controller;

import java.util.List;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class PeliculasFavoritasController {
	private RMIBSPQ19S4ServiceLocator service;
	
	public PeliculasFavoritasController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	
	public List<Pelicula> buscarPeliculasFavoritas(String favoritas) {
		try {
    		return service.getService().buscarPeliculasFavoritas(favoritas);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    	return null;
	}
}
