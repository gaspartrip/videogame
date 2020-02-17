package juegoYZonas;

import personajes.NoHumanoide;

/**
 * Esta clase sirve de plantilla para generar una zona específica del juego, la
 * cual contiene métodos que retornan Strings y dos enemigos (de tipo
 * NoHumanoide).
 */
public class Cueva extends Zona {
	private NoHumanoide arañaGigante;
	private NoHumanoide esqueleto;
	// Cueva oeste
	private int cantidadDePocionesCofre = 1;
	// Cueva este
	private int cantidadDeOroCadaver = 50;

	public Cueva(int id) {
		super(id);
		arañaGigante = new NoHumanoide("Araña gigante", 50, 50, 20, 6, 30, "Mordedura venenosa");
		esqueleto = new NoHumanoide("Esqueleto", 70, 70, 22, 9, 30, "Peste de sangre");
	}

	public NoHumanoide getArañaGigante() {
		return arañaGigante;
	}
	
	public NoHumanoide getEsqueleto() {
		return esqueleto;
	}

	public void setEsqueleto(NoHumanoide esqueleto) {
		this.esqueleto = esqueleto;
	}

	@Override
	public String getMensajeInicial() {
		return "La entrada a la cueva se encuentra cubierta de escombros, casi inaccesible. Logras entrar por un hueco, pero provocando que m\u00E1s escombros caigan y tapen definitivamente la entrada. Ya no hay vuelta atr\u00E1s.\r\n\r\nAl entrar en la cueva enciendes sus viejas antorchas, y emprendes tu viaje en busca del cofre que contiene la llave y otra posible salida.";
	}

	public String getMensajeInicialCuevaEste() {
		return "Encuentras un cadáver devorado, envuelto en telarañas.";
	}

	public String getMensajeInicialCuevaOeste() {
		return "Encuentras un cofre.";
	}

	public String getMensajeInicialCuevaParte2() {
		return "Los caminos parecen ser varios. Tendrás que decidir por dónde ir.";
	}

	public String getMensajeInicialCuevaParte3() {
		return "Hay una puerta, pero esta cerrada. Parece haber algún tipo de mecanismo para abrirla.";
	}

	public String getMensajeInicialCuevaParte4() {
		return "Deber\u00E1s resolver el mecanismo de la puerta para poder continuar.";
	}

	public String getMensajeInicialCuevaParte5() {
		return "Del otro lado de la puerta encuentras un recinto con un cofre, y adentro de este, tal como te hab\u00EDa relatado el mago, la llave del templo.\r\n\r\nDentro del recinto hallas una salida directa al mar, tendr\u00E1s que nadar hasta tierra...";
	}
	
	public String getMensajeInicialCuevaParte6() {
		return "No te encuentras demasiado lejos de Brisapura, pero la zona está plagada de esqueletos. Tendrás que luchar para seguir avanzando.";
	}

	public int getCantidadDePocionesCofre() {
		return cantidadDePocionesCofre;
	}

	public void setCantidadDePocionesCofre(int cantidadDePocionesCofre) {
		this.cantidadDePocionesCofre = cantidadDePocionesCofre;
	}

	public int getCantidadDeOroCadaver() {
		return cantidadDeOroCadaver;
	}

	public void setCantidadDeOroCadaver(int cantidadDeOroCadaver) {
		this.cantidadDeOroCadaver = cantidadDeOroCadaver;
	}
}