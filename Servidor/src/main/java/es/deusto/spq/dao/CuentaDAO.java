package es.deusto.spq.dao;

import java.util.ArrayList;
import es.deusto.spq.jdo.Cuenta;
import es.deusto.spq.jdo.JDO;


public class CuentaDAO implements ICuentaDAO{

	/**
	 * Metodo que almacena una cuenta en la BD.
	 * @Cuenta anyade cuenta.
	 * @throws Exception Lanza una excepccion si ocurre un error.
	 */
	
	@Override
	public void almacenarCuenta(Cuenta c) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Almacenando informacion del cliente: " + c);
			pm.makePersistent(c);
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error almacenando informacion del cliente:" + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	
		
	}

}
