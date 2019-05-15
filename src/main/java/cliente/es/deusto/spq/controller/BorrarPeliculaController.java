package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class BorrarPeliculaController {
	private RMIBSPQ19S4ServiceLocator service;

	public BorrarPeliculaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}

	// TODO Metodos correspondientes
	public boolean borrarPelicula(String titulo, String genero, String fEstreno, String trailer, String fichatecnica, String sinopsis, int puntuacion) throws RemoteException {
		return service.getService().borrarPelicula(titulo, genero, fEstreno, trailer, fichatecnica, sinopsis, puntuacion);
    }
}
