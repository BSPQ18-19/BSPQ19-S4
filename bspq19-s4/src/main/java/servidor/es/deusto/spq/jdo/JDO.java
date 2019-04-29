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
import servidor.es.deusto.spq.Server;

public class JDO extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = -5970799150454206362L;

	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(JDO.class);
	
	private String serverName;
	PersistenceManagerFactory persistentManagerFactory = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
	Transaction transaction = persistentManager.currentTransaction();

	public JDO(String serverName) throws RemoteException {
		super();
		this.serverName = serverName;
	}
	
	@Override
	public int idPeli(String nombre) {
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
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, String peli){
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
	public List<Pelicula> buscarPeliculasVistas(String vistas){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarPelicula(String titulo){
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarUsuario(String nombre){
		// TODO Auto-generated method stub

	} 

	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	public void almacenarUsuario(Cuenta c) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
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
	}

	@Override

		public void almacenarPelicula(Pelicula p) {
			
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();

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
	}
	
	
}
