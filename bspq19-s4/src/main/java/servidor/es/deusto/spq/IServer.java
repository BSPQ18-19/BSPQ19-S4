package servidor.es.deusto.spq;

import java.rmi.Remote;
import java.util.List;

import servidor.es.deusto.spq.jdo.Cuenta;
import servidor.es.deusto.spq.jdo.Pelicula;

public interface IServer extends Remote{

	List<Pelicula> buscarPeliculasFavoritas(String favoritas);
	List<Pelicula> buscarPeliculasVistas(String vistas);
	void borrarPelicula(Pelicula p, String titulo);
	void borrarUsuario(Cuenta u, String nombre);
}
