package cliente.es.deusto.spq.controller;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class BorrarPeliculaController {
	private RMIBSPQ19S4ServiceLocator service;

	public BorrarPeliculaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	
	//TODO Metodos correspondientes
	public void borrarPelicula(Pelicula p, String titulo){
    	try{
    		service.getService().borrarPelicula(p, titulo);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
