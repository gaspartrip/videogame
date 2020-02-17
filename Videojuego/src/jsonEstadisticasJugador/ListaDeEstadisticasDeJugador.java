package jsonEstadisticasJugador;

import java.util.ArrayList;

/**
 * Esta clase contiene una lista con todos los jugadores que han terminado el
 * juego, la cual se carga del disco usando JSON.
 */
public class ListaDeEstadisticasDeJugador {
	private ArrayList<EstadisticasDeJugador> lista;

	public ListaDeEstadisticasDeJugador() {
		lista = new ArrayList<>();
	}

	public boolean agregar(EstadisticasDeJugador est) {
		boolean resultado = false;
		if (!lista.contains(est)) {
			lista.add(est);
			resultado = true;
		}
		return resultado;
	}

	public ArrayList<EstadisticasDeJugador> getLista() {
		return lista;
	}

	public String retornarDatos() {
		String datos = "";
		for (EstadisticasDeJugador e : lista) {
			datos = datos + e.toString() + "\n\n";
		}
		return datos;
	}
}