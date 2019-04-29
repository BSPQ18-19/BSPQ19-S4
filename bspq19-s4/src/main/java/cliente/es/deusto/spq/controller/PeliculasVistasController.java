package cliente.es.deusto.spq.controller;

import java.util.List;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class PeliculasVistasController {
	private RMIBSPQ19S4ServiceLocator service;
	
	public PeliculasVistasController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	
	public List<Pelicula> buscarPeliculasVistas(String vistas) {
		try {
    		return service.getService().buscarPeliculasVistas(vistas);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    	return null;
	}
}
