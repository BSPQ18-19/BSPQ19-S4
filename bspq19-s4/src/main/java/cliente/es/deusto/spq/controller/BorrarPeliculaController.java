package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class BorrarPeliculaController {
	private RMIBSPQ19S4ServiceLocator service;

	public BorrarPeliculaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}

	// TODO Metodos correspondientes
	public void borrarPelicula(String titulo) throws RemoteException {
		service.getService().borrarPelicula(titulo);
    }
}
