package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.Pelicula;

public class BorrarUsuarioController {
	private RMIBSPQ19S4ServiceLocator service;

	public BorrarUsuarioController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}

	// TODO Metodos correspondientes
	public boolean borrarUsuario(String correo, String nombre, String contrasenna, String paypal, int privilegio, double gasto) throws RemoteException {
		return service.getService().borrarUsuario(correo, nombre, contrasenna, paypal, privilegio, gasto);
    }	
}
