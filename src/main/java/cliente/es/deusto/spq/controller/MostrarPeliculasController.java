package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;

public class MostrarPeliculasController {
	private RMIBSPQ19S4ServiceLocator service;

	public MostrarPeliculasController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	public String[] mostrarPeliculas()throws RemoteException {
		return service.getService().mostrarPeliculas();
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
