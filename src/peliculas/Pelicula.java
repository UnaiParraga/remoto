package peliculas;
/**
 * Es una clase que representa una pelicula dentro del programa de peliculas
 * de una productora de cine.
 * @author Unai
 * @version 1.0
 *
 */
public class Pelicula {
	private int codigoPelicula;
	private String titulo;
	private int añoEstreno;
	private String protagonista;
	private int costeProduccion;
	
	public Pelicula(int codigoPelicula, String titulo, int añoEstreno,String protagonista, int costeProduccion) {
		super();
		this.codigoPelicula = codigoPelicula;
		this.titulo = titulo;
		this.añoEstreno = añoEstreno;
		this.protagonista = protagonista;
		this.costeProduccion = costeProduccion;
	}
	public Pelicula() {
		
	}
	public int getCodigoPelicula() {
		return codigoPelicula;
	}
	public void setCodigoPelicula(int codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAñoEstreno() {
		return añoEstreno;
	}
	public void setAñoEstreno(int añoEstreno) {
		this.añoEstreno = añoEstreno;
	}
	public String getProtagonista() {
		return protagonista;
	}
	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}
	public int getCosteProduccion() {
		return costeProduccion;
	}
	public void setCosteProduccion(int costeProduccion) {
		this.costeProduccion = costeProduccion;
	}
	@Override
	public String toString() {
		return this.getCodigoPelicula()+"||"+this.getTitulo()+"||"+this.getAñoEstreno()+"||"+this.getProtagonista()+"||"+this.getCosteProduccion();
	}
	
}
