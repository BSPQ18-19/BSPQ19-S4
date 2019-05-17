package servidor.es.deusto.spq.jdo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import servidor.es.deusto.spq.IServer;

public class JDOTest {
	private IServer db;
	private Cuenta c;
	private Cuenta c2;
	private Pelicula p;
	
	@BeforeClass
	public static void init() throws RemoteException {
		IServer db = new JDO();
		Pelicula peli = new Pelicula("genero", "titulo", "fEstreno", "trailer", "fichaTecnica", "sinopsis", 5);
		Cuenta user = new Cuenta("correo", "nombre", "contrasenna", "paypal", 0, 5);
		Cuenta user2 = new Cuenta("correo2", "nombre2", "contrasenna2", "paypal2", 1, 5);
		anadirPeli(peli);
		anadirUser(user);
		anadirUser(user2);
	}
	
	@Before
	public void setUp() throws RemoteException{
		db = new JDO();
		p = db.conseguirPelicula("titulo");
		c = db.conseguirUsuario("nombre");
		c2 = db.conseguirUsuario("nombre2");
	}
	
	@Test
	public void testesAdmin() throws RemoteException {
		db.esAdmin(c.getNombre());
		assertFalse(db.esAdmin(c.getNombre()));
	}
	
	@Test
	public void testesUser() throws RemoteException {
		db.esUser(c.getNombre());
		assertTrue(db.esUser(c.getNombre()));
	}
	
	@Test
	public void testesAdmin2() throws RemoteException {
		db.esAdmin(c2.getNombre());
		assertTrue(db.esAdmin(c2.getNombre()));
	}
	
	@Test
	public void testesUser2() throws RemoteException {
		db.esUser(c2.getNombre());
		assertFalse(db.esUser(c2.getNombre()));
	}
	
	
	
	
	
	
	
	
	
	
	
	static PersistenceManagerFactory persistentManagerFactory = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");
	static PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
	static Transaction transaction = persistentManager.currentTransaction();
	public static void anadirPeli(Pelicula p) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			persistentManager.makePersistent(p);
			transaction.commit();
			persistentManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
	public static void anadirUser(Cuenta c) {
		try {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();
			persistentManager.makePersistent(c);
			transaction.commit();
			persistentManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			persistentManager.close();
		}
	}
}
