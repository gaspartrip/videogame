package juegoYZonas;

/**
 * Esta clase sirve de plantilla para generar una zona espec�fica del juego, la
 * cual contiene m�todos que retornan Strings.
 */
public class Ciudad extends Zona {
	public Ciudad(int id) {
		super(id);
	}

	@Override
	public String getMensajeInicial() {
		return "Est�s en la ciudad de Cantoblanco. \r\n\r\n> Quiz\u00E1s en la taberna sepan algo sobre d\u00F3nde empezar a buscar al drag�n.\r\n> El mercado es un buen lugar para comprar provisiones.\r\n> Los lugare\u00F1os hablan sobre un bosque al sur de la ciudad al cual no quieren acercarse por temor a los monstruos que habitan all\u00ED. Si vas, probablemente encuentres alguna pista interesante.\r\n> Hay un tabl�n con un mapa de la zona.";
	}
}