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

import org.apache.log4j.Logger;

import javax.jdo.Query;

import servidor.es.deusto.spq.IServer;

public class JDO extends UnicastRemoteObject implements IServer, Serializable {

	private static final long serialVersionUID = -5970799150454206362L;

	private String serverName;
	private static PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(JDO.class);
	PersistenceManagerFactory persistentManagerFactory = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
	Transaction transaction = persistentManager.currentTransaction();

	public JDO() throws RemoteException {
		super();
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

	@Override
	public List<Pelicula> buscarPeliculasFavoritas(String favoritas) throws RemoteException {
		// TODO:metodo
		return null;
	}

	@Override
	public List<Pelicula> buscarPeliculasVistas(String vistas) throws RemoteException {
		// TODO:metodo
		return null;
	}

	public void borrarPelicula(String titulo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();

			@SuppressWarnings("unchecked")
			Query<Pelicula> qu = pm.newQuery("DELETE FROM" + Pelicula.class.getName()
					+ "(titulo, genero, fEstreno, trailer, fichaTecnica, sinopsis, puntuacion)");
			qu.setFilter(titulo);
			qu.deletePersistentAll();
			System.out.println("Eliminando de la base de datos");
			tx.commit();
		} catch (Exception ex) {
			System.err.println("   $ Error eliminando informacion de la película:" + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	public void borrarUsuario(String correo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();

			@SuppressWarnings("unchecked")
			Query<Cuenta> qu = pm.newQuery("DELETE FROM" + Cuenta.class.getName()
					+ "(correo, nombre, contrasenna, paypal, privilegio, gasto)");
			qu.setFilter(correo);
			qu.deletePersistentAll();
			System.out.println("Eliminando de la base de datos");
			tx.commit();
		} catch (Exception ex) {
			System.err.println("   $ Error eliminando informacion de la cuenta:" + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

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
				System.out.println(nombre);
				System.out.println(admin);
				System.out.println(nombres.getPrivilegio());
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
			persistentManager.close();
			return resultado;
		}
	}

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
				System.out.println(nombre);
				System.out.println(user);
				System.out.println(nombres.getPrivilegio());
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
			persistentManager.close();
			return resultado;
		}
	}

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
				System.out.println(nombre);
				System.out.println(user);
				System.out.println(password);
				System.out.println(pass);
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
			persistentManager.close();
			return resultado;
		}
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
				System.out.println(nombre);
				System.out.println(user);
				System.out.println(correo);
				System.out.println(mail);
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
			persistentManager.close();
			return resultado;
		}
	}

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
				System.out.println(nombre);
				System.out.println(name);
				System.out.println(pass);
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
			persistentManager.close();
			return resultado;
		}
	}

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
			return resultado;
		}
	}

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
			return resultado;
		}
	}

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
				System.out.println(peli);
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
			persistentManager.close();
			return resultado;
		}
	}

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
				System.out.println(peli);
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
			persistentManager.close();
			return resultado;
		}
	}

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
				System.out.println(peli);
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
			persistentManager.close();
			return resultado;
		}
	}

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
					System.out.println(film.toString());
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
				System.out.println(nombre);
				System.out.println("caca" + name);
				if (nombre.equals(name)) {
					transaction.commit();
					System.out.println(nombres.toString());
					resultado = nombres;
					System.out.println(resultado.toString());
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
}