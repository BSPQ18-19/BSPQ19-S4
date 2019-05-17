package servidor.es.deusto.spq.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import servidor.es.deusto.spq.jdo.Pelicula;

public class PeliculaTestLucía {
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
		pelicula.setGenero("Espacio");
		String actual = pelicula.getGenero();
		assertEquals("Espacio", actual);
	}
	
	@Test
	public void testgetTitulo() {
		String actual = pelicula.getTitulo();
		assertEquals("Avengers", actual);
	}
	
	@Test
	public void testsetTitulo() {
		pelicula.setTitulo("StarWars");
		String actual = pelicula.getTitulo();
		assertEquals("StarWars", actual);
	}
	
	@Test
	public void testgetfEstreno() {
		String actual = pelicula.getfEstreno();
		assertEquals("2018/01/01", actual);
	}
	
	@Test
	public void testsetfEstreno() {
		pelicula.setfEstreno("1970/01/01");
		String actual = pelicula.getfEstreno();
		assertEquals("1970/01/01", actual);
	}
	
	@Test
	public void testgetTrailer() {
		String actual = pelicula.getTrailer();
		assertEquals("youtube", actual);
	}
	
	@Test
	public void testsetTrailer() {
		pelicula.setTrailer("youtube2");
		String actual = pelicula.getTrailer();
		assertEquals("youtube2", actual);
	}
	
	@Test
	public void testgetFichaTecnica() {
		String actual = pelicula.getFichaTecnica();
		assertEquals("HermanosRusso", actual);
	}
	
	@Test
	public void testsetFichaTecnica() {
		pelicula.setFichaTecnica("George Lucas");
		String actual = pelicula.getFichaTecnica();
		assertEquals("George Lucas", actual);
	}
	
	@Test
	public void testgetSinopsis() {
		String actual = pelicula.getSinopsis();
		assertEquals("Los vengadores contra Loki", actual);
	}
	
	@Test
	public void testsetSinopsis() {
		pelicula.setSinopsis("La guerra de las galaxias");
		String actual = pelicula.getSinopsis();
		assertEquals("La guerra de las galaxias", actual);
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
