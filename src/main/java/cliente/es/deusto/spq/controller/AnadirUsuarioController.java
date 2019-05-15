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
	public boolean almacenarUsuario(String correo, String nombre, String contrasenna, String paypal, int privilegio, double gasto) throws RemoteException {
		return service.getService().almacenarUsuario(correo, nombre, contrasenna, paypal, privilegio, gasto);
		
	}
}
