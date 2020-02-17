package personajes;

import java.util.concurrent.ThreadLocalRandom;
import objetos.Arma;
import objetos.Armadura;

/**
 * Esta clase est� incluida en diversas clases, de aqu� sale el enemigo Bandido
 * incluido en la clase Puente, el aliado Mago o el Jugador. Cuenta con un Arma
 * y una Armadura.
 */
@SuppressWarnings("rawtypes")
public abstract class Humanoide extends Personaje<Personaje> {

	private Arma miArma;
	private Armadura miArmadura;

	public Humanoide() {
		super();
		cargarDeArmaYArmaduraPorDefecto();
	}

	public Humanoide(String nombre) {
		super(nombre);
		cargarDeArmaYArmaduraPorDefecto();
	}

	public Humanoide(String nombre, int vidaMax, int vidaActual) {
		super(nombre, vidaMax, vidaActual);
		cargarDeArmaYArmaduraPorDefecto();
	}

	public Humanoide(String nombre, int vidaMax, int vidaActual, Arma miArma, Armadura miArmadura) {
		super(nombre, vidaMax, vidaActual);
		this.miArma = miArma;
		this.miArmadura = miArmadura;
		cargarDeArmaYArmaduraPorDefecto();
	}

	private void cargarDeArmaYArmaduraPorDefecto() {
		miArma = new Arma("Espada de acero", 12, 25, 100);
		miArmadura = new Armadura("Armadura imperial ligera", 15, 100);
	}

	public Arma getArma() {
		return miArma;
	}

	public void setArma(Arma miArma) {
		this.miArma = miArma;
	}

	public String retornarDatosArma() {
		return miArma.toString();
	}

	public String retornarNombreArma() {
		return miArma.getNombre();
	}

	public Armadura getArmadura() {
		return miArmadura;
	}

	public void setArmadura(Armadura miArmadura) {
		this.miArmadura = miArmadura;
	}

	public String retornarDatosArmadura() {
		return miArmadura.toString();
	}

	public String retornarNombreArmadura() {
		return miArmadura.getNombre();
	}

	/**
	 * Este m�todo sobrecargado de la clase padre recibe un enemigo. Determina un
	 * valor intermedio entre el da�o m�ximo y el da�o m�nimo del Arma teniendo en
	 * cuenta la defensa del enemigo si este es un NoHumanoide o la armadura si este
	 * es un Humanoide. Este valor es la cantidad de vida que se le bajar� al
	 * enemigo. Finalmente retorna este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Da�o que se le ocasion� al enemigo.
	 */
	@Override
	public int atacar(Personaje enemigo) {
		int ataque, da�o, defensa = 0, da�oMax, da�oMin;
		da�oMax = miArma.getAtaqueMax();
		da�oMin = miArma.getAtaqueMin();
		da�o = ThreadLocalRandom.current().nextInt(da�oMin, da�oMax + 1);
		if (enemigo != null && enemigo instanceof Humanoide)
			defensa = ((Humanoide) enemigo).getArmadura().getDefensa();
		else if (enemigo != null && enemigo instanceof NoHumanoide)
			defensa = ((NoHumanoide) enemigo).getDefensa();
		float puntosDeAtaque = da�o * da�o / (da�o + defensa);
		ataque = (int) puntosDeAtaque;
		enemigo.recibirDa�o(ataque);
		return ataque;
	}
}