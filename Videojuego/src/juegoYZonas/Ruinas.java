package juegoYZonas;

/**
 * Esta clase sirve de plantilla para generar una zona espec�fica del juego, la
 * cual contiene m�todos que retornan Strings.
 */
public class Ruinas extends Zona {
	/**
	 * Atributo que pasa a true al conseguir la llave del templo de las ruinas.
	 */
	private boolean llave = false;

	public Ruinas(int id) {
		super(id);
	}

	@Override
	public String getMensajeInicial() {
		return "Te encuentras en las ruinas del antiguo templo de Numenor, anta\u00F1o uno de los edificios m\u00E1s importantes del reino.\r\n\r\nObservas que cerca hay un puente que lleva al pueblo de Brisapura, pero un cementerio se encuentra entre medio. Si vas al cementerio quiz�s tengas que enfrentar a alguna de las bestias que protegen la entrada.\r\n\r\nSi te diriges al bosque te topar�s con alg�n lobo.";
	}

	public String getMensajeAlIntentarEntrarAlTemplo() {
		return "La puerta se encuentra cerrada. Ser� imposible entrar sin la llave. El pueblo de Brisapura queda pasando el cementerio, quiz�s all� sepan algo.";
	}

	public boolean isLlave() {
		return llave;
	}

	public void setLlave(boolean llave) {
		this.llave = llave;
	}
}