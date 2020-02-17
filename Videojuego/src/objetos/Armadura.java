package objetos;

import java.io.Serializable;

/**
 * Esta clase sirve de plantilla parar generar todas las armaduras del juego.
 * Tiene el atributo entero defensa,.
 */
public class Armadura extends Objeto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int defensa;

	public Armadura(String nombre, int defensa, int valor) {
		super(nombre, valor);
		this.defensa = defensa;
	}

	public Armadura(String nombre, int defensa) {
		super(nombre);
		this.defensa = defensa;
	}

	public Armadura(int defensa) {
		super();
		this.defensa = defensa;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	@Override
	public String toString() {
		return super.toString() + "Defensa: " + defensa + "|";
	}
}