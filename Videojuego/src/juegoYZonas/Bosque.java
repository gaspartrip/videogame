package juegoYZonas;

import personajes.NoHumanoide;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings y un enemigo (de tipo
 * NoHumanoide).
 */
public class Bosque extends Zona {
	private NoHumanoide lobo;

	public Bosque(int id) {
		super(id);
		lobo = new NoHumanoide("Lobo", 45, 45, 13, 10, 23, "Mordedura vil");
	}

	public NoHumanoide getLobo() {
		return lobo;
	}

	@Override
	public String getMensajeInicial() {
		return "Al adentrarte en las profundidades del bosque, no encuentras m\u00E1s que cad\u00E1veres y espadas oxidadas.\r\n\r\nCuando cre\u00EDas que ibas a atravesar el bosque sin encontrarte con alg\u00FAn peligro, notas inmensos grupos de lobos, casi como si estuviesen custodiando la salida del bosque al sur.\r\n\r\nSolo se podrá seguir avanzando enfrentando a uno de ellos.";
	}

	public String getMensajeAlEncontrarteConLobo() {
		return "Hay demasiados lobos en la salida del bosque hacia el sur. La única oportundidad de pasar será enfrentar a uno de ellos...\n\n";
	}
}