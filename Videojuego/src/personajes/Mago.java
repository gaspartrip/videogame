package personajes;

/**
 * Esta clase est� en la clase Brisapura. Tiene especialmente m�todos que
 * retornan un String.
 */
public class Mago extends Humanoide {

	public Mago(String nombre) {
		super(nombre);
	}

	public String preguntarNombre() {
		return "�Qui�n eres?";
	}

	public String echar() {
		return "- Un viajero m�s buscando convertirse en un matadrag�n... Lamento decirte que no puedo ayudarte, estoy muy ocupado. Busca ayuda en otra parte, caballero.";
	}

	public String agradecerPorLaCarta() {
		return "- No puedo creerlo, hab�a perdido las esperanzas de que me llegara esta carta. La guerra contra los nigromantes nos ha dejado casi incomunicados en este pueblo, todos los mensajeros est�n muriendo... Gracias, no s� c�mo devolverte el favor. ";
	}

	public String contarSobreLaCarta() {
		return "- Contiene informaci�n de vital importancia que podr�a ayudarnos a ganar la guerra contra los nigromantes. Solo eso puedo decirte, lo lamento.";
	}

	public String buscarInformacionDelDragon() {
		return "- He estado haciendo un estudio durante mi estancia en estas tierras.\n\n<El mago busca entre sus escritos>";
	}

	public String darInformacionDelDragon() {
		return "- �Ah, s�! Aqu� est�... el drag�n tiene su guarida en las catacumbas del templo de Numenor. El problema es que no hay manera de entrar al templo, olvid� la llave en un cofre mientras hac�a una investigaci�n en una cueva al noroeste. Lo lamento.";
	}

	public String darUbicacionCueva() {
		return "- Muy lejos, nunca llegar�as a pie. Y la cueva es muy peligrosa... Aunque algo me dice que eres muy terco para rescindir tu b�squeda. Mi transporte te puede llevar a la cueva. Tambi�n te podr�a llevar a Cantoblanco si as� lo deseas.";
	}

	public String desearSuerte() {
		return "- Buena suerte en la senda, caballero.";
	}
}