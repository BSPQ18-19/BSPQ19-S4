package servidor.es.deusto.spq;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import servidor.es.deusto.spq.jdo.Pelicula;

public interface IServer extends Remote{

	public int idPeli(String nombre) throws RemoteException;
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, String peli) throws RemoteException;
	List<Pelicula> buscarPeliculasFavoritas(String favoritas) throws RemoteException;
	List<Pelicula> buscarPeliculasVistas(String vistas) throws RemoteException;
	void borrarPelicula(String titulo) throws RemoteException;
	void borrarUsuario(String nombre) throws RemoteException;
}