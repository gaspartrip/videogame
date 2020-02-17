package personajes;

import java.util.concurrent.ThreadLocalRandom;
import objetos.Arma;
import objetos.Armadura;

/**
 * Esta clase está en la clase Cementerio. Cuenta con una constante String con
 * el nombre de su ataque especial, el cual se puede retornar y ser de utilidad
 * en las batallas.
 */
public class Nigromante extends Humanoide implements IAtaqueEspecial {

	private static final String NOMBRE_ATAQUE_ESPECIAL = "Lanza cadavérica";

	public Nigromante(String nombre, int vidaMax, int vidaActual) {
		super(nombre, vidaMax, vidaActual, new Arma(15, 30), new Armadura(20));
	}

	public Nigromante(String nombre, int vidaMax, int vidaActual, Arma miArma, Armadura miArmadura) {
		super(nombre, vidaMax, vidaActual, miArma, miArmadura);
	}

	public String getNombreAtaqueEspecial() {
		return NOMBRE_ATAQUE_ESPECIAL;
	}

	/**
	 * Este método implementado en la interfaz IAtaqueEspecial recibe un enemigo,
	 * siempre de tipo Jugador, ya que será el único enemigo de esta clase, y dos
	 * enteros con los daños máximos y mínimos. Determina un valor intermedio entre
	 * estos enteros, ese valor es la cantidad de vida que se le bajará al enemigo.
	 * Finalmente retorna este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Daño que se le ocasionó al enemigo.
	 */
	@Override
	public int lanzarAtaqueEspecial(Jugador enemigo, int dañoMin, int dañoMax) {
		int daño = ThreadLocalRandom.current().nextInt(dañoMin, dañoMax + 1);
		enemigo.recibirDaño(daño);
		return daño;
	}
}