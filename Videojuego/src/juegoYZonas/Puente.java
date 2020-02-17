package juegoYZonas;

import personajes.Bandido;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings y un enemigo (Bandido).
 */
public class Puente extends Zona {
	private Bandido bandido;
	/**
	 * Atributo que pasa a true si rescatas a la comerciante asaltada por el bandido
	 * en el puente.
	 */
	private boolean rescateComerciante = false;
	/**
	 * Atributo que pasa a true si batallas al bandido del puente.
	 */
	private boolean batallaBandido = false;
	private final int oroMaximoRescate = 130; //Si convences y le das 130 de oro al bandido, ganas 3 pociones. 3 pociones en el mercado serían 150 de oro.
	private final int oroMinimoRescate = 50;
	private final int cantidadDePocionesDeLoot = 3;

	public Puente(int id) {
		super(id);
		bandido = new Bandido("Bandido", 70, 70);
	}

	public Bandido getBandido() {
		return bandido;
	}

	@Override
	public String getMensajeInicial() {
		return "Te encuentras en el Puente de Brisapura. \r\n\r\nUn bandido est\u00E1 asaltando a un comerciante. \r\n\r\nSi te diriges hacia el cementerio te encontrarás con algún nigromante.";
	}

	public String getMensajeInicialAlEncontrarteConBandido() {
		return "Desde aquí puedes dirigirte al pueblo de Brisapura o al cementerio. Si te diriges hacia el cementerio te encontrarás con algún nigromante.";
	}

	public boolean isRescateComerciante() {
		return rescateComerciante;
	}

	public void setRescateComerciante(boolean rescateComerciante) {
		this.rescateComerciante = rescateComerciante;
	}

	public boolean isBatallaBandido() {
		return batallaBandido;
	}

	public void setBatallaBandido(boolean batallaBandido) {
		this.batallaBandido = batallaBandido;
	}

	public int getOroMaximoRescate() {
		return oroMaximoRescate;
	}

	public int getOroMinimoRescate() {
		return oroMinimoRescate;
	}

	public int getCantidadDePocionesDeLoot() {
		return cantidadDePocionesDeLoot;
	}
}