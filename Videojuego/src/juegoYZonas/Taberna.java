package juegoYZonas;

import personajes.Tabernero;

/**
 * Esta clase sirve de plantilla para generar una zona espec�fica del juego, la
 * cual contiene m�todos que retornan Strings y un aliado (Tabernero).
 */
public class Taberna extends Zona {
	private Tabernero tabernero;
	/**
	 * Atributo que pasa a true si se logra la expulsi�n de la taberna.
	 */
	private boolean suspensionTaberna = false;

	public Taberna(int id) {
		super(id);
		tabernero = new Tabernero();
	}

	public Tabernero getTabernero() {
		return tabernero;
	}

	@Override
	public String getMensajeInicial() {
		return "El tabernero te habla:\r\n\r\n";
	}

	public String getMensajeSuspensionTaberna() {
		return "[Te han echado de la taberna por emborracharte y provocar disturbios]\n\n";
	}

	public boolean isSuspensionTaberna() {
		return suspensionTaberna;
	}

	public void setSuspensionTaberna(boolean suspensionTaberna) {
		this.suspensionTaberna = suspensionTaberna;
	}
}