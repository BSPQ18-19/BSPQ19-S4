package servidor.es.deusto.spq.jdo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import javax.jdo.Query;

import servidor.es.deusto.spq.IServer;
import cliente.es.deusto.spq.gui.AnadirUsuario;
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
	public boolean esAdmin(String correo) {
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		try {
			transaction.begin();
			@SuppressWarnings("unchecked")
			Query<String> query = persistentManager
					.newQuery("SELECT CORREO FROM" + Cuenta.class.getName() + " WHERE PRIVILEGIO = 1;");
			for (String correos : query.executeList()) {
				if (correos.equals(correo)) {
					return true;
				} else
					return false;
			}
			transaction.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
		return false;
	}

	@Override
	public boolean esUser(String user) {
		return false;
	}

	@Override
	public boolean passCorrecta(String user, String pass) {
		return false;
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
		
		
		
		/*
		Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bspq19-s4", "spq", "spq");
		
		String nombre = textFieldUsuario.getText();
		String contrasenna = passwordFieldContrasea1.getText();
		String correo = textFieldCorreo1.getText();
		String paypal = textFieldPaypal1.getText();
		int privilegio = Integer.parseInt(textFieldAdminSiONo.getText());
		double gasto = 0.0;
		
		String query = "INSERT INTO cuenta (CORREO, CONTRASENNA, GASTO, NOMBRE, PAYPAL, PRIVILEGIO) values ('"+correo+"','"+contrasenna+"','"+gasto+"','"+nombre+"','"+paypal+"','"+privilegio+"')";
		
		Statement stmt = conexion.createStatement();
		stmt.executeUpdate(query);
		*/
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
	
	
	/*
	 		Class.forName("com.mysql.jdbc.Driver");
					
			java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bspq19-s4", "spq", "spq");
							
			int pelicula_id = Integer.parseInt(textFieldPelicula_id.getText());
							
			String titulo = textFieldPelicula.getText();
			String genero = textFieldGenero.getText();
			String festreno = textFieldfEstreno.getText();
			String trailer = textFieldtrailer.getText();
			String fichatecnica = textFieldFichaTecnica.getText();
			String sinopsis = textFieldSinopsis.getText();
			int puntuacion = 8;
			
			String query = "INSERT INTO pelicula (FESTRENO, FICHATECNICA, GENERO, SINOPSIS, TITULO, TRAILER) values ('"+festreno+"', '"+fichatecnica+"','"+genero+"','"+sinopsis+"', '"+titulo+"', '"+trailer+"')";
							
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(query);
	 
	 
	 */

	public boolean correo(String nombre, String correo)  {
		// TODO Auto-generated method stub
		return false;
	}

	public String contrasenya(String nombre)  {
		// TODO Auto-generated method stub
		return null;
	}

}