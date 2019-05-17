package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Cuenta;

public class PerfilController {
	private RMIBSPQ19S4ServiceLocator service;

	public PerfilController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}

	public Cuenta conseguirUsuario(String nombre) throws RemoteException {
		return service.getService().conseguirUsuario(nombre);
	}

	/**
	 * @return the service
	 */
	public RMIBSPQ19S4ServiceLocator getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
}
