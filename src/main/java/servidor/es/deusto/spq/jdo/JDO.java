package servidor.es.deusto.spq.jdo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.jdo.Query;

import servidor.es.deusto.spq.IServer;

public class JDO extends UnicastRemoteObject implements IServer, Serializable {

	private static final long serialVersionUID = -5970799150454206362L;

	private static PersistenceManagerFactory pmf;
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(JDO.class);
	private static Logger logger2 = null;
	PersistenceManagerFactory persistentManagerFactory = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
	Transaction transaction = persistentManager.currentTransaction();

	public static Logger getLogger() {
		if (logger2 == null) {
			BasicConfigurator.configure();
			logger2 = Logger.getLogger(JDO.class);
		}
		return logger2;
	}

	public static void msglogger(String mensaje) {
		getLogger().info(mensaje);
	}

	public JDO() throws RemoteException {
		super();
	}

	@Override
	public boolean alquilarPelicula(String fAlq, int tAlq, String nombre, String titulo) throws RemoteException {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Peliculas_Cuenta peliCue = new Peliculas_Cuenta(fAlq, tAlq, nombre, titulo);
			persistentManager.makePersistent(peliCue);
			transaction.commit();
			persistentManager.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean esAdmin(String admin) throws RemoteException {
		boolean resultado = false;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta nombres : (List<Cuenta>) query.executeList()) {
				String nombre = nombres.getNombre();
				msglogger(nombre);
				msglogger(admin);
				msglogger(Integer.toString(nombres.getPrivilegio()));
				if (nombres.getPrivilegio() == 1 && nombre.equals(admin)) {
					transaction.commit();
					return resultado = true;
				}
			}
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return false;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean esUser(String user) throws RemoteException {
		boolean resultado = false;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta nombres : (List<Cuenta>) query.executeList()) {
				String nombre = nombres.getNombre();
				msglogger(nombre);
				msglogger(user);
				msglogger(Integer.toString(nombres.getPrivilegio()));
				if (nombres.getPrivilegio() == 0 && nombre.equals(user)) {
					transaction.commit();
					return resultado = true;
				}
			}
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return false;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean passCorrecta(String user, String pass) throws RemoteException {
		boolean resultado = false;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta nombres : (List<Cuenta>) query.executeList()) {
				String nombre = nombres.getNombre();
				String password = nombres.getContrasenna();
				msglogger(nombre);
				msglogger(user);
				msglogger(password);
				msglogger(pass);
				if (password.equals(pass) && nombre.equals(user)) {
					transaction.commit();
					return resultado = true;
				}
			}
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return false;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean correo(String nombre, String correo) {
		boolean resultado = false;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta nombres : (List<Cuenta>) query.executeList()) {
				String user = nombres.getNombre();
				String mail = nombres.getCorreo();
				msglogger(nombre);
				msglogger(user);
				msglogger(correo);
				msglogger(mail);
				if (correo.equals(mail) && nombre.equals(user)) {
					transaction.commit();
					return resultado = true;
				}
			}
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return false;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String contrasenya(String nombre) {
		String resultado = null;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta nombres : (List<Cuenta>) query.executeList()) {
				String name = nombres.getNombre();
				String pass = nombres.getContrasenna();
				msglogger(nombre);
				msglogger(name);
				msglogger(pass);
				if (nombre.equals(name)) {
					transaction.commit();
					return resultado = pass;
				}
			}
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public String[] mostrarPeliculas() throws RemoteException {
		String[] resultado = null;
		ArrayList<String> peliculas = new ArrayList<String>();
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Pelicula.class.getName());
			for (Pelicula pelis : (List<Pelicula>) query.executeList()) {
				String peli = pelis.getTitulo();
				peliculas.add(peli);
			}
			transaction.commit();
			return resultado = peliculas.toArray(new String[peliculas.size()]);
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
			persistentManager.close();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public String[] mostrarUsuarios() throws RemoteException {
		String[] resultado = null;
		ArrayList<String> usuarios = new ArrayList<String>();
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta users : (List<Cuenta>) query.executeList()) {
				String user = users.getNombre();
				usuarios.add(user);
			}
			transaction.commit();
			return resultado = usuarios.toArray(new String[usuarios.size()]);
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
			persistentManager.close();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String[] buscarPeliculasTitulo() throws RemoteException {
		String[] resultado = null;
		ArrayList<String> peliculas = new ArrayList<String>();
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager
					.newQuery("SELECT  FROM " + Pelicula.class.getName() + " ORDER BY titulo ASC");
			for (Pelicula pelis : (List<Pelicula>) query.executeList()) {
				String peli = pelis.getTitulo();
				msglogger(peli);
				peliculas.add(peli);
			}
			transaction.commit();
			resultado = peliculas.toArray(new String[peliculas.size()]);
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String[] buscarPeliculasGenero() throws RemoteException {
		String[] resultado = null;
		ArrayList<String> peliculas = new ArrayList<String>();
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager
					.newQuery("SELECT  FROM " + Pelicula.class.getName() + " ORDER BY genero ASC");
			for (Pelicula pelis : (List<Pelicula>) query.executeList()) {
				String peli = pelis.getTitulo();
				msglogger(peli);
				peliculas.add(peli);
			}
			transaction.commit();
			resultado = peliculas.toArray(new String[peliculas.size()]);
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String[] buscarPeliculasFecha() throws RemoteException {
		String[] resultado = null;
		ArrayList<String> peliculas = new ArrayList<String>();
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager
					.newQuery("SELECT  FROM " + Pelicula.class.getName() + " ORDER BY fEstreno ASC");
			for (Pelicula pelis : (List<Pelicula>) query.executeList()) {
				String peli = pelis.getTitulo();
				msglogger(peli);
				peliculas.add(peli);
			}
			transaction.commit();
			resultado = peliculas.toArray(new String[peliculas.size()]);
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
		}
		persistentManager.close();
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Pelicula conseguirPelicula(String titulo) throws RemoteException {
		Pelicula resultado = null;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Pelicula.class.getName());
			for (Pelicula film : (List<Pelicula>) query.executeList()) {
				String peli = film.getTitulo();
				if (titulo.equals(peli)) {
					transaction.commit();
					msglogger(film.toString());
					resultado = film;
					return resultado;
				}
			}
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
			persistentManager.close();
		}
		return resultado;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Cuenta conseguirUsuario(String nombre) throws RemoteException {
		Cuenta resultado = null;
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			Query query = persistentManager.newQuery("SELECT  FROM " + Cuenta.class.getName());
			for (Cuenta nombres : (List<Cuenta>) query.executeList()) {
				String name = nombres.getNombre();
				msglogger(nombre);
				msglogger("caca" + name);
				if (nombre.equals(name)) {
					transaction.commit();
					msglogger(nombres.toString());
					resultado = nombres;
					msglogger(resultado.toString());
					return resultado;
				}
			}
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
				return null;
			}
			persistentManager.close();
		}
		return resultado;
	}

	@Override
	public boolean almacenarPelicula(Pelicula p) {

		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery("INSERT INTO" + Pelicula.class.getName()
					+ "(FESTRENO, FICHATECNICA, GENERO, PUNTUACION, SINOPSIS, TITULO, TRAILER) VALUES('" + p.fEstreno
					+ "'," + p.fichaTecnica + ",'" + p.genero + "'," + p.puntuacion + ",'" + p.sinopsis + "', "
					+ p.titulo + ",'" + p.trailer + ");");
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
		 * try { tx.begin(); logger.info("   * Almacenando pelicula en la BD: " + p);
		 * pm.makePersistent(p); tx.commit(); } catch (Exception ex) {
		 * logger.error("   $ Error almacenando pelicula en la BD:" + ex.getMessage());
		 * } finally { if (tx != null && tx.isActive()) { tx.rollback(); }
		 * 
		 * pm.close();
		 * 
		 * }
		 */
	}

	public boolean almacenarUsuario(Cuenta c) {

		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery("INSERT INTO" + Cuenta.class.getName()
					+ "(CORREO, CONTRASENNA, GASTO, NOMBRE, PAYPAL, PRIVILEGIO) VALUES('" + c.correo + "',"
					+ c.contrasenna + ",'" + c.gasto + "'," + c.nombre + ",'" + c.paypal + "', " + c.privilegio + ");");
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
		 * try { tx.begin();
		 * logger.info("   * Almacenando informacion de de la cuenta: " + c);
		 * pm.makePersistent(c); tx.commit(); } catch (Exception ex) {
		 * logger.error("   $ Error almacenando informacion de la cuenta:" +
		 * ex.getMessage()); } finally { if (tx != null && tx.isActive()) {
		 * tx.rollback(); }
		 * 
		 * pm.close(); }
		 */
	}

	public boolean borrarPelicula(String titulo, String genero, String fEstreno, String trailer, String fichatecnica,
			String sinopsis, int puntuacion) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery("DELETE FROM" + Pelicula.class.getName()
					+ "(FESTRENO, FICHATECNICA, GENERO, PUNTUACION, SINOPSIS, TITULO, TRAILER) VALUES('" + fEstreno
					+ "'," + fichatecnica + ",'" + genero + "'," + puntuacion + ",'" + sinopsis + "', " + titulo + ",'"
					+ trailer + ");");
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

	public boolean borrarUsuario(String correo, String nombre, String contrasenna, String paypal, int privilegio,
			double gasto) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			Query query = persistentManager.newQuery("DELETE FROM" + Cuenta.class.getName()
					+ "(CORREO, CONTRASENNA, GASTO, NOMBRE, PAYPAL, PRIVILEGIO) VALUES('" + correo + "'," + contrasenna
					+ ",'" + gasto + "'," + nombre + ",'" + paypal + "', " + privilegio + ");");
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

}