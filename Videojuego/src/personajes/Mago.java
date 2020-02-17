package personajes;

/**
 * Esta clase está en la clase Brisapura. Tiene especialmente métodos que
 * retornan un String.
 */
public class Mago extends Humanoide {

	public Mago(String nombre) {
		super(nombre);
	}

	public String preguntarNombre() {
		return "¿Quién eres?";
	}

	public String echar() {
		return "- Un viajero más buscando convertirse en un matadragón... Lamento decirte que no puedo ayudarte, estoy muy ocupado. Busca ayuda en otra parte, caballero.";
	}

	public String agradecerPorLaCarta() {
		return "- No puedo creerlo, había perdido las esperanzas de que me llegara esta carta. La guerra contra los nigromantes nos ha dejado casi incomunicados en este pueblo, todos los mensajeros están muriendo... Gracias, no sé cómo devolverte el favor. ";
	}

	public String contarSobreLaCarta() {
		return "- Contiene información de vital importancia que podría ayudarnos a ganar la guerra contra los nigromantes. Solo eso puedo decirte, lo lamento.";
	}

	public String buscarInformacionDelDragon() {
		return "- He estado haciendo un estudio durante mi estancia en estas tierras.\n\n<El mago busca entre sus escritos>";
	}

	public String darInformacionDelDragon() {
		return "- ¡Ah, sí! Aquí está... el dragón tiene su guarida en las catacumbas del templo de Numenor. El problema es que no hay manera de entrar al templo, olvidé la llave en un cofre mientras hacía una investigación en una cueva al noroeste. Lo lamento.";
	}

	public String darUbicacionCueva() {
		return "- Muy lejos, nunca llegarías a pie. Y la cueva es muy peligrosa... Aunque algo me dice que eres muy terco para rescindir tu búsqueda. Mi transporte te puede llevar a la cueva. También te podría llevar a Cantoblanco si así lo deseas.";
	}

	public String desearSuerte() {
		return "- Buena suerte en la senda, caballero.";
	}
}