package juegoYZonas;

/**
 * Esta clase abstracta tiene un atributo id utilizado para identificar a las
 * zonas en la lista de Zonas.
 */
public abstract class Zona {
	/**
	 * Número único para identificar internamente a cada zona.
	 */
	private int id;

	public Zona(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna mensaje que sale al ingresar a cada zona. Ej: "Bienvenido a la
	 * ciudad".
	 * 
	 * @return Retorna un String con el mensaje.
	 */
	public abstract String getMensajeInicial();
}