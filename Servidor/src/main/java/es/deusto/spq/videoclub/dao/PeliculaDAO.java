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

/**
 * Clase de creación de DAO de Peliculas
 * @author Jon
 */

public class PeliculaDAO implements IPeliculaDAO{
	
	private PersistenceManagerFactory pmf;
	private static final Logger logger = Logger.getLogger(PeliculaDAO.class);

	/**
	 * Contructor de la clase
	 */
	public PeliculaDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

}
	
	
	/**
	 * Metodo que almacena un libro.
	 * @Libro anyade libro.
	 * @throws Exception Lanza una excepccion si ocurre un error.
	 */
	@Override
	public void almacenarPelicula(Pelicula p) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Almacenando libro: " + p);
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error almacenando libro:" + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	@Override
	public Pelicula verPelicula(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void anyadirPuntuacion(String titulo, int puntuacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anyadirOpinion(String opiniones) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Pelicula getPelicula(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPeliculas() {
		// TODO Auto-generated method stub
		return null;
		
	}
	
}
