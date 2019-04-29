
package servidor.es.deusto.spq;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import cliente.es.deusto.spq.gui.Peliculas;
import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.Pelicula;
import servidor.es.deusto.spq.jdo.Peliculas_Cuenta;

/**
 * Hello world!
 *
 */
public class Server extends UnicastRemoteObject implements IServer {

	/**
	* 
	*/
	private static final long serialVersionUID = -7646537450779069731L;
	PersistenceManagerFactory persistentManagerFactory = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
	Transaction transaction = persistentManager.currentTransaction();

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IServer servidor = new Server();
			Naming.rebind(name, servidor);
			System.out.println("- Server active and waiting...");
			boolean a = false;
			while (a == false) {
			}
		} catch (Exception e) {
			System.err.println("$ Server exception: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public int idPeli(String nombre) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		int id = 0;
		try {
			transaction.begin();
			Query query = persistentManager.newQuery(
					"SELECT PELICULA_ID FROM" + Pelicula.class.getName() + "WHERE TITULO = '" + nombre + "';");
			id = (int) query.execute();
			transaction.commit();
			return id;
		} catch (Exception ex) {
			return 0;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	@Override
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, String peli) {
		int id;
		id = idPeli(peli);
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery(
					"INSERT INTO" + Peliculas_Cuenta.class.getName() + "(falq, taql, correo, PELICULA_ID) VALUES('"
							+ fAlq + "'," + tAlq + ",'" + correo + "'," + id + ");");
			transaction.commit();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	@Override
	public List<Pelicula> buscarPeliculasFavoritas(String favoritas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPeliculasVistas(String vistas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarPelicula(String titulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarUsuario(String nombre) {
		// TODO Auto-generated method stub

	}
}
