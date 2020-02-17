package personajes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Esta clase contenida en la clase Jugador es la plantilla de las habilidades
 * de ataque que tendrá el mismo. El daño mínimo y máximo determinarán el dañó
 * final que ocasiona la habilidad. También se almacenará un String con el
 * nombre de una clase, la cual si resulta ser la clase del enemigo logrará que
 * se incremente en un un porcentaje el daño final.
 */
@SuppressWarnings("rawtypes")
public class HabilidadDeAtaque extends Habilidad {
	private int dañoMax;
	private int dañoMin;
	private double porcentajeDañoBonus = 40;
	private String claseDañoBonus;

	public HabilidadDeAtaque(String nombre, int dañoMax, int dañoMin, double porcentajeDañoBonus,
			String claseDañoBonus) {
		super(nombre);
		this.dañoMax = dañoMax;
		this.dañoMin = dañoMin;
		this.porcentajeDañoBonus = porcentajeDañoBonus;
		this.claseDañoBonus = claseDañoBonus;
	}

	/**
	 * Este método recibe un enemigo y determina un valor intermedio entre el daño
	 * máximo y el daño mínimo de la clase sin tener en cuenta la defensa del
	 * enemigo. Se comprueba si el enemigo es de la misma clase que la clase
	 * almacenada en los atributos, si esto es así, se incremente el daño. El valor
	 * final es la cantidad de vida que se le bajará al enemigo. Finalmente retorna
	 * este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Daño que se le ocasionó al enemigo.
	 */
	public int usarHabilidad(Personaje enemigo) {
		int daño = 0;
		daño = ThreadLocalRandom.current().nextInt(dañoMin, dañoMax + 1);
		if (enemigo.getNombre().equals(claseDañoBonus)) {
			daño = (int) (daño + ((porcentajeDañoBonus * 0.01) * daño));
		}
		enemigo.recibirDaño(daño);
		return daño;
	}

	public int getDañoMax() {
		return dañoMax;
	}

	public int getDañoMin() {
		return dañoMin;
	}

	public double getPorcentajeDañoBonus() {
		return porcentajeDañoBonus;
	}

	public String getClaseDañoBonus() {
		return claseDañoBonus;
	}

	public void setClaseDañoBonus(String claseDañoBonus) {
		this.claseDañoBonus = claseDañoBonus;
	}
}