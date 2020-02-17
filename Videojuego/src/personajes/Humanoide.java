package personajes;

import java.util.concurrent.ThreadLocalRandom;
import objetos.Arma;
import objetos.Armadura;

/**
 * Esta clase está incluida en diversas clases, de aquí sale el enemigo Bandido
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
	 * Este método sobrecargado de la clase padre recibe un enemigo. Determina un
	 * valor intermedio entre el daño máximo y el daño mínimo del Arma teniendo en
	 * cuenta la defensa del enemigo si este es un NoHumanoide o la armadura si este
	 * es un Humanoide. Este valor es la cantidad de vida que se le bajará al
	 * enemigo. Finalmente retorna este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Daño que se le ocasionó al enemigo.
	 */
	@Override
	public int atacar(Personaje enemigo) {
		int ataque, daño, defensa = 0, dañoMax, dañoMin;
		dañoMax = miArma.getAtaqueMax();
		dañoMin = miArma.getAtaqueMin();
		daño = ThreadLocalRandom.current().nextInt(dañoMin, dañoMax + 1);
		if (enemigo != null && enemigo instanceof Humanoide)
			defensa = ((Humanoide) enemigo).getArmadura().getDefensa();
		else if (enemigo != null && enemigo instanceof NoHumanoide)
			defensa = ((NoHumanoide) enemigo).getDefensa();
		float puntosDeAtaque = daño * daño / (daño + defensa);
		ataque = (int) puntosDeAtaque;
		enemigo.recibirDaño(ataque);
		return ataque;
	}
}