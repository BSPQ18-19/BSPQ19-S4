package servidor.es.deusto.spq;

import java.rmi.Remote;
/**
 * \brief 
 */
import java.rmi.RemoteException;
import java.util.List;

import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.Pelicula;
/**
 * \brief Inicializar interfaz
 * @author Koldo, Lucía
 */
public interface IServer extends Remote{

//	public int idPeli(String nombre) throws RemoteException;
	/**
	 * Añade una pelicula a la tabla peliculas_cuenta
	 * @param fAlq Fecha en la que se alquila la pelicula
	 * @param tAlq Tiempo durante el que se alquila la pelicula
	 * @param nombre Nomrbre del la persona que alquila
	 * @param titulo Titulo de la pelicula
	 * @return 
	 * @throws RemoteException
	 */
	public boolean alquilarPelicula(String fAlq, int tAlq, String nombre, String titulo)throws RemoteException;
	/**
	 * Comprueba si el usuario es admin
	 * @param admin Nombre de la cuenta a comprobar
	 * @return
	 * @throws RemoteException
	 */
	public boolean esAdmin(String admin)throws RemoteException;
	/**
	 * Comprueba si el el la cuenta es usuario
	 * @param user Nombre de la cuenta a comprobar
	 * @return
	 * @throws RemoteException
	 */
	public boolean esUser(String user)throws RemoteException;
	/**
	 * Comrpueba la contraseña
	 * @param user Nombre del usuario a verificar
	 * @param pass Contraseña del usuario a verificar
	 * @return
	 * @throws RemoteException
	 */
	public boolean passCorrecta(String user, String pass)throws RemoteException;
//	List<Pelicula> buscarPeliculasFavoritas(String favoritas)throws RemoteException;
//	List<Pelicula> buscarPeliculasVistas(String vistas)throws RemoteException;
//	public void borrarPelicula(String titulo)throws RemoteException;
	/**
	 * Devuelve la lista de las peliculas almacenadas en la bd
	 * @return
	 * @throws RemoteException
	 */
	public String[] mostrarPeliculas()throws RemoteException;
	/**
	 * Devuelve la lista de los usuarios almacenados en la bd
	 * @return
	 * @throws RemoteException
	 */
	public String[] mostrarUsuarios()throws RemoteException;
//	public void borrarUsuario(String correo)throws RemoteException;
//	public void almacenarUsuario (Cuenta c)throws RemoteException;
//	public void almacenarPelicula (Pelicula p)throws RemoteException;
	/**
	 * Compruba si el correo y el nombre pertenecen a la misma cuenta
	 * @param nombre Nombre de la cuenta
	 * @param correo Correo de la cuenta
	 * @return
	 * @throws RemoteException
	 */
	public boolean correo(String nombre, String correo)throws RemoteException;
	/**
	 * Devuelve la contraseña de un usuario
	 * @param nombre Nombre para verificar la contraseña
	 * @return
	 * @throws RemoteException
	 */
	public String contrasenya(String nombre)throws RemoteException;
	/**
	 * Ordena las peliculas almacenadas en la bd por titulo
	 * @return
	 * @throws RemoteException
	 */
	public String[] buscarPeliculasTitulo()throws RemoteException;
	/**
	 * Ordena las peliculas almacenadas en la bd por genero
	 * @return
	 * @throws RemoteException
	 */
	public String[] buscarPeliculasGenero()throws RemoteException;
	/**
	 * Ordena las peliculas almacenadas en la bd por fecha
	 * @return
	 * @throws RemoteException
	 */
	public String[] buscarPeliculasFecha()throws RemoteException;
	/**
	 * Devuelve la pelicula pasandole el titulo de la misma
	 * @param titulo Titulo de la pelicual a buscar
	 * @return
	 * @throws RemoteException
	 */
	public Pelicula conseguirPelicula(String titulo)throws RemoteException;
	/**
	 * Devuelve la cuenta pasandole el nombre de la misma
	 * @param nombre Nombre de la pelicula a buscar
	 * @return
	 * @throws RemoteException
	 */
	public Cuenta conseguirUsuario(String nombre)throws RemoteException;
	


}