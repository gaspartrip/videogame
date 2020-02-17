package juegoYZonas;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings.
 */
public class Ciudad extends Zona {
	public Ciudad(int id) {
		super(id);
	}

	@Override
	public String getMensajeInicial() {
		return "Estás en la ciudad de Cantoblanco. \r\n\r\n> Quiz\u00E1s en la taberna sepan algo sobre d\u00F3nde empezar a buscar al dragón.\r\n> El mercado es un buen lugar para comprar provisiones.\r\n> Los lugare\u00F1os hablan sobre un bosque al sur de la ciudad al cual no quieren acercarse por temor a los monstruos que habitan all\u00ED. Si vas, probablemente encuentres alguna pista interesante.\r\n> Hay un tablón con un mapa de la zona.";
	}
}