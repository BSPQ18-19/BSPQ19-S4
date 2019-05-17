package servidor.es.deusto.spq.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import servidor.es.deusto.spq.jdo.Pelicula;

public class PeliculaTest {
	private Pelicula pelicula;
	
	@Before
	public void setUp(){
		pelicula = new Pelicula("Superheroes", "Avengers", "2018/01/01", "youtube", "HermanosRusso", "Los vengadores contra Loki", 10);
	}
	
	@Test
	public void testgetGenero() {
		String actual = pelicula.getGenero();
		assertEquals("Superheroes", actual);
	}
	
	@Test
	public void testsetGenero() {
		pelicula.setGenero("Superheroes");
		String actual = pelicula.getGenero();
		assertEquals("Superheroes", actual);
	}
	
	@Test
	public void testgetTitulo() {
		String actual = pelicula.getTitulo();
		assertEquals("Avengers", actual);
	}
	
	@Test
	public void testsetTitulo() {
		pelicula.setTitulo("Avengers");
		String actual = pelicula.getTitulo();
		assertEquals("Avengers", actual);
	}
	
	@Test
	public void testgetfEstreno() {
		String actual = pelicula.getfEstreno();
		assertEquals("2018/01/01", actual);
	}
	
	@Test
	public void testsetfEstreno() {
		pelicula.setfEstreno("2018/01/01");
		String actual = pelicula.getfEstreno();
		assertEquals("2018/01/01", actual);
	}
	
	@Test
	public void testgetTrailer() {
		String actual = pelicula.getTrailer();
		assertEquals("youtube", actual);
	}
	
	@Test
	public void testsetTrailer() {
		pelicula.setTrailer("youtube");
		String actual = pelicula.getTrailer();
		assertEquals("youtube", actual);
	}
	
	@Test
	public void testgetFichaTecnica() {
		String actual = pelicula.getFichaTecnica();
		assertEquals("HermanosRusso", actual);
	}
	
	@Test
	public void testsetFichaTecnica() {
		pelicula.setFichaTecnica("HermanosRusso");
		String actual = pelicula.getFichaTecnica();
		assertEquals("HermanosRusso", actual);
	}
	
	@Test
	public void testgetSinopsis() {
		String actual = pelicula.getSinopsis();
		assertEquals("Los vengadores contra Loki", actual);
	}
	
	@Test
	public void testsetSinopsis() {
		pelicula.setSinopsis("Los vengadores contra Loki");
		String actual = pelicula.getSinopsis();
		assertEquals("Los vengadores contra Loki", actual);
	}
	
	@Test
	public void testgetPuntuacion() {
		int actual = pelicula.getPuntuacion();
		assertEquals(10, actual);
	}
	
	@Test
	public void testsetPuntuacion() {
		pelicula.setPuntuacion(10);
		int actual = pelicula.getPuntuacion();
		assertEquals(10, actual);
	}
	
	@Test
	public void testtoString() {
	String actual = pelicula.toString();
	assertEquals("Pelicula [genero=Superheroes, titulo=Avengers, fEstreno=2018/01/01, trailer=youtube, fichaTecnica=HermanosRusso, sinopsis=Los vengadores contra Loki, puntuacion=10]", actual);
	}
}
