package juegoYZonas;

import personajes.Nigromante;
import personajes.NoHumanoide;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings y dos enemigo (de tipo Nigromante
 * y NoHumanoide).
 */
public class Cementerio extends Zona {
	private Nigromante nigromante;
	private NoHumanoide squirtle;

	/**
	 * En el cementerio hay una carta para tomar. Si la tomas este atributo pasa a
	 * true.
	 */
	private boolean cartaSellada = false;

	public Cementerio(int id) {
		super(id);
		nigromante = new Nigromante("Nigromante", 60, 60);
		squirtle = new NoHumanoide("Squirtle", 60, 60, 18, 8, 25, "Hidrobomba");
	}

	public Nigromante getNigromante() {
		return nigromante;
	}

	public NoHumanoide getSquirtle() {
		return squirtle;
	}

	@Override
	public String getMensajeInicial() {
		return "Una vez en el cementerio, te cruzas con un hombre yendo en tu lado opuesto, corriendo hacia el bosque mientras deja caer torpemente un morral cerca tuyo. \"\u00A1Est\u00E1n aqu\u00ED!\" grita repetidamente, hasta desaparecer entre los \u00E1rboles.\r\n\r\n" + getMensajeInicialAlternativo();
	}

	public String getMensajeInicialAlternativo() {
		return "Si quieres ir a las ruinas quizás tengas que enfrentar a alguna de las bestias que acechan en la entrada del cementerio.";
	}

	public String getMensajeAlVerMorral() {
		return "\n\n[Dentro del morral encuentras una carta sellada dirigida a Zireael, mago del consejo. El hombre que lo perdió seguramente era un mensajero. Te llevas la carta contigo]";
	}

	public boolean isCartaSellada() {
		return cartaSellada;
	}

	public void setCartaSellada(boolean cartaSellada) {
		this.cartaSellada = cartaSellada;
	}

	public String getMensajeInicialParte2() {
		return "Estás casi en la salida del interminable cementerio, cuando tus peores temores se hacen realidad, poderosos nigromantes se revelan acechando entre las criptas en dirección al puente. Uno de ellos se interpone en tu camino.";
	}

	public String getMensajeInicialPorSegundaVezParte2() {
		return "Poderosos nigromantes se revelan acechando en la salida del cementerio en dirección al puente.";
	}
}