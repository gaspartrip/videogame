package personajes;

import java.util.concurrent.ThreadLocalRandom;
import objetos.Arma;
import objetos.Armadura;

/**
 * Esta clase est� en la clase Cementerio. Cuenta con una constante String con
 * el nombre de su ataque especial, el cual se puede retornar y ser de utilidad
 * en las batallas.
 */
public class Nigromante extends Humanoide implements IAtaqueEspecial {

	private static final String NOMBRE_ATAQUE_ESPECIAL = "Lanza cadav�rica";

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
	 * Este m�todo implementado en la interfaz IAtaqueEspecial recibe un enemigo,
	 * siempre de tipo Jugador, ya que ser� el �nico enemigo de esta clase, y dos
	 * enteros con los da�os m�ximos y m�nimos. Determina un valor intermedio entre
	 * estos enteros, ese valor es la cantidad de vida que se le bajar� al enemigo.
	 * Finalmente retorna este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Da�o que se le ocasion� al enemigo.
	 */
	@Override
	public int lanzarAtaqueEspecial(Jugador enemigo, int da�oMin, int da�oMax) {
		int da�o = ThreadLocalRandom.current().nextInt(da�oMin, da�oMax + 1);
		enemigo.recibirDa�o(da�o);
		return da�o;
	}
}