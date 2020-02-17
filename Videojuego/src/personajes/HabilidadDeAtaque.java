package personajes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Esta clase contenida en la clase Jugador es la plantilla de las habilidades
 * de ataque que tendr� el mismo. El da�o m�nimo y m�ximo determinar�n el da��
 * final que ocasiona la habilidad. Tambi�n se almacenar� un String con el
 * nombre de una clase, la cual si resulta ser la clase del enemigo lograr� que
 * se incremente en un un porcentaje el da�o final.
 */
@SuppressWarnings("rawtypes")
public class HabilidadDeAtaque extends Habilidad {
	private int da�oMax;
	private int da�oMin;
	private double porcentajeDa�oBonus = 40;
	private String claseDa�oBonus;

	public HabilidadDeAtaque(String nombre, int da�oMax, int da�oMin, double porcentajeDa�oBonus,
			String claseDa�oBonus) {
		super(nombre);
		this.da�oMax = da�oMax;
		this.da�oMin = da�oMin;
		this.porcentajeDa�oBonus = porcentajeDa�oBonus;
		this.claseDa�oBonus = claseDa�oBonus;
	}

	/**
	 * Este m�todo recibe un enemigo y determina un valor intermedio entre el da�o
	 * m�ximo y el da�o m�nimo de la clase sin tener en cuenta la defensa del
	 * enemigo. Se comprueba si el enemigo es de la misma clase que la clase
	 * almacenada en los atributos, si esto es as�, se incremente el da�o. El valor
	 * final es la cantidad de vida que se le bajar� al enemigo. Finalmente retorna
	 * este valor por si es de utilidad para mostrarlo.
	 * 
	 * @return Da�o que se le ocasion� al enemigo.
	 */
	public int usarHabilidad(Personaje enemigo) {
		int da�o = 0;
		da�o = ThreadLocalRandom.current().nextInt(da�oMin, da�oMax + 1);
		if (enemigo.getNombre().equals(claseDa�oBonus)) {
			da�o = (int) (da�o + ((porcentajeDa�oBonus * 0.01) * da�o));
		}
		enemigo.recibirDa�o(da�o);
		return da�o;
	}

	public int getDa�oMax() {
		return da�oMax;
	}

	public int getDa�oMin() {
		return da�oMin;
	}

	public double getPorcentajeDa�oBonus() {
		return porcentajeDa�oBonus;
	}

	public String getClaseDa�oBonus() {
		return claseDa�oBonus;
	}

	public void setClaseDa�oBonus(String claseDa�oBonus) {
		this.claseDa�oBonus = claseDa�oBonus;
	}
}