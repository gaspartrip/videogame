package jsonEstadisticasJugador;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import personajes.Jugador;

/**
 * Esta clase sirve para cargar y guardar usando JSON las estadísticas de los
 * jugadores que superaron el juego.
 */
public class JSONUtiles {

	public JSONUtiles() {
	}

	/**
	 * Carga, si existe, el archivo "jugadores.json" del disco y extrae del mismo la
	 * información/estadísticas de los jugadores que superaron el juego en String
	 * para generar usando el método levantarJSON objetos de tipo
	 * EstadisticasDeJugador e incluirlos en una lista de la clase
	 * ListaDeEstadisticasDeJugador, la cual es creada también en este método. Por
	 * otra parte, crea y carga con la información del jugador actual un objeto de
	 * tipo EstadisticasDeJugador, el cual es agregado a la lista anteriormente
	 * mencionada. Finalmente extrae de la lista toda la información de todos los
	 * jugadores en un String.
	 * 
	 * @return Retorna un elemento de tipo String con toda la
	 *         información/estadísticas de los jugadores que superaron el juego en
	 *         un formato legible que será mostrado en pantalla.
	 * @param Trae un Jugador para agregar a la lista de estadísticas.
	 */
	public String retornarDatosJugadores(Jugador jugador) {
		ListaDeEstadisticasDeJugador lista = new ListaDeEstadisticasDeJugador();
		String contenido = "";
		try {
			contenido = new String(Files.readAllBytes(Paths.get("jugadores.json")));
			levantarJSON(lista, contenido);
		} catch (NoSuchFileException e) {
			JOptionPane.showMessageDialog(null,
					"No se encontró registro de ningún jugador. Este será el primer registro almacenado",
					"Estadísticas", JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		EstadisticasDeJugador est = new EstadisticasDeJugador(jugador);
		lista.agregar(est);
		generarYGuardarJSON(lista);
		String datos = lista.retornarDatos();
		return datos;
	}

	/**
	 * Carga el String retornado en el método leer, el cual está en formato JSON. Se
	 * recorre usando la clave correspondiente el mismo cargando las variables que
	 * serán necesarias para crear los objetos de tipo EstadísticasDelJugador, los
	 * cuales son ingresados en una lista en la clase ListaDeEstadisticasDeJugador.
	 * 
	 * @throws JSONException
	 */
	private void levantarJSON(ListaDeEstadisticasDeJugador lista, String respuesta) throws JSONException {
		JSONArray arregloDeLectura = new JSONArray(respuesta);
		for (int i = 0; i < arregloDeLectura.length(); i++) {
			JSONObject jsonObject = arregloDeLectura.getJSONObject(i);
			String nombre = jsonObject.getString("Nombre");
			String fechaDeInicio = jsonObject.getString("Fecha de inicio");
			String tiempoTotalJugado = jsonObject.getString("Tiempo total jugado");
			int enemigosEliminados = jsonObject.getInt("Enemigos eliminados");
			int pocionesBebidas = jsonObject.getInt("Pociones bebidas");
			int armasCompradas = jsonObject.getInt("Armas compradas");
			int armadurasCompradas = jsonObject.getInt("Armaduras compradas");
			int pocionesCompradas = jsonObject.getInt("Pociones compradas");
			int cantidadDeOroTotalJuntado = jsonObject.getInt("Cantidad de oro total juntado");
			EstadisticasDeJugador est = new EstadisticasDeJugador(nombre, fechaDeInicio, tiempoTotalJugado,
					enemigosEliminados, pocionesBebidas, armasCompradas, armadurasCompradas, pocionesCompradas,
					cantidadDeOroTotalJuntado);
			lista.agregar(est);
		}
	}

	/**
	 * Crea y graba un archivo JSONArray en disco, con la información ya generada en
	 * el formato JSON extraída de cada elemento de la clase EstadisticasDeJugador
	 * usando el método getFormatoJSON. Cada elemento se extrajo de la lista de
	 * jugadores retornada del objeto ListaDeEstadisticasDeJugador (traído por
	 * parámetro).
	 */
	private void generarYGuardarJSON(ListaDeEstadisticasDeJugador listaDeEst) {
		ArrayList<EstadisticasDeJugador> lista = listaDeEst.getLista();
		try {
			JSONArray jsonArray = new JSONArray();
			for (EstadisticasDeJugador e : lista) {
				jsonArray.put(e.getFormatoJSON());
			}
			grabarEnArchivo(jsonArray);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Graba en el disco el JSONArray traído por parámetro.
	 */
	private void grabarEnArchivo(JSONArray jsonArray) {
		try {
			FileWriter file = new FileWriter("jugadores.json");
			file.write(jsonArray.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}