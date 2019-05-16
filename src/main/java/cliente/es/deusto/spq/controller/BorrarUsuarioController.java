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
	public void borrarUsuario(String correo) throws RemoteException {
		service.getService().borrarUsuario(correo);
    }
}
