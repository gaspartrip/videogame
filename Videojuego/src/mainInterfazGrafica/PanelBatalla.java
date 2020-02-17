package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import personajes.IAtaqueEspecial;
import personajes.HabilidadDeAtaque;
import personajes.Jugador;
import personajes.Nigromante;
import personajes.NoHumanoide;
import personajes.Personaje;

/**
 * Esta clase contiene el panel de batalla del jugador. Desde acá se llaman a
 * los métodos correspondientes de cada clase, y se muestran mensajes por
 * pantalla según los valores que retornana estos métodos. Siempre se trabaja
 * con la clase Jugador y con una clase que actuará de enemigo.
 */
@SuppressWarnings("rawtypes")
public class PanelBatalla extends JPanelPadre implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanelPadre panelSiguiente = null;
	private JPanelPadre panelAnterior = null;
	private JTextPane areaCentral;
	private StyledDocument doc;
	private JTextField hudNombreEnemigo;
	private JTextField hudVidaTotalEnemigo;
	private JTextField hudPocionesTotal;
	private JButton botonAtacar;
	private JButton botonHabilidad;
	private JButton botonHuir;
	private JButton botonCurarse;
	private String posicion = "";
	private final static String c1 = "c1";
	private final static String c2 = "c2";
	private final static String c3 = "c3";
	private final static String c4 = "c4";
	private JLabel fotoBatalla;
	private JLabel ataque;
	private JLabel habilidad;
	private JLabel huir;
	private JLabel pocion;
	private boolean huida = true;
	private Jugador jugador;
	private Personaje enemigo = null;

	public PanelBatalla(FramePrincipal principal) {
		super(principal);

		jugador = getPrincipal().retornarJugador();

		setBackground(Color.BLACK);
		setLayout(null);

		// Area central va el registro de la batalla

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(95, 81, 614, 131);
		doc = areaCentral.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		add(areaCentral);

		// Hud que señala la cantidad de pociones

		hudPocionesTotal = new JTextField();
		hudPocionesTotal.setText("0");
		hudPocionesTotal.setHorizontalAlignment(SwingConstants.CENTER);
		hudPocionesTotal.setForeground(Color.WHITE);
		hudPocionesTotal.setEditable(false);
		hudPocionesTotal.setColumns(10);
		hudPocionesTotal.setBackground(Color.BLACK);
		hudPocionesTotal.setBounds(584, 437, 55, 20);
		add(hudPocionesTotal);

		// Hud con el nombre del enemigo

		hudNombreEnemigo = new JTextField();
		hudNombreEnemigo.setText((String) null);
		hudNombreEnemigo.setHorizontalAlignment(SwingConstants.CENTER);
		hudNombreEnemigo.setForeground(Color.WHITE);
		hudNombreEnemigo.setEditable(false);
		hudNombreEnemigo.setColumns(10);
		hudNombreEnemigo.setBackground(Color.BLACK);
		hudNombreEnemigo.setBounds(224, 223, 242, 20);
		add(hudNombreEnemigo);

		JLabel vidaTotalEnemigo = new JLabel(new ImageIcon(PanelBatalla.class.getResource("/resources/images/hp.jpg")));
		vidaTotalEnemigo.setBounds(476, 217, 32, 31);
		add(vidaTotalEnemigo);

		// Hud con la vida del enemigo

		hudVidaTotalEnemigo = new JTextField();
		hudVidaTotalEnemigo.setText("0");
		hudVidaTotalEnemigo.setHorizontalAlignment(SwingConstants.CENTER);
		hudVidaTotalEnemigo.setForeground(Color.WHITE);
		hudVidaTotalEnemigo.setEditable(false);
		hudVidaTotalEnemigo.setColumns(10);
		hudVidaTotalEnemigo.setBackground(Color.BLACK);
		hudVidaTotalEnemigo.setBounds(518, 223, 55, 20);
		add(hudVidaTotalEnemigo);

		// Imagenes/iconos complementarios a los botones

		fotoBatalla = new JLabel(new ImageIcon(PanelBatalla.class.getResource("/resources/images/atacar.jpg")));
		fotoBatalla.setBounds(106, 259, 592, 167);
		add(fotoBatalla);

		ataque = new JLabel(new ImageIcon(PanelBatalla.class.getResource("/resources/images/atacar.jpg")));
		ataque.setBounds(222, 455, 32, 31);
		add(ataque);

		habilidad = new JLabel(new ImageIcon(PanelBatalla.class.getResource("/resources/images/habilidad.jpg")));
		habilidad.setBounds(369, 455, 32, 31);
		add(habilidad);

		huir = new JLabel(new ImageIcon(PanelBatalla.class.getResource("/resources/images/huir.jpg")));
		huir.setBounds(516, 455, 32, 31);
		add(huir);

		pocion = new JLabel(new ImageIcon(PanelBatalla.class.getResource("/resources/images/pocion.jpg")));
		pocion.setBounds(666, 455, 32, 31);
		add(pocion);

		// Botones

		botonAtacar = new JButton("Atacar");
		botonAtacar.setBackground(Color.WHITE);
		botonAtacar.setForeground(Color.BLACK);
		botonAtacar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonAtacar.setBounds(117, 455, 107, 31);
		botonAtacar.setActionCommand(c1);
		botonAtacar.addActionListener(this);
		add(botonAtacar);

		botonHabilidad = new JButton("Habilidad");
		botonHabilidad.setForeground(Color.BLACK);
		botonHabilidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonHabilidad.setBackground(Color.WHITE);
		botonHabilidad.setBounds(264, 455, 107, 31);
		botonHabilidad.setActionCommand(c2);
		botonHabilidad.addActionListener(this);
		add(botonHabilidad);

		botonHuir = new JButton("Huir");
		botonHuir.setForeground(Color.BLACK);
		botonHuir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonHuir.setBackground(Color.WHITE);
		botonHuir.setBounds(411, 455, 107, 31);
		botonHuir.setActionCommand(c3);
		botonHuir.addActionListener(this);
		add(botonHuir);

		botonCurarse = new JButton("Curarse");
		botonCurarse.setForeground(Color.BLACK);
		botonCurarse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonCurarse.setBackground(Color.WHITE);
		botonCurarse.setBounds(558, 455, 107, 31);
		botonCurarse.setActionCommand(c4);
		botonCurarse.addActionListener(this);
		add(botonCurarse);
	}

	/**
	 * Actualiza el HUD exclusivo del panel de batalla (nombre del enemigo, vida del
	 * enemigo, cantidad de pociones, etc).
	 */
	public void cargarHudDeBatalla(String direccion, Personaje enemigo) {
		this.enemigo = enemigo;
		jugador = getPrincipal().retornarJugador();
		fotoBatalla.setIcon(new ImageIcon(PanelBatalla.class.getResource(direccion)));
		hudNombreEnemigo.setText(enemigo.getNombre());
		hudVidaTotalEnemigo.setText(String.valueOf(enemigo.getVidaActual()));
		int cantidadDePociones = jugador.retornarCantidadDePociones();
		hudPocionesTotal.setText(String.valueOf(cantidadDePociones));
		cargarHudSinInventario();
	}

	public void cargarPanelSiguienteYAnterior(JPanelPadre panelSiguiente, JPanelPadre panelAnterior) {
		this.panelSiguiente = panelSiguiente;
		this.panelAnterior = panelAnterior;
	}

	public void cargarPanelSiguiente(JPanelPadre panelSiguiente) {
		this.panelSiguiente = panelSiguiente;
	}

	private void cargarVidaEnemigo() {
		hudVidaTotalEnemigo.setText(String.valueOf(enemigo.getVidaActual()));
	}

	private String getNombreEnemigo() {
		return enemigo.getNombre();
	}

	public void activarHuir() {
		botonHuir.setVisible(true);
		huir.setVisible(true);
	}

	private void desactivarBotones() {
		botonHabilidad.setVisible(false);
		botonHuir.setVisible(false);
		botonCurarse.setVisible(false);
		ataque.setVisible(false);
		habilidad.setVisible(false);
		huir.setVisible(false);
		pocion.setVisible(false);
		hudPocionesTotal.setVisible(false);
	}

	private void activarBotonesSinHuir() {
		botonHuir.setVisible(true);
		botonCurarse.setVisible(true);
		ataque.setVisible(true);
		pocion.setVisible(true);
		hudPocionesTotal.setVisible(true);
	}

	public void batalla() // Con huida
	{
		activacionBatallas();
		botonHuir.setText("Huir");
		botonHuir.setVisible(true);
		huir.setVisible(true);
		huida = true;
	}

	public void batallaSinHuir() // Sin huida
	{
		activacionBatallas();
		botonHuir.setVisible(false);
		huir.setVisible(false);
		huida = false;
	}

	public void activacionBatallas() // Funciones en comun para batalla y batallarSinHuir
	{
		activarBotonesSinHuir();
		desactivarBotonInventario();
		if (!jugador.habilidadActiva()) {
			botonHabilidad.setVisible(true);
			habilidad.setVisible(true);
		}
		posicion = "batalla";
		areaCentral.setText("¿Qué harás?");
		botonAtacar.setText("Atacar");
		botonHabilidad.setText("Habilidad");
		;
		botonCurarse.setText("Curarse");
	}

	/**
	 * Método que usa el atacar del Jugador y muestra el valor devuelto (el daño que
	 * se le causó al enemigo).
	 */
	private void ataqueDelJugador() {
		getPrincipal().reproducirSonidoAtacar();
		posicion = "ataqueDelJugador";
		int ataque = jugador.atacar(enemigo);
		areaCentral.setText("Atacaste a |" + enemigo.getNombre() + "| y le ocasionaste " + ataque + " de daño");
		cargarVidaEnemigo();
		desactivarBotones();
		botonAtacar.setText(">");
	}

	/**
	 * Método que usa el atacar del enemigo y muestra el valor devuelto (el daño que
	 * se le causó al Jugador). Se usa una probabilidad para determinar si el
	 * enemigo usará un atacar común o su ataque especial (si lo tiene). También se
	 * chequea si el Jugador tiene activa algúna habilidad de defensa que disminuya
	 * el daño ocasionado.
	 */
	@SuppressWarnings("unchecked")
	private void ataqueDelEnemigo() {
		getPrincipal().reproducirSonidoAtacar();
		posicion = "ataqueDelEnemigo";
		String mensaje = "";
		int dañoEnemigo = 0;

		double x = Math.random();
		if (x > 0.4) {
			dañoEnemigo = enemigo.atacar(jugador);
			mensaje = mensaje + "|" + enemigo.getNombre() + "| te atacó y te ocasionó " + dañoEnemigo + " de daño";
		} else {
			if (enemigo instanceof IAtaqueEspecial) {
				String ataqueEspecial = "";
				if (enemigo instanceof NoHumanoide) {
					ataqueEspecial = ((NoHumanoide) enemigo).getNombreAtaqueEspecial();
					if (enemigo.getNombre() == "Dragón") {
						dañoEnemigo = ((IAtaqueEspecial) enemigo).lanzarAtaqueEspecial(jugador, 40, 70);
					} else {
						dañoEnemigo = ((IAtaqueEspecial) enemigo).lanzarAtaqueEspecial(jugador, 10, 20);
					}
				} else if (enemigo instanceof Nigromante) {
					ataqueEspecial = ((Nigromante) enemigo).getNombreAtaqueEspecial();
					dañoEnemigo = ((IAtaqueEspecial) enemigo).lanzarAtaqueEspecial(jugador, 15, 25);
				}
				mensaje = mensaje + "|" + enemigo.getNombre() + "| usó |" + ataqueEspecial + "| y te ocasionó "
						+ dañoEnemigo + " de daño";
			} else {
				dañoEnemigo = enemigo.atacar(jugador);
				mensaje = mensaje + "|" + enemigo.getNombre() + "| te atacó y te ocasionó " + dañoEnemigo + " de daño";
			}
		}

		if (jugador.habilidadActiva()) {
			if (jugador.getTurnosRestantesHabilidad() != 0) {
				jugador.setTurnosRestantesHabilidad(jugador.getTurnosRestantesHabilidad() - 1);
			} else {
				jugador.setHabilidadActiva(false);
				if (jugador.getHabilidadDeDefensa().isActiva()) {
					jugador.getHabilidadDeDefensa().setActiva(false);
					mensaje = "|" + jugador.getHabilidadDeDefensa().getNombre() + "| ha desaparecido. " + mensaje;
				}
			}
		}

		areaCentral.setText(mensaje);
		cargarHudVida();
		desactivarBotones();
		botonAtacar.setText(">");
	}

	/**
	 * Método que se llama para que el Jugador use su habilidad de ataque. Reproduce
	 * sonidos y muestra el daño ocasionado.
	 * 
	 * @param Se trae por parámetro el ID correspondiente a la habilidad de ataque.
	 */
	public void usarHabilidadDeAtaque(int id) {
		posicion = "ataqueDelJugador";
		HabilidadDeAtaque habilidadDeAtaque = jugador.getHabilidadDeAtaque(id);
		int daño = habilidadDeAtaque.usarHabilidad(enemigo);
		{
			switch (id) {
			case 1:
				getPrincipal().reproducirSonidoBolaDeFuego();
				break;
			case 2:
				getPrincipal().reproducirSonidoNovaDeEscarcha();
				break;
			case 3:
				getPrincipal().reproducirSonidoGolpeDeCruzado();
				break;
			}
		}
		areaCentral.setText("Atacaste con |" + habilidadDeAtaque.getNombre() + "| a |" + getNombreEnemigo()
				+ "| y le ocasionaste " + daño + " de daño");
		cargarVidaEnemigo();
		desactivarBotones();
		botonAtacar.setText(">");
	}

	/**
	 * Método que se llama para que el Jugador use su habilidad de defensa.
	 * Reproduce sonidos y muestra mensaje.
	 */
	public void usarHabilidadDeDefensa() {
		getPrincipal().reproducirSonidoBarreraDivina();
		posicion = "ataqueDelJugador";
		jugador.getHabilidadDeDefensa().setActiva(true);
		jugador.setTurnosRestantesHabilidad(jugador.getTurnosHabilidad());
		areaCentral.setText(
				"Invocaste |" + jugador.getHabilidadDeDefensa().getNombre() + "|. Te protegerá durante dos ataques");
		desactivarBotones();
		botonAtacar.setText(">");
	}

	/**
	 * Método que se llama al presionar el botón de Habilidad. Desde aquí se pasa al
	 * panel de habilidades.
	 */
	private void habilidad() {
		jugador.setTurnosRestantesHabilidad(jugador.getTurnosHabilidad());
		jugador.setHabilidadActiva(true);
		botonHabilidad.setVisible(false);
		habilidad.setVisible(false);
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel0BatallaHabilidades());
	}

	public void setearHudPanelHabilidadesAlPanelDeBatallaSinElegirHabilidad() {
		jugador.setHabilidadActiva(false);
		botonHabilidad.setVisible(true);
		habilidad.setVisible(true);
	}

	/**
	 * Reinicia el enemigo, es decir, su vida actual pasa a ser su vida máxima. Se
	 * usa cuando huís de un enemigo o cuando lo matas. Importante para un respawn
	 * constante de enemigos.
	 */
	private void reiniciarEnemigo() {
		if (jugador.habilidadActiva())
			jugador.setHabilidadActiva(false);
		if (jugador.getHabilidadDeDefensa().isActiva())
			jugador.getHabilidadDeDefensa().setActiva(false);
		enemigo.setVidaActual(enemigo.getVidaMax()); //
		cargarVidaEnemigo(); // Hay que pasar el dato al hud
	}

	/**
	 * Vuelve al panel (zona) anterior.
	 */
	private void huir() {
		getPrincipal().pausarCancionBatalla();
		getPrincipal().reproducirCancionPrincipal();
		getPrincipal().intercambiarPaneles(panelAnterior);
	}

	/**
	 * Método que aumenta la salud del Jugador y actualiza el HUD con el valor
	 * nuevo. También reproduce un sonido. Si no se pudo beber la poción muestra los
	 * mensajes correspondientes por pantalla.
	 */
	private void beberPocion() {
		if (jugador.beberPocion()) {
			getPrincipal().reproducirSonidoPocion();
			hudPocionesTotal.setText(String.valueOf(jugador.retornarCantidadDePociones()));
			areaCentral.setText("Bebiste poción");
			cargarHudVida();
			desactivarBotones();
			botonAtacar.setText(">");
			posicion = "beberPocion";
		} else {
			if (jugador.retornarCantidadDePociones() == 0)
				JOptionPane.showMessageDialog(null, "No tienes pociones", "Beber poción", JOptionPane.WARNING_MESSAGE);
			else if (jugador.vidaAlMaximo())
				JOptionPane.showMessageDialog(null, "Tienes la vida al máximo", "Beber poción",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Método que según el nombre del enemigo derrotado asigna X cantidad de oro y
	 * determinados sonidos. También muestra por pantalla el mensaje correspondiente
	 * ("Enemigo derrotado (..)).
	 */
	private void ganar() {
		posicion = "ganar";
		getPrincipal().pausarCancionBatalla();
		String mensaje;
		if (enemigo.getNombre().equals("Dragón")) {
			mensaje = "¡|" + getNombreEnemigo() + "| derrotado!";
			getPrincipal().reproducirSonidoMuerteDragon();
			fotoBatalla.setIcon(
					new ImageIcon(PanelBatalla.class.getResource("/resources/images/enemigo-dragon-muerto.jpg")));
		} else {
			int oroGanado = 0;
			if (enemigo.getNombre().equals("No-muerto")) {
				oroGanado = getPrincipal().retornarTemplo().getOroRecibidoNoMuerto();
			} else {
				oroGanado = getPrincipal().getJuego().getOroGanado();
			}
			getPrincipal().reproducirCancionPrincipal();
			mensaje = "|" + getNombreEnemigo() + "| derrotado. ¡Has ganado! [+" + oroGanado + " oro]";
			jugador.aumentarOro(oroGanado);
		}
		areaCentral.setText(mensaje);
		jugador.setEnemigosEliminados(jugador.getEnemigosEliminados() + 1);
		cargarHud();
		desactivarBotones();
		botonAtacar.setText(">");
		repaint();
		revalidate();
	}

	private void avanzarAlSiguientePanel() {
		getPrincipal().intercambiarPaneles(panelSiguiente);
	}

	/**
	 * Al morir se pasa a un panel que muestra un gif ("You died").
	 */
	private void morir() {
		getPrincipal().intercambiarABatallaMuerte();
	}

	/**
	 * Según el botón presionado y el valor de String estado se llama X método.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (posicion) {
		case "batalla":
			if (e.getActionCommand().equals(c1)) {
				ataqueDelJugador();
			} else if (e.getActionCommand().equals(c2)) {
				habilidad();
			} else if (e.getActionCommand().equals(c3)) {
				huir();
				reiniciarEnemigo();
			} else if (e.getActionCommand().equals(c4)) {
				beberPocion();
			}
			break;
		case "ataqueDelJugador":
		case "beberPocion":
			if (e.getActionCommand().equals(c1)) {
				if (enemigo.getVidaActual() < 1) {
					ganar();
				} else {
					ataqueDelEnemigo();
				}
			}
			break;
		case "ataqueDelEnemigo":
			if (e.getActionCommand().equals(c1)) {
				if (jugador.getVidaActual() < 1) {
					morir();
				} else {
					if (huida) {
						batalla();
					} else
						batallaSinHuir();
				}
			}
			break;
		case "ganar":
			if (e.getActionCommand().equals(c1)) {
				if (enemigo.getNombre().equals("Dragón")) {
					jugador.setMomentoFinal(System.nanoTime());
					getPrincipal().getPanel14Final().cargarJugador(jugador);
					getPrincipal().intercambiarPaneles(getPrincipal().getPanel14Final());
				} else {
					avanzarAlSiguientePanel();
					reiniciarEnemigo();
				}
			}
			break;
		}
	}
}