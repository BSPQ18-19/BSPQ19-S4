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
	 * Metodo que almacena una película.
	 * @Pelicula anyade pelicula.
	 * @throws Exception Lanza una excepccion si ocurre un error.
	 */
	@Override
	public void almacenarPelicula(Pelicula p) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			logger.info("   * Almacenando película: " + p);
			pm.makePersistent(p);
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error almacenando película:" + ex.getMessage());
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
	
	/**
	 * Metodo que devuelve una pelicula de la BD dado su titulo.
	 * @titulo Nombre de la pelicula.
	 * @return Devuleve el una pelicula de la BD
	 */
	@Override
	public Pelicula getPelicula(String titulo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Pelicula l = null;

		try {
			logger.info("   * Buscando película: " + titulo);


			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Pelicula.class.getName() + " WHERE nombre == '" + titulo +"'");
			query.setUnique(true);
			l = (Pelicula) query.execute();
			tx.commit();

		} catch (Exception ex) {
			logger.error("   $ Error buscando película:" + ex.getMessage());

		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return l;
	}

	/**
	 * Metodo que devuelve todas las películas
	 * @return Devuelve todas las películas de la BD
	 */
	@Override
	public ArrayList<String> getPeliculas() {
		PersistenceManager pm = pmf.getPersistenceManager();


		Transaction tx = pm.currentTransaction();
		
		ArrayList<String> catalogo = new ArrayList<String>();
		
		try {

			logger.info("  * Mostrando catalogo de películas...");

			String pelicula=null;
			tx.begin();
			Query<Pelicula> query = pm.newQuery(Pelicula.class);
			@SuppressWarnings("unchecked")
			List<Pelicula> peliculas = (List<Pelicula>) query.execute();
			
			for (Pelicula p : peliculas) {
				pelicula = p.getId_pelicula() + "#" + p.getTitulo() + "#" + p.getGenero() + "#" + p.getFechaestreno() + "/" ;
				catalogo.add(pelicula);
			}
			tx.commit();
  			
		} catch (Exception ex) {
			
			logger.error("   $ Error recuperando todas las películas: " + ex.getMessage());
		
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
		
		return catalogo;
		
	}
	
}
