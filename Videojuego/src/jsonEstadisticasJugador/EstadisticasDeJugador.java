package jsonEstadisticasJugador;

import org.json.JSONException;
import org.json.JSONObject;
import personajes.Jugador;

/**
 * Esta clase crea una plantilla con las estadísticas de un jugador.
 */
public class EstadisticasDeJugador {
	private String nombre;
	private String fechaDeInicio;
	private String tiempoTotalJugado;
	private int enemigosEliminados;
	private int pocionesBebidas;
	private int armasCompradas;
	private int armadurasCompradas;
	private int pocionesCompradas;
	private int cantidadDeOroTotalJuntado;

	public EstadisticasDeJugador(String nombre, String fechaDeInicio, String tiempoTotalJugado, int enemigosEliminados,
			int pocionesBebidas, int armasCompradas, int armadurasCompradas, int pocionesCompradas,
			int cantidadDeOroTotalJuntado) {
		super();
		this.nombre = nombre;
		this.fechaDeInicio = fechaDeInicio;
		this.tiempoTotalJugado = tiempoTotalJugado;
		this.enemigosEliminados = enemigosEliminados;
		this.pocionesBebidas = pocionesBebidas;
		this.armasCompradas = armasCompradas;
		this.armadurasCompradas = armadurasCompradas;
		this.pocionesCompradas = pocionesCompradas;
		this.cantidadDeOroTotalJuntado = cantidadDeOroTotalJuntado;
	}

	public EstadisticasDeJugador(Jugador jugador) {
		cargarEstadisticas(jugador);
	}

	/**
	 * Trae a un jugador y asigna a los atributos los valores correspondientes al
	 * mismo.
	 * 
	 * @param Trae un Jugador para extraer del mismo las estadísticas.
	 */
	public void cargarEstadisticas(Jugador jugador) {
		nombre = jugador.getNombre();
		fechaDeInicio = jugador.getFechaDeInicio();
		tiempoTotalJugado = tiempoLegible(jugador.getMomentoFinal() - jugador.getMomentoInicio());
		enemigosEliminados = jugador.getEnemigosEliminados();
		pocionesBebidas = jugador.getPocionesBebidas();
		armasCompradas = jugador.getArmasCompradas();
		armadurasCompradas = jugador.getArmadurasCompradas();
		pocionesCompradas = jugador.getPocionesCompradas();
		cantidadDeOroTotalJuntado = jugador.getCantidadDeOroTotalJuntado();
	}

	/**
	 * Hace legible el tiempo en nanosegundos traído por parámetro, dándole un
	 * formato que cualquiera pueda leer y entender.
	 *
	 * @return Se devuelve un String con el tiempo formateado correctamente.
	 */
	private String tiempoLegible(long nanoSegundo) {
		long tempSec = nanoSegundo / (1000 * 1000 * 1000);
		long seg = tempSec % 60;
		long min = (tempSec / 60) % 60;
		long hora = (tempSec / (60 * 60)) % 24;
		long dia = (tempSec / (24 * 60 * 60)) % 24;
		return String.format("%dd %dh %dm %ds", dia, hora, min, seg);
	}

	public String getNombre() {
		return nombre;
	}

	public String getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public String getTiempoTotalJugado() {
		return tiempoTotalJugado;
	}

	public int getEnemigosEliminados() {
		return enemigosEliminados;
	}

	public int getPocionesBebidas() {
		return pocionesBebidas;
	}

	public int getArmasCompradas() {
		return armasCompradas;
	}

	public int getArmadurasCompradas() {
		return armadurasCompradas;
	}

	public int getPocionesCompradas() {
		return pocionesCompradas;
	}

	public int getCantidadDeOroTotalJuntado() {
		return cantidadDeOroTotalJuntado;
	}

	/**
	 * Crea un objeto de tipo JSONObject, y lo carga (put) con los datos
	 * correspondientes a las estadísticas del jugador, las cuales son extraídas de
	 * los atributos de esta clase, y se le asignan claves a cada dato.
	 *
	 * @return Se devuelve un objeto JSONObject cargado.
	 */
	public JSONObject getFormatoJSON() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Nombre", getNombre());
		jsonObject.put("Fecha de inicio", getFechaDeInicio());
		jsonObject.put("Tiempo total jugado", getTiempoTotalJugado());
		jsonObject.put("Enemigos eliminados", getEnemigosEliminados());
		jsonObject.put("Pociones bebidas", getPocionesBebidas());
		jsonObject.put("Armas compradas", getArmasCompradas());
		jsonObject.put("Armaduras compradas", getArmadurasCompradas());
		jsonObject.put("Pociones compradas", getPocionesCompradas());
		jsonObject.put("Cantidad de oro total juntado", getCantidadDeOroTotalJuntado());
		return jsonObject;
	}

	@Override
	public String toString() {
		return "- Nombre: " + nombre + " | Fecha que jugó: " + fechaDeInicio + " | Tiempo total jugado: "
				+ tiempoTotalJugado + " | Enemigos eliminados: " + enemigosEliminados + " | Pociones bebidas: "
				+ pocionesBebidas + " | Armas compradas: " + armasCompradas + " | Armaduras compradas: "
				+ armadurasCompradas + " | Pociones compradas: " + pocionesCompradas
				+ " | Cantidad de oro total juntado: " + cantidadDeOroTotalJuntado;
	}
}