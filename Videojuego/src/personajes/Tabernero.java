package personajes;

/**
 * Esta clase está en la clase Taberna. Tiene especialmente métodos que retornan
 * un String.
 */
public class Tabernero extends Humanoide {

	public Tabernero() {
		super();
	}
	
	public String contarSobreElDragon() {
		return "¡Ja! Muchos lo han intentando en todos estos años, a la mayoría no los he visto regresar... Me temo que te espera el mismo destino si de verdad intentas ir por esa bestia.";
	}

	public String darUbicacionDragon() {
		return "Pasando el bosque, en el templo de Numenor, o lo que queda de él... al menos eso es lo que dicen los viajeros. O prueba suerte en el pueblo de Brisapura, pasando el cementerio que hay cerca de Numenor, quizás sepan algo. De cualquier manera, buena suerte, la necesitarás.";
	}

	public String contarSobreLaTaberna() {
		return "¡Las tabernas están en auge! Algunos buscan distracción, otros solo alejarse de la guerra.";
	}

	public String darUbicacionMercado() {
		return "Dirígite al mercado, hay un armero que tiene lo mejor. No será barato...";
	}

	public String advertirSobreElBosque() {
		return "De nada. Ten cuidado si pretendes ir al bosque, los que se adentran allí rara vez suelen volver";
	}
}
