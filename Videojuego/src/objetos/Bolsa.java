package objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase genérica con una lista ArrayList cuyas operaciones no dependen del tipo
 * de datos almacenado.
 */
public class Bolsa<T> implements Iterable<T>, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<T> lista;

	public Bolsa() {
		lista = new ArrayList<T>();
	}

	public void agregar(T objeto) {
		lista.add(objeto);
	}

	public Iterator<T> iterator() {
		return lista.iterator();
	}

	/**
	 * Retorna la cantidad de objetos de la bolsa.
	 * 
	 * @return Cantidad de objetos de la bolsa.
	 */
	public int cantidad() {
		return lista.size();
	}

	/**
	 * Recibe una posición y retorna el objeto que se encuentra en la misma.
	 * 
	 * @param pos La posición del objeto en la bolsa.
	 * @return El objeto de la posición.
	 */
	public T retornarObjeto(int pos) {
		return lista.get(pos);
	}

	/**
	 * Recibe el objeto a eliminar de la bolsa.
	 * 
	 * @param objeto El objeto a eliminar en la bolsa.
	 */
	public void eliminar(T objeto) {
		lista.remove(objeto);
	}

	/**
	 * Recibe la posición del objeto a eliminar de la bolsa.
	 * 
	 * @param pos La posiciób dek objeto a eliminar en la bolsa.
	 */
	public void eliminar(int pos) {
		lista.remove(pos);
	}

	public ArrayList<T> retornarLista() {
		return lista;
	}

	public boolean contiene(T objeto) {
		boolean resultado = false;
		if (lista.contains(objeto))
			resultado = true;
		return resultado;
	}
}