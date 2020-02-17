package personajes;

import java.util.ArrayList;
import java.util.HashMap;
import objetos.Arma;
import objetos.Armadura;
import objetos.Bolsa;
import objetos.Pocion;

/**
 * Esta clase representa al jugador principal del juego. Contiene atributos y
 * métodos específicos del mismo, muchos de los cuales se usarán como
 * estadísticas.
 */
public class Jugador extends Humanoide {

	private int oro = 200;
	private boolean habilidadActiva = false;
	private final int turnosHabilidad = 2;
	private int turnosRestantesHabilidad;
	private Bolsa<Arma> armas;
	private Bolsa<Armadura> armaduras;
	private Bolsa<Pocion> pociones;
	private HashMap<Integer, HabilidadDeAtaque> habilidadesDeAtaque;
	private HabilidadDeDefensa habilidadDeDefensa;
	private int enemigosEliminados = 0;
	private String fechaDeInicio;
	private long momentoInicio; // En nanosegundos
	private long momentoFinal; // En nanosegundos
	private int pocionesBebidas = 0;
	private int armasCompradas = 0;
	private int armadurasCompradas = 0;
	private int pocionesCompradas = 0;
	private int cantidadDeOroTotalJuntado = oro;

	public Jugador() {
		super();
	}

	public Jugador(String nombre, int vidaMax, int vidaActual, Arma miArma, Armadura miArmadura) {
		super(nombre, vidaMax, vidaActual, miArma, miArmadura);
		armas = new Bolsa<Arma>();
		armaduras = new Bolsa<Armadura>();
		pociones = new Bolsa<Pocion>();
		habilidadesDeAtaque = new HashMap<Integer, HabilidadDeAtaque>();
		agregarArmaAlInventario(getArma());
		agregarArmaduraAlInventario(getArmadura());
		crearYAgregarHabilidades();
	}

	public Jugador(String nombre, int vidaMax, int vidaActual) {
		super(nombre, vidaMax, vidaActual);
		armas = new Bolsa<Arma>();
		armaduras = new Bolsa<Armadura>();
		pociones = new Bolsa<Pocion>();
		habilidadesDeAtaque = new HashMap<Integer, HabilidadDeAtaque>();
		agregarArmaAlInventario(getArma());
		agregarArmaduraAlInventario(getArmadura());
		agregarPocionesAlInventario();
		crearYAgregarHabilidades();
	}

	public int getOro() {
		return oro;
	}

	public void aumentarOro(int oro) {
		cantidadDeOroTotalJuntado += oro;
		this.oro += oro;
	}

	public void disminuirOro(int oro) {
		this.oro -= oro;
	}

	public boolean habilidadActiva() {
		return habilidadActiva;
	}

	public void setHabilidadActiva(boolean habilidadActiva) {
		this.habilidadActiva = habilidadActiva;
	}

	public int getTurnosHabilidad() {
		return turnosHabilidad;
	}

	public int getTurnosRestantesHabilidad() {
		return turnosRestantesHabilidad;
	}

	public void setTurnosRestantesHabilidad(int turnosRestantesHabilidad) {
		this.turnosRestantesHabilidad = turnosRestantesHabilidad;
	}

	public ArrayList<Arma> getArmas() {
		return armas.retornarLista();
	}

	public ArrayList<Armadura> getArmaduras() {
		return armaduras.retornarLista();
	}

	public HashMap<Integer, HabilidadDeAtaque> getHabilidadesDeAtaque() {
		return habilidadesDeAtaque;
	}

	public HabilidadDeAtaque getHabilidadDeAtaque(int id) {
		return habilidadesDeAtaque.get(id);
	}

	public HabilidadDeDefensa getHabilidadDeDefensa() {
		return habilidadDeDefensa;
	}

	public void setHabilidadDeDefensa(HabilidadDeDefensa habilidadDeDefensa) {
		this.habilidadDeDefensa = habilidadDeDefensa;
	}

	public String getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public long getMomentoInicio() {
		return momentoInicio;
	}

	public void setMomentoInicio(long momentoInicio) {
		this.momentoInicio = momentoInicio;
	}

	public long getMomentoFinal() {
		return momentoFinal;
	}

	public void setMomentoFinal(long momentoFinal) {
		this.momentoFinal = momentoFinal;
	}

	public int getEnemigosEliminados() {
		return enemigosEliminados;
	}

	public void setEnemigosEliminados(int enemigosEliminados) {
		this.enemigosEliminados = enemigosEliminados;
	}

	public int getPocionesBebidas() {
		return pocionesBebidas;
	}

	public int getArmasCompradas() {
		return armasCompradas;
	}

	public int getArmadurasCompradas() {
		return armadurasCompradas;
	}

	public int getPocionesCompradas() {
		return pocionesCompradas;
	}

	public int getCantidadDeOroTotalJuntado() {
		return cantidadDeOroTotalJuntado;
	}

	/**
	 * Agrega un elemento de tipo Arma a la lista/inventario. Solo se usa en los
	 * constructores, por eso el acceso privado.
	 * 
	 * @param arma Recibe un elemento de tipo Arma a agregar a la lista.
	 */
	private void agregarArmaAlInventario(Arma arma) {
		armas.agregar(arma);
	}

	/**
	 * Agrega un elemento de tipo Armadura a la lista/inventario. Solo se usa en los
	 * constructores, por eso el acceso privado.
	 * 
	 * @param arma Recibe un elemento de tipo Armadura a agregar a la lista.
	 */
	private void agregarArmaduraAlInventario(Armadura armadura) {
		armaduras.agregar(armadura);
	}

	/**
	 * Agrega un elemento de tipo HabilidadJugador a la lista. Solo se usa en los
	 * constructores, por eso el acceso privado.
	 * 
	 * @param arma Recibe un elemento de tipo HabilidadJugador a agregar a la lista.
	 */
	private void agregarHabilidadALaLista(int id, HabilidadDeAtaque habilidad) {
		habilidadesDeAtaque.put(id, habilidad);
	}

	/**
	 * Agrega pociones al inventario, para tener X cantidad de pociones al iniciar
	 * el juego.
	 * 
	 */
	private void agregarPocionesAlInventario() {
		/**
		 * Cantidad de pociones con las que se empieza.
		 */
		int u = 5;
		for (int i = 0; i < u; i++) {
			Pocion pocion = new Pocion();
			pociones.agregar(pocion);
		}
	}

	/**
	 * Crea las habilidades del jugador y las agrega a las listas y atributos
	 * correspondientes.
	 */
	private void crearYAgregarHabilidades() {
		HabilidadDeAtaque bolaDeFuego = new HabilidadDeAtaque("Bola de fuego", 30, 15, 20, "Araña gigante");
		HabilidadDeAtaque novaDeEscarcha = new HabilidadDeAtaque("Nova de escarcha", 35, 10, 30, "Dragón");
		HabilidadDeAtaque golpeDeCruzado = new HabilidadDeAtaque("Golpe de cruzado", 30, 10, 40, "Nigromante");
		HabilidadDeDefensa barreraDivina = new HabilidadDeDefensa("Barrera divina", 0.4);
		agregarHabilidadALaLista(1, bolaDeFuego);
		agregarHabilidadALaLista(2, novaDeEscarcha);
		agregarHabilidadALaLista(3, golpeDeCruzado);
		this.habilidadDeDefensa = barreraDivina;
	}

	/**
	 * Trae dos elementos, uno de tipo Comerciante y otro de tipo Arma, objeto a
	 * comprar y realiza las comprobaciones correspondientes.
	 * 
	 * @return Retorna true si se pudo efectuar la compra del arma o false si
	 *         ocurrió la contrario, ya sea por falta de oro o inexistencia del arma
	 *         por algún motivo.
	 */
	public boolean comprarArma(Comerciante comerciante, Arma arma) {
		boolean exito = false;
		if (arma.getValor() <= getOro() && validarCompraArma(comerciante, arma)) {
			armasCompradas += 1;
			exito = true;
		}
		return exito;
	}

	/**
	 * Método que sirve de complemento al método comprarArma. Efectúa la compra del
	 * arma y realiza la disminución de oro del jugador y la eliminación del arma
	 * comprada en el inventario del Comerciante.
	 * 
	 * @return Retorna true si se pudo efectuar la compra, o false en caso
	 *         contrario.
	 */
	private boolean validarCompraArma(Comerciante comerciante, Arma arma) {
		boolean exito = false;
		if (comerciante != null) {
			if (comerciante.existeArma(arma)) {
				armas.agregar(comerciante.venderArma(arma));
				disminuirOro(arma.getValor());
				exito = true;
			}
		}
		return exito;
	}

	/**
	 * Trae dos elementos, uno de tipo Comerciante y otro de tipo Armadura, objeto a
	 * comprar y realiza las comprobaciones correspondientes.
	 * 
	 * @return Retorna true si se pudo efectuar la compra de la armadura o false si
	 *         ocurrió la contrario, ya sea por falta de oro o inexistencia de la
	 *         armadura por algún motivo.
	 */
	public boolean comprarArmadura(Comerciante comerciante, Armadura armadura) {
		boolean exito = false;
		if (armadura.getValor() <= getOro() && validarCompraArmadura(comerciante, armadura)) {
			armadurasCompradas += 1;
			exito = true;
		}
		return exito;
	}

	/**
	 * Método que sirve de complemento al método comprarArmadura. Efectúa la compra
	 * de la armadura y realiza la disminución de oro del jugador y la eliminación
	 * de la armadura comprada en el inventario del Comerciante.
	 * 
	 * @return Retorna true si se pudo efectuar la compra, o false en caso
	 *         contrario.
	 */
	private boolean validarCompraArmadura(Comerciante comerciante, Armadura armadura) {
		boolean exito = false;
		if (comerciante != null) {
			if ((comerciante).existeArmadura(armadura)) {
				armaduras.agregar(comerciante.venderArmadura(armadura));
				disminuirOro(armadura.getValor());
				exito = true;
			}
		}
		return exito;
	}

	/**
	 * Trae dos elementos, uno de tipo Comerciante y otro de tipo Pocion, objeto a
	 * comprar y realiza las comprobaciones correspondientes.
	 * 
	 * @return Retorna true si se pudo efectuar la compra de la Pocion o false si
	 *         ocurrió la contrario, ya sea por falta de oro o inexistencia de la
	 *         Pocion por algún motivo.
	 */
	public boolean comprarPocion(Comerciante comerciante, Pocion pocion) {
		boolean exito = false;
		if (pocion.getValor() <= getOro() && validarCompraPocion(comerciante, pocion)) {
			pocionesCompradas += 1;
			exito = true;
		}
		return exito;
	}

	/**
	 * Método que sirve de complemento al método comprarPocion. Efectúa la compra de
	 * la poción y realiza la disminución de oro del jugador y la eliminación de la
	 * poción comprada en el inventario del Comerciante.
	 * 
	 * @return Retorna true si se pudo efectuar la compra, o false en caso
	 *         contrario.
	 */
	private boolean validarCompraPocion(Comerciante comerciante, Pocion pocion) {
		boolean exito = false;
		if (comerciante != null) {
			if (comerciante.existePocion(pocion)) {
				pociones.agregar(comerciante.venderPocion(pocion));
				disminuirOro(pocion.getValor());
				exito = true;
			}
		}
		return exito;
	}

	/**
	 * Método que sirve para validar si se puede beber o no una poción, según la
	 * vida actual.
	 * 
	 * @return Retorna true si se pudo beber la poción, o false en caso contrario.
	 */
	public boolean beberPocion() {
		boolean exito = false;
		if (hayPociones()) {
			int pos = pociones.cantidad() - 1;
			if (!vidaAlMaximo()) // comprueba que la vida actual no sea la maxima
			{
				if (getVidaActual() + pociones.retornarObjeto(pos).getCura() > getVidaMax()) // Comprueba que la vida no supere a
																					// la vida max
				{
					setVidaActual(getVidaMax());
					pociones.eliminar(pociones.retornarObjeto(pos)); // remuevo la pocion utilizada del ArrayList
					pocionesBebidas += 1;
					exito = true;
				} else {
					setVidaActual(getVidaActual() + pociones.retornarObjeto(0).getCura()); // Le suma a la vida la cantidad de vida
																				// que recupera la pocion
					pociones.eliminar(pociones.retornarObjeto(pos)); // remuevo la pocion utilizada del ArrayList
					exito = true;
					pocionesBebidas += 1;
				}
			}
		}
		return exito;
	}

	/**
	 * Si hay sufiente oro se puede dormir en la posada y recuperar la salud al
	 * máximo.
	 * 
	 * @param Trae por parametro el precio que sale dormir en la posada.
	 * @return Return true si se pudo dormir, o false si no se pudo al no haber
	 *         suficiente oro.
	 */
	public boolean dormirEnLaPosada(int precioPosada) {
		boolean resultado = false;
		if (getOro() >= precioPosada) {
			setearVidaAlMaximo();
			disminuirOro(precioPosada);
			resultado = true;
		}
		return resultado;
	}

	public boolean vidaAlMaximo() {
		boolean exito;
		if (getVidaActual() != getVidaMax())
			exito = false;
		else
			exito = true;
		return exito;
	}

	public boolean hayPociones() {
		boolean exito;
		if (pociones.cantidad() != 0)
			exito = true;
		else
			exito = false;
		return exito;
	}

	public ArrayList<String> retornarDatosArmaduras() {
		ArrayList<String> datos = new ArrayList<>();
		for (Armadura e : armaduras) {
			datos.add(e.toString());
		}
		return datos;
	}

	public ArrayList<String> retornarDatosArmas() {
		ArrayList<String> datos = new ArrayList<>();
		for (Arma e : armas) {
			datos.add(e.toString());
		}
		return datos;
	}

	public void equiparArma(Arma armaAEquipar) {
		setArma(armaAEquipar);
	}

	public void equiparArmadura(Armadura armaduraAEquipar) {
		setArmadura(armaduraAEquipar);
	}

	public int retornarCantidadDePociones() {
		return pociones.cantidad();
	}

	public void aumentarPociones(int x) {
		for (int i = 0; i < x; i++)
			pociones.agregar(new Pocion());
	}

	public void setearVidaAlMaximo() {
		setVidaActual(getVidaMax());
	}
}