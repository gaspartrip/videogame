package personajes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Esta clase está incluida en diversas clases, de aquí sale el enemigo "Dragón"
 * incluido en la clase Templo o el enemigo "Lobo" de la clase Bosque. Cuenta
 * con un String con el nombre de su ataque especial, el cual se carga y puede
 * ser de utilidad para retornar y mostrar en las batallas. Además tiene un daño
 * de ataque máximo y mínimo así como una defensa.
 * 
 */
public class NoHumanoide extends Personaje<Jugador> implements IAtaqueEspecial {

	private int dañoMax;
	private int dañoMin;
	private int defensa;
	private String nombreAtaqueEspecial;

	public NoHumanoide(String nombre, int vidaMax, int vidaActual, int dañoMax, int dañoMin, int defensa,
			String nombreAtaqueEspecial) {
		super(nombre, vidaMax, vidaActual);
		this.dañoMax = dañoMax;
		this.dañoMin = dañoMin;
		this.defensa = defensa;
		this.nombreAtaqueEspecial = nombreAtaqueEspecial;
	}

	public int getDañoMax() {
		return dañoMax;
	}

	public void setDañoMax(int dañoMax) {
		this.dañoMax = dañoMax;
	}

	public int getDañoMin() {
		return dañoMin;
	}

	public void setDañoMin(int dañoMin) {
		this.dañoMin = dañoMin;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getNombreAtaqueEspecial() {
		return nombreAtaqueEspecial;
	}

	public void setNombreAtaqueEspecial(String nombreAtaqueEspecial) {
		this.nombreAtaqueEspecial = nombreAtaqueEspecial;
	}

	/**
	 * Este método sobrecargado de la clase padre recibe un enemigo (que será el
	 * jugador, clase Jugador). Determina un valor intermedio entre el daño máximo y
	 * el daño mínimo de la clase teniendo en cuenta la defensa del enemigo y si
	 * este tiene activa la habilidad de defensa, la cual reduce el daño ocasionado.
	 * Este valor es la cantidad de vida que se le bajará al enemigo. Finalmente
	 * retorna este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Daño que se le ocasionó al enemigo.
	 */
	@Override
	public int atacar(Jugador enemigo) {
		int ataque, daño, defensa;
		// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		daño = ThreadLocalRandom.current().nextInt(dañoMin, dañoMax + 1);
		defensa = enemigo.getArmadura().getDefensa();
		float puntosDeAtaque = daño * daño / (daño + defensa);
		ataque = (int) puntosDeAtaque;
		if (enemigo.getHabilidadDeDefensa().isActiva()) {
			ataque = enemigo.getHabilidadDeDefensa().retornarDañoReducido(ataque);
		}
		enemigo.recibirDaño(ataque);
		return ataque;
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