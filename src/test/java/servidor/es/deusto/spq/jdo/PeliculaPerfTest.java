package servidor.es.deusto.spq.jdo;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class PeliculaPerfTest {
	private Pelicula pelicula;
	
	@Before
	public void setUp(){
		pelicula = new Pelicula("Superheroes", "Avengers", "2018/01/01", "youtube", "HermanosRusso", "Los vengadores contra Loki", 10);
	}
	
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(PeliculaPerfTest.class);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 10)
	@Required(max = 60, average = 10)
	public void testgetGenero() {
		assertEquals("Superheroes", pelicula.getGenero());
	}
	
	@PerfTest(invocations = 2000, threads = 5)
	@Required(max = 60, average = 10)
	@Test
	public void testsetGenero() {
		pelicula.setGenero("Espacio");
		String actual = pelicula.getGenero();
		assertEquals("Espacio", actual);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 10)
	@Required(max = 60, average = 10)
	public void testgetTitulo() {
		assertEquals("Avengers", pelicula.getTitulo());
	}
	
	@PerfTest(invocations = 2000, threads = 5)
	@Required(max = 60, average = 10)
	@Test
	public void testsetTitulo() {
		pelicula.setTitulo("StarWars");
		String actual = pelicula.getTitulo();
		assertEquals("StarWars", actual);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 10)
	@Required(max = 60, average = 10)
	public void testgetfEstreno() {
		assertEquals("2018/01/01", pelicula.getfEstreno());
	}
	
	@PerfTest(invocations = 2000, threads = 5)
	@Required(max = 60, average = 10)
	@Test
	public void testsetfEstreno() {
		pelicula.setfEstreno("1970/01/01");
		String actual = pelicula.getfEstreno();
		assertEquals("1970/01/01", actual);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 10)
	@Required(max = 60, average = 10)
	public void testgetTrailer() {
		assertEquals("youtube", pelicula.getTrailer());
	}
	
	@PerfTest(invocations = 2000, threads = 5)
	@Required(max = 60, average = 10)
	@Test
	public void testsetTrailer() {
		pelicula.setTrailer("youtube2");
		String actual = pelicula.getTrailer();
		assertEquals("youtube2", actual);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 10)
	@Required(max = 60, average = 10)
	public void testgetFichaTecnica() {
		assertEquals("HermanosRusso", pelicula.getFichaTecnica());
	}
	
	@PerfTest(invocations = 2000, threads = 5)
	@Required(max = 60, average = 10)
	@Test
	public void testsetFichaTecnica() {
		pelicula.setFichaTecnica("George Lucas");
		String actual = pelicula.getFichaTecnica();
		assertEquals("George Lucas", actual);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 10)
	@Required(max = 60, average = 10)
	public void testgetSinopsis() {
		assertEquals("Los vengadores contra Loki", pelicula.getSinopsis());
	}
	
	@PerfTest(invocations = 2000, threads = 5)
	@Required(max = 60, average = 10)
	@Test
	public void testsetSinopsis() {
		pelicula.setSinopsis("La guerra de las galaxias");
		String actual = pelicula.getSinopsis();
		assertEquals("La guerra de las galaxias", actual);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 10)
	@Required(max = 60, average = 10)
	public void testgetPuntuacion() {
		assertEquals(10, pelicula.getPuntuacion());
	}
	
	@PerfTest(invocations = 2000, threads = 5)
	@Required(max = 60, average = 10)
	@Test
	public void testsetPuntuacion() {
		pelicula.setPuntuacion(10);
		int actual = pelicula.getPuntuacion();
		assertEquals(10, actual);
	}
	
	@Test
	@PerfTest(invocations = 3000, threads = 20)
	@Required(max = 60, average = 10)
	public void testtoString() {
		String actual = pelicula.toString();
		assertEquals("Pelicula [genero=Superheroes, titulo=Avengers, fEstreno=2018/01/01, trailer=youtube, fichaTecnica=HermanosRusso, sinopsis=Los vengadores contra Loki, puntuacion=10]",actual);
	}
}
