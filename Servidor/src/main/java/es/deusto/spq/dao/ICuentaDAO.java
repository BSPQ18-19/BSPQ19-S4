package es.deusto.spq.dao;

import java.util.ArrayList;
import es.deusto.spq.jdo.Cuenta;


public interface ICuentaDAO {
	//He borrado todos los métodos extra que no sean el de almacenar usuarios
	public void almacenarCuenta (Cuenta c);

}
