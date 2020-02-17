package juegoYZonas;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings.
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
		return "Te encuentras en las ruinas del antiguo templo de Numenor, anta\u00F1o uno de los edificios m\u00E1s importantes del reino.\r\n\r\nObservas que cerca hay un puente que lleva al pueblo de Brisapura, pero un cementerio se encuentra entre medio. Si vas al cementerio quizás tengas que enfrentar a alguna de las bestias que protegen la entrada.\r\n\r\nSi te diriges al bosque te toparás con algún lobo.";
	}

	public String getMensajeAlIntentarEntrarAlTemplo() {
		return "La puerta se encuentra cerrada. Será imposible entrar sin la llave. El pueblo de Brisapura queda pasando el cementerio, quizás allí sepan algo.";
	}

	public boolean isLlave() {
		return llave;
	}

	public void setLlave(boolean llave) {
		this.llave = llave;
	}
}