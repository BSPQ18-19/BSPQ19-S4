package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;

public class MostrarUsuariosController {
	private RMIBSPQ19S4ServiceLocator service;

	public MostrarUsuariosController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	public String[] mostrarUsuarios()throws RemoteException {
		return service.getService().mostrarUsuarios();
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
