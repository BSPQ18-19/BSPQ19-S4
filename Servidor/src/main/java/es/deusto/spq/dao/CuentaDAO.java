package es.deusto.spq.dao;

import java.util.ArrayList;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.apache.log4j.Logger;

import es.deusto.spq.jdo.Cuenta;
import es.deusto.spq.jdo.JDO;


public class CuentaDAO implements ICuentaDAO{

	
	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(PeliculaDAO.class);

	/**
	 * Contructor de la clase
	 */
	public CuentaDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}
	
	/**
	 * Metodo que almacena una cuenta en la BD.
	 * @Cuenta anyade cuenta.
	 * @throws Exception Lanza una excepccion si ocurre un error.
	 */

	@Override
	public void almacenarCuenta(Cuenta c) {
		//Hasta que no este el rmi no funcionará
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Almacenando informacion de la cuenta: " + c);
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

}
