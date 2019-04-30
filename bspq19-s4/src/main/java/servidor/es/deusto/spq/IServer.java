package servidor.es.deusto.spq;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.Pelicula;

public interface IServer extends Remote{

	public int idPeli(String nombre);
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, String peli);
	public boolean esAdmin(String correo);
	public boolean esUser(String user);
	public boolean passCorrecta(String user, String pass);
	List<Pelicula> buscarPeliculasFavoritas(String favoritas);
	List<Pelicula> buscarPeliculasVistas(String vistas);
	public void borrarPelicula(String titulo);
	public void borrarUsuario(String correo);
	public void almacenarUsuario (Cuenta c);
	public void almacenarPelicula (Pelicula p);
	


}