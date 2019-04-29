package servidor.es.deusto.spq.jdo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;



public class Main {
	
	public static List<Cuenta> listaC (){
		
		Cuenta usu = new Cuenta("jon@jon.es", "Jon","1234", "1234", 1, 0);
		Cuenta usu1 = new Cuenta("lucia@lucia.es", "Lucia","1234", "1234", 0, 0);	
		Cuenta usu2 = new Cuenta("koldo@koldo.es", "Koldo","1234", "1234", 1, 0);
		Cuenta usu3 = new Cuenta("amaia@amaia.es", "Amaia","1234", "1234", 0, 0);

		List<Cuenta> u = new ArrayList<>();
	
		u.add(usu);
		u.add(usu1);
		u.add(usu2);
		u.add(usu3);
		
		return u;
	}
	
	public static void main(String[] args) {
		
		try {
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
	
			Transaction tx = pm.currentTransaction();
//INSERTA LOS USUARIOS DE UNO EN UNO EN LA BASE DE DATOS
			try {				
				Cuenta usu = new Cuenta("jon@jon.es", "Jon","1234", "1234", 1, 0);
				Cuenta usu1 = new Cuenta("lucia@lucia.es", "Lucia","1234", "1234", 0, 0);	
				Cuenta usu2 = new Cuenta("koldo@koldo.es", "Koldo","1234", "1234", 1, 0);
				Cuenta usu3 = new Cuenta("amaia@amaia.es", "Amaia","1234", "1234", 0, 0);
				tx.begin();
				pm.makePersistent(usu);
				pm.makePersistent(usu1);
				pm.makePersistent(usu2);
				pm.makePersistent(usu3);
				System.out.println("Inserting contents into the database ....");
				tx.commit();
			} catch (Exception ex) {
				System.out.println("# Error storing objects: " + ex.getMessage());				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				
				pm.close();
			}	
//ELIMINA UN UNICO USUARIO DE LA BASE DE DATOS			
			try {
				//Get the Persistence Manager
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();

				Query<Cuenta> qu = pm.newQuery(Cuenta.class);
				qu.setFilter("email == 'jon@jon.es'");
				qu.deletePersistentAll();
				System.out.println("Eliminando de la base de datos");
				//End the transaction
				tx.commit();
			} catch (Exception ex) {
				System.err.println(" $ Error al eliminar de la base de datos: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				
				if (pm != null && !pm.isClosed()) {
					pm.close();
				}
			}
			
			
//SELECCIONA UN UNICO USUARIO DE LA BASE DE DATOS				
			try {
				//Get the Persistence Manager
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();

				Query<Cuenta> qu = pm.newQuery(Cuenta.class);
				qu.setFilter("email == 'lucia@lucia.es'");
				System.out.println("El usuario seleccionado es:"+qu.execute().toString());
				//End the transaction
				tx.commit();
			} catch (Exception ex) {
				System.err.println(" $ Error al seleccionar de la base de datos: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				
				if (pm != null && !pm.isClosed()) {
					pm.close();
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			}
				
	}
}
