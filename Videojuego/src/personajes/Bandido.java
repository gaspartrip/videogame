package personajes;

import objetos.Arma;
import objetos.Armadura;

/**
 * Esta clase está en la clase Puente. Tiene especialmente métodos que retornan
 * un String, además de un Arma y Armadura, cuyos valores de ataque/defensa
 * pueden modificarse desde los constructores de aquí. El jugador se enfrenta
 * con un Bandido en la zona Puente.
 */
public class Bandido extends Humanoide {
	public Bandido(String nombre, int vidaMax, int vidaActual, Arma miArma, Armadura miArmadura) {
		super(nombre, vidaMax, vidaActual, miArma, miArmadura);
	}

	public Bandido(String nombre, int vidaMax, int vidaActual) {
		super(nombre, vidaMax, vidaActual, new Arma(15, 30), new Armadura(20));
	}

	public String advertir() {
		return "- ¡Ey, alto ahí! No te entrometas en lo que no te concierne, sigue tu camino.";
	}

	public String amenazar() {
		return "- ¡Ni un paso más! ¿Qué quieres?";
	}

	public String negociar() {
		return "- ¿Y qué me das a cambio?";
	}

	public String preguntarPorElOro() {
		return "- Mmm, quizás. Todo depende de cuánto, piensa en la pobre vida de esta chica.";
	}

	public String echarViolentamente() {
		return "- ¿Solo eso? Vete de aquí maldita escoria.";
	}

	public String acordar() {
		return "- De acuerdo, la dejare ir.";
	}

	public String echar() {
		return "- No me hagas perder el tiempo si no tienes dinero. Vete de aquí.";
	}

	public String amenazarViolentamente() {
		return "- ¡Jamás, muere tú, maldita escoria!";
	}
}