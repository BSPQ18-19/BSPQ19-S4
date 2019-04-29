package cliente.es.deusto.spq.controller;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.Pelicula;

public class BorrarUsuarioController {
	private RMIBSPQ19S4ServiceLocator service;

	public BorrarUsuarioController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	//TODO Metodos correspondientes
	public void borrarUsuario(Cuenta u, String nombre){
    	try{
    		service.getService().borrarUsuario(u, nombre);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
