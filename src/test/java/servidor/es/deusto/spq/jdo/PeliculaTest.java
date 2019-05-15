package servidor.es.deusto.spq.jdo;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import servidor.es.deusto.spq.jdo.Pelicula;


	public class PeliculaTest {
		
		private Pelicula pelicula;
		
		@Before
		public void setUp() {
			pelicula = new Pelicula("title","genre","releaseD","itrailer",
									"fichatec","sinop",9);
		}
		
		@Test
		public void testgetTitulo() {
			String o = pelicula.getTitulo();
			assertEquals("title", o);
		}
		
		@Test
		public void testgetGenero() {
			String o = pelicula.getGenero();
			assertEquals("genre", o);
		}
		
		@Test
		public void testgetFechaEstreno() {
			String o = pelicula.getfEstreno();
			assertEquals("releaseD", o);
		}
		
		
		@Test
		public void testgetTrailer() {
			String o = pelicula.getTrailer();
			assertEquals("itrailer", o);
		}
		
		@Test
		public void testgetFichaTecnica() {
			String o = pelicula.getFichaTecnica();
			assertEquals("fichatec", o);
		}
		
		@Test
		public void testgetSinopsis() {
			String o = pelicula.getSinopsis();
			assertEquals("sinop", o);
		}
		
		@Test
	    public void testgetPuntuacion(){
	        int o = pelicula.getPuntuacion();
	        assertEquals(9, o);
	    }
		
		@Test
		 public void testsetTitulo() {
		     pelicula.setTitulo("title");
		     String o = pelicula.getTitulo();
		      assertEquals("title", o);
		}
		
		@Test
		 public void testsetGenero() {
		     pelicula.setGenero("genre");
		     String o = pelicula.getGenero();
		      assertEquals("genre", o);
		}
		
		@Test
		 public void testsetfEstreno() {
		     pelicula.setfEstreno("releaseD");
		     String o = pelicula.getfEstreno();
		     assertEquals("releaseD", o);
		}
		
		@Test
		 public void testsetTrailer() {
		     pelicula.setTrailer("itrailer");
		     String o = pelicula.getTrailer();
		     assertEquals("itrailer", o);
		}
		
		@Test
		 public void testsetFichaTecnica() {
		     pelicula.setFichaTecnica("fichatec");
		     String o = pelicula.getFichaTecnica();
		     assertEquals("fichatec", o);
		}
		
		@Test
		 public void testsetSinopsis() {
		     pelicula.setSinopsis("sinop");
		     String o = pelicula.getSinopsis();
		     assertEquals("sinop", o);
		}
		
		@Test
	    public void testsetPuntuacion() {
	        pelicula.setPuntuacion(9);
	        int o = pelicula.getPuntuacion();
	        assertEquals(9, o);
	    }
		
		@Test
	    public void testtoStringPeli(){
	        String o = pelicula.toString();
	        assertEquals("Pelicula [titulo=title, genero=genre, fEstreno=releaseD, trailer=itrailer, fichatecnica=fichatec, sinopsis=sinop, puntuacion=9]", o);
	    }
		
	}
	

