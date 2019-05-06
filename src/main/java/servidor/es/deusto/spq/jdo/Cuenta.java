package servidor.es.deusto.spq.jdo;

import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Cuenta {
	@PrimaryKey
	String correo = null;
	String nombre = null;
	String contrasenna = null;
	String paypal = null;
	int privilegio = 0;
	double gasto = 0.0;
	

    @Persistent(mappedBy="usuarios")
	Set<Pelicula>peliculas;

	public Cuenta(String correo, String nombre, String contrasenna, String paypal, int privilegio, double gasto) {
		this.correo = correo;
		this.nombre = nombre;
		this.contrasenna = contrasenna;
		this.paypal = paypal;
		this.privilegio = privilegio;
		this.gasto = gasto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getPaypal() {
		return paypal;
	}

	public void setPaypal(String paypal) {
		this.paypal = paypal;
	}

	public int getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(int privilegio) {
		this.privilegio = privilegio;
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", nombre=" + nombre + ", contrasenna=" + contrasenna + ", paypal="
				+ paypal + ", privilegio=" + privilegio + ", gasto=" + gasto +"]";
	}
	
}
