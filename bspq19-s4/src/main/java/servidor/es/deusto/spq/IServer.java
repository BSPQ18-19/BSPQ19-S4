package servidor.es.deusto.spq;

import java.rmi.Remote;

public interface IServer extends Remote{
	public boolean alquilarPelicula(String fAlq, int tAlq, String correo, int id);
}
