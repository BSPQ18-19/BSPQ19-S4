package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Cuenta;

public class AnadirUsuarioController {
	private RMIBSPQ19S4ServiceLocator service;

	public AnadirUsuarioController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	//TODO Metodos correspondientes
	public void almacenarUsuario(Cuenta c) throws RemoteException {
		service.getService().almacenarUsuario(c);
		
	}
}
