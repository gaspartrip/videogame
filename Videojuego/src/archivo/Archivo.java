package archivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 * Esta clase genérica sirve para cargar y guardar objetos de cualquier tipo
 * logrando la persistencia de los datos.
 */
public class Archivo<T> {

	public Archivo() {
	}

	/**
	 * Recibe un ObjectInputStream, lo lee y devuelve un objeto con los datos.
	 */
	@SuppressWarnings("unchecked")
	private T leerYCargar(ObjectInputStream ois) {
		T dato = null;
		try {
			dato = (T) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dato;
	}

	/**
	 * Carga el archivo del disco y retorna el contenido (un objeto).
	 * 
	 * @return Retorna un elemento de tipo Comerciante, cargado del disco.
	 * @param Trae por parámetro la dirección del archivo a cargar.
	 */
	public T cargarDatos(String direccion) {
		T dato = null;
		FileInputStream archivo = null;
		ObjectInputStream ois = null;
		try {
			archivo = new FileInputStream(direccion);
			ois = new ObjectInputStream(archivo);
			dato = leerYCargar(ois);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No hay nada que cargar en el disco", "Error al cargar",
					JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dato;
	}

	/**
	 * Guarda el archivo en el disco, reemplazando al existen (si lo había).
	 * 
	 * @return Retorna true si el guardado fue exitoso.
	 * @param Trae por parámetro la dirección del archivo a guardar.
	 */
	public boolean guardarDatos(T datoAGuardar, String direccion) {
		boolean resultado = false;
		FileOutputStream archivo = null;
		ObjectOutputStream oos = null;
		try {
			archivo = new FileOutputStream(direccion);
			oos = new ObjectOutputStream(archivo);
			oos.writeObject(datoAGuardar);
			resultado = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
