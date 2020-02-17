package personajes;

/**
 * Esta clase abstracta y gen�rica es la clase padre de todas las clases que
 * representan a todos los personajes del juego, ya sea al personaje jugable, a
 * los enemigos, o a los aliados. Tiene todos los atributos y m�todos generales,
 * como el nombre, la vida o el m�todo atacar que implementaran las clases
 * hijas.
 */
public abstract class Personaje<T> {

	private String nombre;
	private int vidaMax;
	private int vidaActual;

	public Personaje(String nombre) {
		this.nombre = nombre;
	}

	public Personaje() {
		setNombre("");
		setVidaMax(100);
		setVidaActual(100);
	}

	public Personaje(String nombre, int vidaMax, int vidaActual) {
		setNombre(nombre);
		setVidaMax(vidaMax);
		setVidaActual(vidaActual);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	/**
	 * Este m�todo recibe un entero, que ser� el da�o causado por un enemigo. Este
	 * valor se restar� a la vida actual. Si es menor que 0 se asigna la vida en 0.
	 */
	public void recibirDa�o(int da�o) {
		setVidaActual(getVidaActual() - da�o);
		if (getVidaActual() < 0)
			setVidaActual(0);
	}

	public abstract int atacar(T enemigo);
}