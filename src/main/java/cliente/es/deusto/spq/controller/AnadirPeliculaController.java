package cliente.es.deusto.spq.controller;

import java.rmi.RemoteException;

import cliente.es.deusto.spq.remote.RMIBSPQ19S4ServiceLocator;
import servidor.es.deusto.spq.jdo.Pelicula;

public class AnadirPeliculaController {

	private RMIBSPQ19S4ServiceLocator service;

	public AnadirPeliculaController(RMIBSPQ19S4ServiceLocator service) {
		this.service = service;
	}
	//TODO Metodos correspondientes
	public boolean almacenarPelicula(String titulo, String genero, String fEstreno, String trailer, String fichatecnica, String sinopsis, int puntuacion) throws RemoteException {
		return service.getService().almacenarPelicula(titulo, genero, fEstreno, trailer, fichatecnica, sinopsis, puntuacion);
	}
}
