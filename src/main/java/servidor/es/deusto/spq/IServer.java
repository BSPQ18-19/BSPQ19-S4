package servidor.es.deusto.spq;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.Pelicula;

public interface IServer extends Remote{

	public int idPeli(String nombre) throws RemoteException;
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, String peli)throws RemoteException;
	public boolean esAdmin(String correo)throws RemoteException;
	public boolean esUser(String user)throws RemoteException;
	public boolean passCorrecta(String user, String pass)throws RemoteException;
	List<Pelicula> buscarPeliculasFavoritas(String favoritas)throws RemoteException;
	List<Pelicula> buscarPeliculasVistas(String vistas)throws RemoteException;
	public boolean borrarPelicula(String titulo, String genero, String fEstreno, String trailer, String fichatecnica, String sinopsis, int puntuacion) throws RemoteException;
	public boolean borrarUsuario(String correo, String nombre, String contrasenna, String paypal, int privilegio, double gasto) throws RemoteException;
	//public void almacenarUsuario (Cuenta c)throws RemoteException;
	//public void almacenarPelicula (Pelicula p)throws RemoteException;
	public boolean correo(String nombre, String correo)throws RemoteException;
	public String contrasenya(String nombre)throws RemoteException;
	public boolean almacenarPelicula(String titulo, String genero, String fEstreno, String trailer, String fichatecnica, String sinopsis, int puntuacion)throws RemoteException;
	public boolean almacenarUsuario(String correo, String nombre, String contrasenna, String paypal, int privilegio, double gasto)throws RemoteException;
	


}