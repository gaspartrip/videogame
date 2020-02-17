package personajes;

/**
 * Esta interfaz tiene el método lanzarAtaqueEspecial, que usarán determinadas
 * clases (enemigos) y que tendrá el efecto de ocasionar un daño mayor al ataque
 * común.
 */
public interface IAtaqueEspecial {
	public int lanzarAtaqueEspecial(Jugador enemigo, int dañoMin, int dañoMax);
}
