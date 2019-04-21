package servidor.es.deusto.spq.jdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.jdo.Query;

public class JDO {
	public static void main(String[] args) {
		PersistenceManagerFactory persistenceManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
		//Select
		PersistenceManager persistenceManager = persistenceManagerFactory.getPersistenceManager();
		Transaction transaction = persistenceManager.currentTransaction();
		
		transaction.begin();
		@SuppressWarnings("unchecked")
		Query<Pelicula> peliculaQuery=persistenceManager.newQuery("SELECT FROM "+ Pelicula.class.getName());
		for (Pelicula p:peliculaQuery.executeList()) {
			System.out.println(p.toString());
		}
		transaction.commit();
	}
}
