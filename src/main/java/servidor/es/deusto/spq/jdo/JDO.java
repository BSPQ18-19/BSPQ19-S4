package servidor.es.deusto.spq.jdo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import javax.jdo.Query;

import servidor.es.deusto.spq.IServer;

public class JDO extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = -5970799150454206362L;

	private String serverName;
	private static PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(JDO.class);
	PersistenceManagerFactory persistentManagerFactory = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
	Transaction transaction = persistentManager.currentTransaction();

	public JDO(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
	}

	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	@Override
	public int idPeli(String nombre) throws RemoteException {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		int id = 0;
		try {
			transaction.begin();
			@SuppressWarnings("unchecked")
			Query<Integer> query = persistentManager.newQuery(
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
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, String peli) throws RemoteException {
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
	public List<Pelicula> buscarPeliculasFavoritas(String favoritas) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPeliculasVistas(String vistas) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean borrarPelicula(String titulo, String genero, String fEstreno, String trailer, String fichatecnica, String sinopsis, int puntuacion) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery(
					"DELETE FROM" + Pelicula.class.getName() + "(FESTRENO, FICHATECNICA, GENERO, PUNTUACION, SINOPSIS, TITULO, TRAILER) VALUES('"
							+ fEstreno + "'," + fichatecnica + ",'" + genero + "'," + puntuacion + ",'" + sinopsis + "', " + titulo + ",'" + trailer + ");");
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

	public boolean borrarUsuario(String correo, String nombre, String contrasenna, String paypal, int privilegio, double gasto) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery(
					"DELETE FROM" + Cuenta.class.getName() + "(CORREO, CONTRASENNA, GASTO, NOMBRE, PAYPAL, PRIVILEGIO) VALUES('"
							+ correo + "'," + contrasenna + ",'" + gasto + "'," + nombre +",'" +paypal+"', "+privilegio+ ");");
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
	public boolean esAdmin(String correo) throws RemoteException {
		boolean resultado = false;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta nombres : (List<Cuenta>) query.executeList()) {
				String nombre = nombres.getNombre();
				System.out.println(nombre);
				System.out.println(correo);
				System.out.println(nombres.getPrivilegio());
				if (nombres.getPrivilegio() == 1 && nombre.equals(correo)) {
					transaction.commit();
					resultado =  true;
				} else {
					transaction.commit();
					resultado = false;
				}
			}
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return false;
			}
			persistentManager.close();
			return resultado;
		}
	}

	@Override
	public boolean esUser(String user) throws RemoteException {
		return false;
	}

	@Override
	public boolean passCorrecta(String user, String pass) throws RemoteException {
		return true;
	}

	public boolean almacenarUsuario(Cuenta c) {

	
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery(
					"INSERT INTO" + Cuenta.class.getName() + "(CORREO, CONTRASENNA, GASTO, NOMBRE, PAYPAL, PRIVILEGIO) VALUES('"
															+ c.correo + "'," + c.contrasenna + ",'" + c.gasto + "'," + c.nombre +",'" +c.paypal+"', "+c.privilegio+ ");");
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
		
			
		/*
		try {
			tx.begin();
			logger.info("   * Almacenando informacion de de la cuenta: " + c);
			pm.makePersistent(c);
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error almacenando informacion de la cuenta:" + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		*/
	}

	@Override

	public boolean almacenarPelicula(Pelicula p) {
		
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery(
					"INSERT INTO" + Pelicula.class.getName() + "(FESTRENO, FICHATECNICA, GENERO, PUNTUACION, SINOPSIS, TITULO, TRAILER) VALUES('"
							+p.fEstreno+ "'," + p.fichaTecnica+ ",'" + p.genero + "'," + p.puntuacion +",'" +p.sinopsis+"', "+p.titulo+ ",'"+p.trailer+ ");");
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
		
		/*
		try {
			tx.begin();
			logger.info("   * Almacenando pelicula en la BD: " + p);
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error almacenando pelicula en la BD:" + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();

		}
		*/
	}

	public boolean correo(String nombre, String correo)  {
		// TODO Auto-generated method stub
		return false;
	}

	public String contrasenya(String nombre)  {
		// TODO Auto-generated method stub
		return null;
	}

}