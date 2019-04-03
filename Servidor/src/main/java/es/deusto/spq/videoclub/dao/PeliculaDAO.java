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

	/**
	 * Permite ver la información de una película
	 * @param titulo Titulo del libro
	 */
	@Override
	public Pelicula verPelicula(String titulo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Pelicula p = null;


		try {

			logger.info("\"   * Mostrando datos de la película: " + titulo);


			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Pelicula.class.getName() + " WHERE titulo == '" + titulo +"'");
			query.setUnique(true);
			p = (Pelicula) query.execute();


			System.out.println("\nID: " + p.getId_pelicula());
			System.out.println("\nTítulo: " + p.getTitulo());
			System.out.println("\nGénero: " + p.getGenero());
			System.out.println("\nFecha de Estreno: " + p.getFechaestreno());

			tx.commit();

		} catch (Exception ex) {
	
			logger.error("   $ Error mostrando datos de la película seleccionada:" + ex.getMessage());

		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return p;

	}

	

	@Override
	public void anyadirPuntuacion(String id_pelicula, int puntuacion) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			logger.info("   * Añadiendo una nueva puntuación: " + puntuacion);
			tx.begin();
			Query<Pelicula> query = pm.newQuery(Pelicula.class);
			@SuppressWarnings("unchecked")
			List<Pelicula> peliculas = (List<Pelicula>) query.execute();
			for (Pelicula p : peliculas) {
				if (p.getId_pelicula().equals(id_pelicula)) {
					p.setPuntuacion(puntuacion);	
				}
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error retreiving an extent: " + ex.getMessage());

		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
	}

	@Override
	public void anyadirOpinion(String id_pelicula, String opiniones) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			logger.info("   * Añadiendo una nueva opinion: " + opiniones);
			tx.begin();
			Query<Pelicula> query = pm.newQuery(Pelicula.class);
			@SuppressWarnings("unchecked")
			List<Pelicula> peliculas = (List<Pelicula>) query.execute();
			for (Pelicula p : peliculas) {
				if (p.getId_pelicula().equals(id_pelicula)) {
					p.setOpiniones(opiniones);
				}
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error retreiving an extent: " + ex.getMessage());

		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
	}
	
	/**
	 * Metodo que devuelve una pelicula de la BD dado su titulo.
	 * @titulo Nombre de la pelicula.
	 * @return Devuelve una pelicula de la BD
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
			Query<?> query = pm.newQuery("SELECT FROM " + Pelicula.class.getName() + " WHERE titulo == '" + titulo +"'");
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
