package personajes;

/**
 * Esta clase contenida en la clase Jugador es la plantilla de la habilidad de
 * defensa que tendr� el mismo. Contendr� un atributo con el porcentaje del da�o
 * recibido que se absorver�.
 */
public class HabilidadDeDefensa extends Habilidad {
	private boolean activa = false;
	private double porcentajeAtaqueAbsorbido;

	public HabilidadDeDefensa(String nombre, double porcentajeAtaqueAbsorbido) {
		super(nombre);
		this.porcentajeAtaqueAbsorbido = porcentajeAtaqueAbsorbido;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public double getPorcentajeAtaqueAbsorbido() {
		return porcentajeAtaqueAbsorbido;
	}

	public void setPorcentajeAtaqueAbsorbido(double defensa) {
		this.porcentajeAtaqueAbsorbido = defensa;
	}

	/**
	 * Este m�todo recibe el da�o ocasionado por el enemigo y lo reduce en base al
	 * atributo porcentajeAtaqueRecibido. Finalmente retorna el da�o final.
	 * 
	 * @return Da�o que se absorver� del enemigo.
	 */
	public int retornarDa�oReducido(int da�oEnemigo) {
		return (int) (da�oEnemigo - (da�oEnemigo * porcentajeAtaqueAbsorbido));
	}
}