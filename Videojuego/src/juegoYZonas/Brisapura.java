package juegoYZonas;

import java.text.SimpleDateFormat;
import personajes.Mago;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings y un aliado (de clase Mago).
 */
public class Brisapura extends Zona {
	private Mago mago;
	/**
	 * Cantidad de oro que se necesita para dorir en la posada y recuperar toda la
	 * salud.
	 */
	private final int precioPosada = 250;
	private java.util.Date hora = new java.util.Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	public Brisapura(int id) {
		super(id);
		mago = new Mago("Zireael");
	}

	public Mago getMago() {
		return mago;
	}

	@Override
	public String getMensajeInicial() {
		return "Est\u00E1s en el pueblo de Brisapura.\r\n\r\n> Todos hablan de un mago que reside en el pueblo, deber\u00EDas ir a hablar con él, seguro sabe algo sobre el drag\u00F3n.\r\n> Puedes descansar en la posada y recuperar salud por "
				+ precioPosada + " monedas de oro.";
	}

	public String getMensajeMago() {
		return "El mago parece haberse disgustado al notar tu presencia: \n\n";
	}

	public String getMensajeManticora() {
		return "Est\u00E1s frente a una mant\u00EDcora, una de las m\u00E1s peligrosas y antiguas criaturas del continente. Para tu suerte, se encuentra encantada con magia y te permitirá montarla.";
	}

	public boolean dineroSuficientePosada(int oroJugador) {
		boolean resultado;
		if (oroJugador >= precioPosada) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

	public String dormirEnLaPosada() {
		String datoSalud = "";
		datoSalud = "\n\n[" + sdf.format(hora) + " - Dormiste en la posada, tu vida se recuperó al máximo][- "
				+ precioPosada + " oro]";
		return datoSalud;
	}

	public String noPoderDormirEnLaPosada() {
		String datoSalud = "";
		datoSalud = "\n\n[" + sdf.format(hora) + " - No tienes suficiente dinero para dormir en la posada]";
		return datoSalud;
	}

	public int getPrecioPosada() {
		return precioPosada;
	}
}