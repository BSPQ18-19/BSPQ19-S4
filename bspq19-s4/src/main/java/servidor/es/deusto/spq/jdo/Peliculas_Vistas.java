package servidor.es.deusto.spq.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

public class Peliculas_Vistas {

	private Cuenta c;
	private Pelicula p;
	
	public Peliculas_Vistas(Cuenta c, Pelicula p) {
		super();
		this.c = c;
		this.p = p;	
	}

	public Cuenta getC() {
		return c;
	}

	public void setC(Cuenta c) {
		this.c = c;
	}

	public Pelicula getP() {
		return p;
	}

	public void setP(Pelicula p) {
		this.p = p;
	}
	
}
