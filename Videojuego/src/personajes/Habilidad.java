package personajes;

/**
 * Esta clase es la clase padre de las habilidades de ataque y de defensa.
 */
public abstract class Habilidad {
	private String nombre;

	public Habilidad(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}