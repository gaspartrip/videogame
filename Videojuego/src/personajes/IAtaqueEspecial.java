package personajes;

/**
 * Esta interfaz tiene el m�todo lanzarAtaqueEspecial, que usar�n determinadas
 * clases (enemigos) y que tendr� el efecto de ocasionar un da�o mayor al ataque
 * com�n.
 */
public interface IAtaqueEspecial {
	public int lanzarAtaqueEspecial(Jugador enemigo, int da�oMin, int da�oMax);
}
