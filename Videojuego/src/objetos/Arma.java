package objetos;

import java.io.Serializable;

/**
 * Esta clase sirve de plantilla para generar todas las armas del juego. Tiene
 * los atributos de ataque máximo y ataque mínimo del arma.
 */
public class Arma extends Objeto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ataqueMin, ataqueMax;

	public Arma() {
		super();
	}

	public Arma(String nombre, int ataqueMin, int ataqueMax, int valor) {
		super(nombre, valor);
		this.ataqueMax = ataqueMax;
		this.ataqueMin = ataqueMin;
	}

	public Arma(String nombre, int ataqueMin, int ataqueMax) {
		super(nombre);
		this.ataqueMax = ataqueMax;
		this.ataqueMin = ataqueMin;
	}

	public Arma(int ataqueMin, int ataqueMax) {
		super();
		this.ataqueMax = ataqueMax;
		this.ataqueMin = ataqueMin;
	}

	public int getAtaqueMin() {
		return ataqueMin;
	}

	public void setAtaqueMin(int ataqueMin) {
		this.ataqueMin = ataqueMin;
	}

	public int getAtaqueMax() {
		return ataqueMax;
	}

	public void setAtaqueMax(int ataqueMax) {
		this.ataqueMax = ataqueMax;
	}

	@Override
	public String toString() {
		return super.toString() + "Ataque: " + ataqueMin + "-" + ataqueMax + "|";
	}
}