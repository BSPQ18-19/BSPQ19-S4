package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;

public class LoginController {
	private RMIBSPQ19S4ServiceLocator service;

	public LoginController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}

	public boolean esAdmin(String nombre) throws RemoteException {
		return service.getService().esAdmin(nombre);
	}

	public boolean esUser(String nombre) throws RemoteException {
		return service.getService().esUser(nombre);
	}

	public boolean contrasenna(String nombre, String pass) throws RemoteException {
		return service.getService().passCorrecta(nombre, pass);
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
