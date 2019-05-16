package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class PeliculaController {
	private RMIBSPQ19S4ServiceLocator service;

	public PeliculaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}

	public Pelicula conseguirPelicula(String titulo) throws RemoteException {
		return service.getService().conseguirPelicula(titulo);
	}

	/**
	 * @return the service
	 */
	public RMIBSPQ19S4ServiceLocator getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
}
