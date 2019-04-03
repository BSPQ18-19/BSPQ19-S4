package es.deusto.spq.videoclub.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.apache.log4j.Logger;

import es.deusto.spq.videoclub.data.Pelicula;
import es.deusto.spq.videoclub.data.Alquiler;
import es.deusto.spq.videoclub.data.AlquilerPelicula;
import es.deusto.spq.videoclub.data.Cliente;

/**
 * Clase de creación de DAO de Peliculas
 * @author Jon
 */
public class ClienteDAO implements IClienteDAO{

	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(ClienteDAO.class);

	/**
	 * Contructor de la clase
	 */
	public ClienteDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}
	
	
	@Override
	public Cliente getCliente(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Metodo que almacena un cliente.
	 * @Cliente anyade cliente.
	 * @throws Exception Lanza una excepccion si ocurre un error.
	 */
	@Override
	public void almacenarCliente(Cliente c) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Almacenando información del cliente: " + c);
			pm.makePersistent(c);
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error almacenando información del cliente:" + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	/**
	 * Permite ver la información de un cliente
	 * @param nombre Nombre del cliente
	 */
	@Override
	public Cliente verCliente(String nombre) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Cliente c = null;


		try {

			logger.info("\"   * Mostrando datos del cliente: " + nombre);


			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getName() + " WHERE nombre == '" + nombre +"'");
			query.setUnique(true);
			c = (Cliente) query.execute();

			//falta mostrar la info de la lista de películas de cada cliente
			
			System.out.println("\nNombre: " + c.getNombre());
			System.out.println("\nCorreo: " + c.getCorreo());
			System.out.println("\nCuenta de PayPal: " + c.getCuentapaypal());
			System.out.println("\nImporte total gastado: " + c.getGastototal());

			tx.commit();

		} catch (Exception ex) {
	
			logger.error("   $ Error mostrando datos de la cuenta seleccionada:" + ex.getMessage());

		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return c;
	}
	
	

}
