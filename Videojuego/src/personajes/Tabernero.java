package personajes;

/**
 * Esta clase est� en la clase Taberna. Tiene especialmente m�todos que retornan
 * un String.
 */
public class Tabernero extends Humanoide {

	public Tabernero() {
		super();
	}
	
	public String contarSobreElDragon() {
		return "�Ja! Muchos lo han intentando en todos estos a�os, a la mayor�a no los he visto regresar... Me temo que te espera el mismo destino si de verdad intentas ir por esa bestia.";
	}

	public String darUbicacionDragon() {
		return "Pasando el bosque, en el templo de Numenor, o lo que queda de �l... al menos eso es lo que dicen los viajeros. O prueba suerte en el pueblo de Brisapura, pasando el cementerio que hay cerca de Numenor, quiz�s sepan algo. De cualquier manera, buena suerte, la necesitar�s.";
	}

	public String contarSobreLaTaberna() {
		return "�Las tabernas est�n en auge! Algunos buscan distracci�n, otros solo alejarse de la guerra.";
	}

	public String darUbicacionMercado() {
		return "Dir�gite al mercado, hay un armero que tiene lo mejor. No ser� barato...";
	}

	public String advertirSobreElBosque() {
		return "De nada. Ten cuidado si pretendes ir al bosque, los que se adentran all� rara vez suelen volver";
	}
}
