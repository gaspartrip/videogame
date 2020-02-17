package objetos;

import java.io.Serializable;

/**
 * Esta clase abstracta sirve de plantilla para generar todos los objetos del
 * juego: Arma, Armadura y Pocion. Contiene un nombre y un valor de compra en el
 * mercado.
 */
public abstract class Objeto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int valor;

	public Objeto() {

	}

	public Objeto(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public Objeto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "|" + nombre + " | Valor: " + valor + " | ";
	}
}