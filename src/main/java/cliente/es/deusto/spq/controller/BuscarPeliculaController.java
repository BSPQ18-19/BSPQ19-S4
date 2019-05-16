package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;

public class BuscarPeliculaController {
	private RMIBSPQ19S4ServiceLocator service;

	public BuscarPeliculaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	public String[] buscarPeliculasTitulo()throws RemoteException {
		return service.getService().buscarPeliculasTitulo();
	}
	public String[] buscarPeliculasGenero()throws RemoteException {
		return service.getService().buscarPeliculasGenero();
	}
	public String[] buscarPeliculasFecha()throws RemoteException {
		return service.getService().buscarPeliculasFecha();
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
