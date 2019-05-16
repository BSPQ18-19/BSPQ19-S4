package servidor.es.deusto.spq.jdo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

public class Alquiler {
	private static final Logger logger = Logger.getLogger(JDO.class);
	static PersistenceManagerFactory persistentManagerFactory = JDOHelper
			.getPersistenceManagerFactory("datanucleus.properties");
	static PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
	static Transaction transaction = persistentManager.currentTransaction();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = "a";
		String titulo = "a";
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date(System.currentTimeMillis());  
		String fAlq = formatter.format(date);
		int tAlq = 1;
		alquiler(fAlq, tAlq, nombre, titulo);
	}
	static boolean alquiler(String fAlq, int tAlq, String nombre, String titulo) {
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
		}
	}
}
