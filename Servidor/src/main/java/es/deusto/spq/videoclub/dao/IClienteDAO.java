package es.deusto.spq.videoclub.dao;

import java.util.ArrayList;

import es.deusto.spq.videoclub.data.Pelicula;
import es.deusto.spq.videoclub.data.Alquiler;
import es.deusto.spq.videoclub.data.AlquilerPelicula;
import es.deusto.spq.videoclub.data.Cliente;

/**
 * Clase de creación de interfaz DAO de Cliente
 * @author Jon
 */

public interface IClienteDAO {
	public Cliente getCliente (String nombre);
	public ArrayList<String> getClientes();
	public void almacenarCliente (Cliente c);
	public Cliente verCliente(String nombre);

}
