package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;

public class ContrasenyaController {

	private RMIBSPQ19S4ServiceLocator service;

	public ContrasenyaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	public boolean correo(String nombre, String correo) throws RemoteException{
		return service.getService().correo(nombre,correo);
	}
	public String contrasenya(String nombre) throws RemoteException {
		return service.getService().contrasenya(nombre);
	}
}
