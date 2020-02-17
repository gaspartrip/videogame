package personajes;

import java.io.Serializable;
import java.util.ArrayList;
import objetos.Arma;
import objetos.Armadura;
import objetos.Bolsa;
import objetos.Pocion;

/**
 * Esta clase está en la clase Mercado. Tiene 3 listas con objetos distintos,
 * representando objetos que el jugador puede comprar. Se almacena en disco ya
 * que si se modifican en modo administrador los objetos de sus listas se
 * necesita su persistencia.
 */
public class Comerciante extends Humanoide implements Serializable {

	private static final long serialVersionUID = 1L;
	private Bolsa<Arma> armas;
	private Bolsa<Armadura> armaduras;
	private Bolsa<Pocion> pociones;
	
	public Comerciante(String nombre, int vidaMax, int vidaActual, Arma miArma, Armadura miArmadura) {
		super(nombre, vidaMax, vidaActual, miArma, miArmadura);
		armas = new Bolsa<Arma>();
		armaduras = new Bolsa<Armadura>();
		pociones = new Bolsa<Pocion>();
	}

	public Comerciante() {
		super();
		armas = new Bolsa<Arma>();
		armaduras = new Bolsa<Armadura>();
		pociones = new Bolsa<Pocion>();
	}

	public String saludar() {
		return "Dime qué necesitas, forastero.";
	}

	public ArrayList<Arma> getArmasComerciante() {
		return armas.retornarLista();
	}

	public ArrayList<Armadura> getArmadurasComerciante() {
		return armaduras.retornarLista();
	}

	public ArrayList<Pocion> getPocionesComerciante() {
		return pociones.retornarLista();
	}

	public boolean existeArma(Arma arma) {
		boolean exito = false;
		if (armas.contiene(arma))
			exito = true;
		return exito;
	}

	/**
	 * Trae un elemento de tipo Arma, a vender. Efectúa la eliminación de dicha arma
	 * de la lista, si la comprobación fue exitosa.
	 * 
	 * @return Retorna un elemento de tipo Arma, a vender al Jugador.
	 */
	public Arma venderArma(Arma arma) {
		Arma armaAVender = null;
		for (Arma e : armas) {
			if (arma == e) {
				armaAVender = e;
				armas.eliminar(e);
				break;
			}
		}
		return armaAVender;
	}

	public boolean existeArmadura(Armadura armadura) {
		boolean exito = false;
		if (armaduras.contiene(armadura))
			exito = true;
		return exito;
	}

	/**
	 * Trae un elemento de tipo Armadura, a vender. Efectúa la eliminación de dicha
	 * armadura de la lista, si la comprobación fue exitosa.
	 * 
	 * @return Retorna un elemento de tipo Armadura, a vender al Jugador.
	 */
	public Armadura venderArmadura(Armadura armadura) {
		Armadura armaduraAVender = null;
		for (Armadura e : armaduras) {
			if (armadura == e) {
				armaduraAVender = e;
				armaduras.eliminar(e);
				break;
			}
		}
		return armaduraAVender;
	}

	public boolean existePocion(Pocion pocion) {
		boolean exito = false;
		if (pociones.contiene(pocion))
			exito = true;
		return exito;
	}

	/**
	 * Trae un elemento de tipo Pocion, a vender. Efectúa la eliminación de dicha
	 * poción de la lista, si la comprobación fue exitosa.
	 * 
	 * @return Retorna un elemento de tipo Pocion, a vender al Jugador.
	 */
	public Pocion venderPocion(Pocion pocion) {
		Pocion pocionAVender = null;
		for (Pocion e : pociones) {
			if (pocion == e) {
				pocionAVender = e;
				pociones.eliminar(e);
				break;
			}
		}
		return pocionAVender;
	}

	public ArrayList<String> retornarDatosInventarioArmaduras() {
		ArrayList<String> datos = new ArrayList<>();
		for (Armadura e : armaduras) {
			datos.add(e.toString());
		}
		return datos;
	}

	public ArrayList<String> retornarDatosInventarioArmas() {
		ArrayList<String> datos = new ArrayList<>();
		for (Arma e : armas) {
			datos.add(e.toString());
		}
		return datos;
	}

	public int retornarCantidadDePociones() {
		return pociones.cantidad();
	}

	public boolean agregarArma(Arma arma) {
		boolean resultado = false;
		if (!armas.contiene(arma)) {
			resultado = true;
			armas.agregar(arma);
		}
		return resultado;
	}

	public boolean quitarArma(Arma arma) {
		boolean resultado = false;
		if (armas.contiene(arma)) {
			resultado = true;
			armas.eliminar(arma);
		}
		return resultado;
	}

	public boolean agregarArmadura(Armadura armadura) {
		boolean resultado = false;
		if (!armaduras.contiene(armadura)) {
			resultado = true;
			armaduras.agregar(armadura);
		}
		return resultado;
	}

	public boolean quitarArmadura(Armadura armadura) {
		boolean resultado = false;
		if (armaduras.contiene(armadura)) {
			resultado = true;
			armaduras.eliminar(armadura);
		}
		return resultado;
	}

	public void agregarPocion() {
		Pocion pocion = new Pocion();
		pociones.agregar(pocion);
	}

	public boolean quitarPocion() {
		boolean resultado = false;
		if (pociones.cantidad() != 0) {
			pociones.eliminar(pociones.cantidad() - 1);
			resultado = true;
		}
		return resultado;
	}
}
