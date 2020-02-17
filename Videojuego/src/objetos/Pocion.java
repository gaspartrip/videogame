package objetos;

import java.io.Serializable;

/**
 * Esta clase sirve de plantilla para generar todas las pociones del juego.
 * Tiene el atributo constante CURA, con la cantidad de vida que sanar� la
 * poci�n.
 */
public class Pocion extends Objeto implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int CURA = 30;

	public Pocion(String nombre, int valor) {
		super(nombre, valor);
	}

	public Pocion() {
		super("Poci�n de curaci�n", 50);
	}

	public int getCura() {
		return CURA;
	}

	@Override
	public String toString() {
		return super.toString() + "Cura: " + CURA + "|";
	}
}