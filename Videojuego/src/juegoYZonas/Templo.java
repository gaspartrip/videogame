package juegoYZonas;

import personajes.NoHumanoide;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings y dos enemigos de tipo NoHumanoide
 * (Nomuerto y Dragón).
 */
public class Templo extends Zona {
	private NoHumanoide dragon;
	private NoHumanoide noMuerto;
	/**
	 * Atributo que pasa a true cuando te enfrentas con el Nomuerto.
	 */
	private boolean enfrentamientoNoMuerto;
	private static final int ORO_NO_MUERTO = 500;

	public Templo(int id) {
		super(id);
		dragon = new NoHumanoide("Dragón", 120, 150, 40, 20, 50, "Aliento de dragón");
		noMuerto = new NoHumanoide("No-muerto", 90, 90, 35, 15, 45, "Portón de la muerte");
	}

	public NoHumanoide getDragon() {
		return dragon;
	}

	public NoHumanoide getNoMuerto() {
		return noMuerto;
	}
	
	public boolean isEnfrentamientoNoMuerto() {
		return enfrentamientoNoMuerto;
	}

	public void setEnfrentamientoNoMuerto(boolean enfrentamientoNoMuerto) {
		this.enfrentamientoNoMuerto = enfrentamientoNoMuerto;
	}
	
	public int getOroRecibidoNoMuerto() {
		return ORO_NO_MUERTO;
	}

	@Override
	public String getMensajeInicial() {
		return "Finalmente llegas al templo. La entrada al salón principal está bloqueada por un poderoso no-muerto. Tendrás que derrotarlo.";
	}

	public String getMensajeInicial2() {
		return "Sientes la presencia del drag\u00F3n. Solo queda enfrentarte a tu destino...\r\n\r\n> Equípate bien antes de pasar a la etapa final.";
	}
	
	public String getMensajeInicialAlternativo() {
		return "La entrada al salón principal está abierta, el dragón se encuentra por ese camino.";
	}
}