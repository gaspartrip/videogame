package juegoYZonas;

import java.util.HashMap;
import personajes.Jugador;

/**
 * Clase principal. Construye todo lo necesario para implementar el juego.
 */
public class Juego {
	private final int oroGanado = 20; // Oro ganado al matar a un enemigo
	private Jugador jugador;
	private HashMap<Integer, Zona> zonas;

	public Juego() {
		jugador = new Jugador("Sin nombre", 100, 100);
		zonas = new HashMap<Integer, Zona>();
		generarZonas();
	}

	public int getOroGanado() {
		return oroGanado;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public String retornarMensajeAlIniciarJuego() {
		return "El reino se encuentra en decadencia y solo t\u00FA, uno de los \u00FAltimos caballeros de Kirkwall, puede hacer frente al mal que lo amenaza.\r\n\r\nTe diriges hacia la Tierra de Nadie, d\u00F3nde deber\u00E1s buscar y hacer frente al drag\u00F3n que azota la zona, solo as\u00ED se podr\u00E1 recuperar la paz que alguna vez pobl\u00F3 esas tierras...";
	}

	/**
	 * Crea todas las zonas del juego.
	 */
	private void generarZonas() {
		Ciudad ciudad = new Ciudad(1);
		Mercado mercado = new Mercado(2);
		Taberna taberna = new Taberna(3);
		Bosque bosque = new Bosque(4);
		Ruinas ruinas = new Ruinas(5);
		Cementerio cementerio = new Cementerio(6);
		Puente puente = new Puente(7);
		Brisapura brisapura = new Brisapura(8);
		Cueva cueva = new Cueva(9);
		Templo templo = new Templo(10);

		agregarZona(ciudad);
		agregarZona(mercado);
		agregarZona(taberna);
		agregarZona(bosque);
		agregarZona(ruinas);
		agregarZona(cementerio);
		agregarZona(puente);
		agregarZona(brisapura);
		agregarZona(cueva);
		agregarZona(templo);
	}

	private void agregarZona(Zona zona) {
		zonas.put(zona.getId(), zona);
	}

	public Zona retornarZona(int id) {
		return zonas.get(id);
	}

	public Ciudad retornarCiudad() {

		return (Ciudad) zonas.get(1);
	}

	public Mercado retornarMercado() {

		return (Mercado) zonas.get(2);
	}

	public Taberna retornarTaberna() {

		return (Taberna) zonas.get(3);
	}

	public Bosque retornarBosque() {

		return (Bosque) zonas.get(4);
	}

	public Ruinas retornarRuinas() {

		return (Ruinas) zonas.get(5);
	}

	public Cementerio retornarCementerio() {

		return (Cementerio) zonas.get(6);
	}

	public Puente retornarPuente() {

		return (Puente) zonas.get(7);
	}

	public Brisapura retornarBrisapura() {

		return (Brisapura) zonas.get(8);
	}

	public Cueva retornarCueva() {

		return (Cueva) zonas.get(9);
	}

	public Templo retornarTemplo() {

		return (Templo) zonas.get(10);
	}
}