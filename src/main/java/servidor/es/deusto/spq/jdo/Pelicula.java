package servidor.es.deusto.spq.jdo;

import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Pelicula {
	String titulo = null;
	String genero = null;
	String fEstreno = null;
	String trailer = null;
	String fichaTecnica = null;
	String sinopsis = null;
	int puntuacion = 0;
	

    @Persistent(table="PELICULAS_CUENTA")
    @Join(column="PELICULA_ID")
    @Element(column="CORREO")
	Set<Cuenta>usuarios;


	public Pelicula(String genero, String titulo, String fEstreno, String trailer, String fichaTecnica, String sinopsis,
			int puntuacion) {
		this.genero = genero;
		this.titulo = titulo;
		this.fEstreno = fEstreno;
		this.trailer = trailer;
		this.fichaTecnica = fichaTecnica;
		this.sinopsis = sinopsis;
		this.puntuacion = puntuacion;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getfEstreno() {
		return fEstreno;
	}


	public void setfEstreno(String fEstreno) {
		this.fEstreno = fEstreno;
	}


	public String getTrailer() {
		return trailer;
	}


	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}


	public String getFichaTecnica() {
		return fichaTecnica;
	}


	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}
	
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


	public Set<Cuenta> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Set<Cuenta> usuarios) {
		this.usuarios = usuarios;
	}


	@Override
	public String toString() {
		return "Pelicula [genero=" + genero + ", titulo=" + titulo + ", fEstreno=" + fEstreno + ", trailer=" + trailer
				+ ", fichaTecnica=" + fichaTecnica + ", sinopsis=" + sinopsis + ", puntuacion=" + puntuacion+ "]";
	}
    
}
