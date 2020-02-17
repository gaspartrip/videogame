package personajes;

/**
 * Esta clase contenida en la clase Jugador es la plantilla de la habilidad de
 * defensa que tendrá el mismo. Contendrá un atributo con el porcentaje del daño
 * recibido que se absorverá.
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
	 * Este método recibe el daño ocasionado por el enemigo y lo reduce en base al
	 * atributo porcentajeAtaqueRecibido. Finalmente retorna el daño final.
	 * 
	 * @return Daño que se absorverá del enemigo.
	 */
	public int retornarDañoReducido(int dañoEnemigo) {
		return (int) (dañoEnemigo - (dañoEnemigo * porcentajeAtaqueAbsorbido));
	}
}