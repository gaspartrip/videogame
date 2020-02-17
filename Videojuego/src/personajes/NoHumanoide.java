package personajes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Esta clase est� incluida en diversas clases, de aqu� sale el enemigo "Drag�n"
 * incluido en la clase Templo o el enemigo "Lobo" de la clase Bosque. Cuenta
 * con un String con el nombre de su ataque especial, el cual se carga y puede
 * ser de utilidad para retornar y mostrar en las batallas. Adem�s tiene un da�o
 * de ataque m�ximo y m�nimo as� como una defensa.
 * 
 */
public class NoHumanoide extends Personaje<Jugador> implements IAtaqueEspecial {

	private int da�oMax;
	private int da�oMin;
	private int defensa;
	private String nombreAtaqueEspecial;

	public NoHumanoide(String nombre, int vidaMax, int vidaActual, int da�oMax, int da�oMin, int defensa,
			String nombreAtaqueEspecial) {
		super(nombre, vidaMax, vidaActual);
		this.da�oMax = da�oMax;
		this.da�oMin = da�oMin;
		this.defensa = defensa;
		this.nombreAtaqueEspecial = nombreAtaqueEspecial;
	}

	public int getDa�oMax() {
		return da�oMax;
	}

	public void setDa�oMax(int da�oMax) {
		this.da�oMax = da�oMax;
	}

	public int getDa�oMin() {
		return da�oMin;
	}

	public void setDa�oMin(int da�oMin) {
		this.da�oMin = da�oMin;
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
	 * Este m�todo sobrecargado de la clase padre recibe un enemigo (que ser� el
	 * jugador, clase Jugador). Determina un valor intermedio entre el da�o m�ximo y
	 * el da�o m�nimo de la clase teniendo en cuenta la defensa del enemigo y si
	 * este tiene activa la habilidad de defensa, la cual reduce el da�o ocasionado.
	 * Este valor es la cantidad de vida que se le bajar� al enemigo. Finalmente
	 * retorna este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Da�o que se le ocasion� al enemigo.
	 */
	@Override
	public int atacar(Jugador enemigo) {
		int ataque, da�o, defensa;
		// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		da�o = ThreadLocalRandom.current().nextInt(da�oMin, da�oMax + 1);
		defensa = enemigo.getArmadura().getDefensa();
		float puntosDeAtaque = da�o * da�o / (da�o + defensa);
		ataque = (int) puntosDeAtaque;
		if (enemigo.getHabilidadDeDefensa().isActiva()) {
			ataque = enemigo.getHabilidadDeDefensa().retornarDa�oReducido(ataque);
		}
		enemigo.recibirDa�o(ataque);
		return ataque;
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