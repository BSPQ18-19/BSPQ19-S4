package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class AnadirPeliculaController {

	private RMIBSPQ19S4ServiceLocator service;

	public AnadirPeliculaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}

	// TODO Metodos correspondientes
	public boolean almacenarPelicula(Pelicula p) throws RemoteException {
		return service.getService().almacenarPelicula(p);
	}
}
