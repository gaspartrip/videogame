package mainInterfazGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import juegoYZonas.Bosque;
import juegoYZonas.Brisapura;
import juegoYZonas.Cementerio;
import juegoYZonas.Ciudad;
import juegoYZonas.Cueva;
import juegoYZonas.Juego;
import juegoYZonas.Mercado;
import juegoYZonas.Puente;
import juegoYZonas.Ruinas;
import juegoYZonas.Taberna;
import juegoYZonas.Templo;
import personajes.Jugador;
import personajes.Personaje;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Insets;

/**
 * Esta clase es la clase principal del juego. Aquí se encuentra el MAIN. Actúa
 * como contenedor de todos los paneles.
 */
@SuppressWarnings("rawtypes")
public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Atributo que contiene el juego, y el cual se usará para implementar en los
	 * distintos paneles.
	 */

	private static FramePrincipal frame;
	private Juego juego = new Juego();
	private Sonido sonido;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private PanelBatalla panel0Batalla;
	private PanelBatallaHabilidades panel0BatallaHabilidades;
	private PanelBatallaMuerte panel0BatallaMuerte;
	private Panel00Inventario panel0Inventario; // Panel 0
	// Panel 1 en el constructor
	private Panel02Nombre panel2Nombre; // Panel 2
	private Panel03Historia panel3Historia; // Panel 3
	private Panel04Ciudad panel4Ciudad; // Panel 4 - Zona 1
	private Panel04CiudadMapa panel4CiudadMapa; // Panel 4
	private Panel05Mercado panel5Mercado; // Panel 5
	private Panel05MercadoComerciante panel05MercadoComerciante; // Panel 5
	private Panel05MercadoComercianteAdmin panel05MercadoComercianteAdmin; // Panel 5
	private Panel06Taberna panel6Taberna; // Panel 6
	private Panel07Bosque panel7Bosque; // Panel 7
	private Panel08Ruinas panel8Ruinas; // Panel 8
	private Panel09Cementerio panel9Cementerio; // Panel 9
	private Panel09CementerioParte2 panel9CementerioParte2; // Panel 9
	private Panel10Puente panel10Puente; // Panel 10
	private Panel10PuenteComerciante panel10PuenteComerciante; // Panel 10
	private Panel11Brisapura panel11Brisapura; // Panel 11
	private Panel11Mago panel11Mago; // Panel 11
	private Panel11Manticora panel11Manticora; // Panel 11
	private Panel11ManticoraViaje panel11ManticoraViaje; // Panel 11
	private Panel12Cueva panel12Cueva; // Panel 12
	private Panel12CuevaParte2 panel12CuevaParte2; // Panel 12
	private Panel12CuevaEste panel12CuevaEste; // Panel 12
	private Panel12CuevaOeste panel12CuevaOeste; // Panel 12
	private Panel12CuevaParte3 panel12CuevaParte3; // Panel 12
	private Panel12CuevaParte4 panel12CuevaParte4; // Panel 12
	private Panel12CuevaParte5 panel12CuevaParte5; // Panel 12
	private Panel12CuevaParte6 panel12CuevaParte6; // Panel 12
	private Panel13EntradaTemplo panel13EntradaTemplo; // Panel 13
	private Panel13Templo panel13Templo; // Panel 13. Batalla final del juego
	private Panel14Final panel14Final; // Final del juego
	private Panel15Jugadores panel15Jugadores; // Jugadores y sus estadisticas al terminar el juego
	private JMenuBar menuBar;
	private JMenu menuDeJuego;
	private JButton botonCerrarJuego;
	private Font gotFont;

	/**
	 * Lanzamiento de la aplicación. El main se encuentra aquí, en la clase
	 * FramePrincipal.
	 * 
	 * @param args Argumentos que recibe el método main.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creación del frame y de todos los paneles, botones y herramientas necesarias.
	 */
	public FramePrincipal() {
		sonido = new Sonido();
		setRootPaneCheckingEnabled(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FramePrincipal.class.getResource("/resources/images/icono.png")));
		reproducirCancionPrincipal();
		setTitle("No Man's Land");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 576);

		/**
		 * Se carga la fuente de Game of thrones en gotFont, objeto atributo de clase
		 * Font.
		 */
		InputStream is = null;
		try {
			is = FramePrincipal.class.getResourceAsStream("/resources/Game of Thrones.ttf");
			gotFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuDeJuego = new JMenu("Menu de juego");
		menuDeJuego.setForeground(Color.DARK_GRAY);
		menuDeJuego.setBorder(new EmptyBorder(3, 0, 0, 0));
		menuDeJuego.setHorizontalAlignment(SwingConstants.LEFT);
		menuDeJuego.setHorizontalTextPosition(SwingConstants.LEADING);
		menuDeJuego.setMargin(new Insets(2, 0, 0, 0));
		menuDeJuego.setVerticalTextPosition(SwingConstants.BOTTOM);
		menuDeJuego.setContentAreaFilled(false);
		menuDeJuego.setFont(getGotFont().deriveFont(12f));
		menuDeJuego.setSize(new Dimension(4, 5));
		menuBar.add(menuDeJuego);

		JButton botonNuevoJuego = new JButton("Nuevo juego");
		botonNuevoJuego.setBorderPainted(false);
		botonNuevoJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonNuevoJuego.setFocusCycleRoot(true);
		botonNuevoJuego.setContentAreaFilled(false);
		menuDeJuego.add(botonNuevoJuego);
		botonNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarJuego();
			}
		});

		botonCerrarJuego = new JButton("Cerrar");
		botonCerrarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sonido.cerrarSonido();
				dispose();
			}
		});
		botonCerrarJuego.setBorderPainted(false);
		botonCerrarJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonCerrarJuego.setFocusCycleRoot(true);
		botonCerrarJuego.setContentAreaFilled(false);
		menuDeJuego.add(botonCerrarJuego);

		JMenu menu_2 = new JMenu("|");
		menu_2.setEnabled(false);
		menu_2.setFocusTraversalKeysEnabled(false);
		menu_2.setVerifyInputWhenFocusTarget(false);
		menu_2.setRolloverEnabled(false);
		menu_2.setRequestFocusEnabled(false);
		menu_2.setFocusable(false);
		menu_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		menu_2.setSize(new Dimension(4, 5));
		menu_2.setMargin(new Insets(2, 0, 0, 0));
		menu_2.setHorizontalTextPosition(SwingConstants.LEADING);
		menu_2.setHorizontalAlignment(SwingConstants.LEFT);
		menu_2.setFont(new Font("Arial", Font.PLAIN, 12));
		menu_2.setContentAreaFilled(false);
		menu_2.setBorder(new EmptyBorder(3, 0, 0, 0));
		menuBar.add(menu_2);

		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnComenzar = new JButton("");
		btnComenzar.setContentAreaFilled(false);
		btnComenzar.setForeground(Color.BLACK);
		btnComenzar.setBackground(SystemColor.activeCaptionBorder);
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(btnComenzar);
				comenzarJuego();
			}
		});
		btnComenzar.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnComenzar.setBounds(331, 427, 166, 57);
		contentPane.add(btnComenzar);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 850, 521);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		Panel01Comienzo panel1Comienzo = new Panel01Comienzo();
		layeredPane.add(panel1Comienzo, "panel1");

		panel0Inventario = new Panel00Inventario(this);
		layeredPane.add(panel0Inventario, "panel0");

		panel2Nombre = new Panel02Nombre(this);
		layeredPane.add(panel2Nombre, "panel2");

		panel3Historia = new Panel03Historia(this);
		layeredPane.add(panel3Historia, "panel3");

		panel4Ciudad = new Panel04Ciudad(this);
		layeredPane.add(getPanel4Ciudad(), "panel4");

		panel4CiudadMapa = new Panel04CiudadMapa(this);
		layeredPane.add(panel4CiudadMapa, "panel4ciudadmapa");

		panel5Mercado = new Panel05Mercado(this);
		layeredPane.add(getPanel5Mercado(), "panel5");

		panel05MercadoComerciante = new Panel05MercadoComerciante(this);
		layeredPane.add(panel05MercadoComerciante, "panel5MercadoComerciante");

		panel05MercadoComercianteAdmin = new Panel05MercadoComercianteAdmin(this);
		layeredPane.add(panel05MercadoComercianteAdmin, "panel5ComercianteAdmin");

		panel6Taberna = new Panel06Taberna(this);
		layeredPane.add(getPanel6Taberna(), "panel6");

		panel7Bosque = new Panel07Bosque(this);
		layeredPane.add(panel7Bosque, "panel7");

		panel8Ruinas = new Panel08Ruinas(this);
		layeredPane.add(panel8Ruinas, "panel8");

		panel9Cementerio = new Panel09Cementerio(this);
		layeredPane.add(panel9Cementerio, "panel9");

		panel9CementerioParte2 = new Panel09CementerioParte2(this);
		layeredPane.add(panel9CementerioParte2, "panel9parte2");

		panel10Puente = new Panel10Puente(this);
		layeredPane.add(panel10Puente, "panel10");

		panel10PuenteComerciante = new Panel10PuenteComerciante(this);
		layeredPane.add(panel10PuenteComerciante, "panel10Comerciante");

		panel11Brisapura = new Panel11Brisapura(this);
		layeredPane.add(panel11Brisapura, "panel11Brisapura");

		panel11Mago = new Panel11Mago(this);
		layeredPane.add(panel11Mago, "panel11Mago");

		panel11Manticora = new Panel11Manticora(this);
		layeredPane.add(panel11Manticora, "panel11Manticora");

		panel11ManticoraViaje = new Panel11ManticoraViaje(this);
		layeredPane.add(panel11ManticoraViaje, "panel11ManticoraViaje");

		panel12Cueva = new Panel12Cueva(this);
		layeredPane.add(panel12Cueva, "panel12Cueva");

		panel12CuevaParte2 = new Panel12CuevaParte2(this);
		layeredPane.add(panel12CuevaParte2, "panel12CuevaParte2");

		panel12CuevaEste = new Panel12CuevaEste(this);
		layeredPane.add(panel12CuevaEste, "panel12CuevaEste");

		panel12CuevaOeste = new Panel12CuevaOeste(this);
		layeredPane.add(panel12CuevaOeste, "panel12CuevaOeste");

		panel12CuevaParte3 = new Panel12CuevaParte3(this);
		layeredPane.add(panel12CuevaParte3, "panel12Parte3");

		panel12CuevaParte4 = new Panel12CuevaParte4(this);
		layeredPane.add(panel12CuevaParte4, "panel12Parte4");

		panel12CuevaParte5 = new Panel12CuevaParte5(this);
		layeredPane.add(panel12CuevaParte5, "panel12Parte5");

		panel12CuevaParte6 = new Panel12CuevaParte6(this);
		layeredPane.add(panel12CuevaParte6, "panel12Parte6");

		panel13EntradaTemplo = new Panel13EntradaTemplo(this);
		layeredPane.add(panel13EntradaTemplo, "panel13EntradaTemplo");

		panel13Templo = new Panel13Templo(this);
		layeredPane.add(panel13Templo, "panel13");

		panel14Final = new Panel14Final(this);
		layeredPane.add(panel14Final, "panel14");

		panel15Jugadores = new Panel15Jugadores(this);
		layeredPane.add(panel15Jugadores, "panel15");

		panel0Batalla = new PanelBatalla(this);
		layeredPane.add(panel0Batalla, "panel0Batalla");

		panel0BatallaHabilidades = new PanelBatallaHabilidades(this);
		layeredPane.add(panel0BatallaHabilidades, "panel0BatallaHabilidades");

		panel0BatallaMuerte = new PanelBatallaMuerte();
		layeredPane.add(panel0BatallaMuerte, "panel0BatallaMuerte");

		/**
		 * Método necesario para que se le pregunte al usuario mediante un cartel si se
		 * quiere salir del juego. Para eso se necesita un listener que controle si se
		 * produce el evento "cerrar ventana usando la cruz".
		 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				String[] opciones = new String[2];
				opciones[0] = new String("Sí");
				opciones[1] = new String("No");
				int x = JOptionPane.showOptionDialog(frame.getContentPane(), "¿Seguro que quieres salir del juego?",
						"Salir del juego", 0, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);
				if (x == JOptionPane.YES_OPTION) {
					sonido.cerrarSonido();
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		centrarVentana(this);
	}

	/**
	 * Método necesario para que la ventana del frame se encuentre en el medio de la
	 * pantalla.
	 * 
	 * @param frame Trae por parámetro el JFrame.
	 */
	public static void centrarVentana(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	/**
	 * Método de acceso al Jugador.
	 * 
	 * @return Retorna al objeto de la clase Jugador.
	 */
	public Jugador retornarJugador() {
		return juego.getJugador();
	}

	/**
	 * Método de acceso al Juego.
	 * 
	 * @return Retorna objeto de la clase Juego.
	 */
	public Juego getJuego() {
		return juego;
	}

	// ZONAS - Para acceder mas facil a las zonas que estan dentro del conjunto en
	// la clase Juego

	public Ciudad retornarCiudad() {
		return juego.retornarCiudad();
	}

	public Mercado retornarMercado() {
		return juego.retornarMercado();
	}

	public Taberna retornarTaberna() {
		return juego.retornarTaberna();
	}

	public Bosque retornarBosque() {
		return juego.retornarBosque();
	}

	public Ruinas retornarRuinas() {
		return juego.retornarRuinas();
	}

	public Cementerio retornarCementerio() {
		return juego.retornarCementerio();
	}

	public Puente retornarPuente() {
		return juego.retornarPuente();
	}

	public Brisapura retornarBrisapura() {
		return juego.retornarBrisapura();
	}

	public Cueva retornarCueva() {
		return juego.retornarCueva();
	}

	public Templo retornarTemplo() {
		return juego.retornarTemplo();
	}

	// FIN ZONAS

	// SONIDOS

	public void reproducirCancionPrincipal() {
		sonido.reproducirCancionPrincipal();
	}

	public void pausarCancionPrincipal() {
		sonido.pausarCancionPrincipal();
	}

	public void reproducirCancionTaberna() {
		sonido.reproducirCancionTaberna();
	}

	public void pausarCancionTaberna() {
		sonido.pausarCancionTaberna();
	}

	public void reproducirCancionBatalla() {
		sonido.reproducirCancionBatalla();
	}

	public void pausarCancionBatalla() {
		sonido.pausarCancionBatalla();
	}

	public void reproducirSonidoMuerte() {
		sonido.reproducirSonidoMuerte();
	}

	public void reproducirSonidoCompra() {
		sonido.reproducirSonidoCompra();
	}

	public void reproducirSonidoAtaqueDragon() {
		sonido.reproducirSonidoAtaqueDragon();
	}

	public void reproducirSonidoMuerteDragon() {
		sonido.reproducirSonidoMuerteDragon();
	}

	public void reproducirSonidoPocion() {
		sonido.reproducirSonidoPocion();
	}

	public void reproducirSonidoBolaDeFuego() {
		sonido.reproducirSonidoBolaDeFuego();
	}

	public void reproducirSonidoNovaDeEscarcha() {
		sonido.reproducirSonidoNovaDeEscarcha();
	}

	public void reproducirSonidoGolpeDeCruzado() {
		sonido.reproducirSonidoGolpeDeCruzado();
	}

	public void reproducirSonidoBarreraDivina() {
		sonido.reproducirSonidoBarreraDivina();
	}

	public void reproducirSonidoAtacar() {
		sonido.reproducirSonidoAtacar();
	}

	public void reproducirSonidoEquipar() {
		sonido.reproducirSonidoEquipar();
	}

	// FIN SONIDOS

	public Font getGotFont() {
		return gotFont;
	}

	// DESPLAZAMIENTO ENTRE LOS PANELES

	/**
	 * Se usa antes de cargar un nuevo panel. Se limpia la pantalla y se recalcula
	 * el diseño causando que los elementos secundarios del panel se vuelvan a
	 * pintar.
	 */
	private void limpiarPantalla() {
		layeredPane.removeAll();
		layeredPane.revalidate();
		layeredPane.repaint();
	}

	private void comenzarJuego() {
		intercambiarPaneles(panel2Nombre);
	}

	/**
	 * Método que se llama desde un panel para pasar al próximo panel en el frame
	 * (se debe pasar puntero del frame al panel para poderlo invocar).
	 * 
	 * @param panel Trae por parámetro el panel al cual se quiere pasar.
	 */
	public void intercambiarPaneles(JPanel panel) {
		limpiarPantalla();
		layeredPane.add(panel);
	}

	/**
	 * Método que se llama desde un panel para pasar al próximo panel en el frame
	 * (se debe pasar puntero del frame al panel para poderlo invocar) pero en el
	 * parametro tenemos a JPanelPadre (clase hija de JPanel de la que extienden
	 * PanelCiudad, PanelMercado, etc.) y la función de carga de HUD que está en la
	 * clase JPanelPadre Sirve para pasar del panel Ciudad al panel Mercado y así
	 * con todos los paneles dedicados a las zonas del juego.
	 * 
	 * @param panel Trae por parámetro el panel al cual se quiere pasar.
	 */
	public void intercambiarPaneles(JPanelPadre panel) {
		limpiarPantalla();
		layeredPane.add(panel);
		panel.cargarHud();
	}

	/**
	 * Método que se llama desde un panel para pasar al panel que contiene el
	 * inventario.
	 * 
	 * @param panel Trae por parámetro el panel al cual se retornará al salir del
	 *              inventario.
	 */
	public void intercambiarAPanelInventario(JPanelPadre panel) {
		limpiarPantalla();
		layeredPane.add(panel0Inventario);
		panel0Inventario.cargarPanelSiguiente(panel);
	}

	/**
	 * Método que se llama desde un panel para pasar al panel que se muestra al
	 * morir en el juego.
	 */
	public void intercambiarABatallaMuerte() {
		pausarCancionBatalla();
		reproducirSonidoMuerte();
		limpiarPantalla();
		getPanel0BatallaMuerte().reproducirGif();
		layeredPane.add(getPanel0BatallaMuerte());
	}

	/**
	 * Método que se llama para pasar del panel que contiene las habilidades al
	 * panel de batalla, sin reiniciar nada.
	 */
	public void irDelPanelHabilidadesAlPanelBatalla() {
		limpiarPantalla();
		layeredPane.add(panel0Batalla);
	}

	/**
	 * Método que se llama desde un panel para pasar al panel que contiene las
	 * batallas.
	 * 
	 * @param panelSiguiente Trae el panel siguiente por si se gana la batalla.
	 * @param panelAnterior  Trae el panel anterior para las huidas.
	 * @param enemigo        Trae al enemigo.
	 * @param direccion      Trae la dirección en disco de la imagen del enemigo.
	 */
	public void prepararEnfrentamiento(JPanelPadre panelSiguiente, JPanelPadre panelAnterior, Personaje enemigo,
			String direccion) {
		pausarCancionPrincipal();
		reproducirCancionBatalla();
		limpiarPantalla();
		if (panelAnterior == null) {
			getPanel0Batalla().batallaSinHuir();
			getPanel0Batalla().cargarPanelSiguiente(panelSiguiente);
		} else {
			getPanel0Batalla().batalla();
			getPanel0Batalla().cargarPanelSiguienteYAnterior(panelSiguiente, panelAnterior);
		}
		getPanel0Batalla().cargarHudDeBatalla(direccion, enemigo);
		layeredPane.add(getPanel0Batalla());
	}

	/**
	 * Método que se llama para pasar al panel de batalla pero especifícamente
	 * cuando se batalla contra las arañas gigantes. En este caso se puede saltar la
	 * batalla, hay una probabilidad de 50 y 50.
	 * 
	 * @param panelSiguiente Trae el panel siguiente por si se gana la batalla.
	 * @param panelAnterior  Trae el panel anterior para las huidas.
	 * @param enemigo        Trae al enemigo.
	 * @param direccion      Trae la dirección en disco de la imagen del enemigo.
	 */
	public void encuentroAleatorioConArañaGigante(JPanelPadre panelSiguiente, JPanelPadre panelAnterior,
			Personaje enemigo, String direccion) {
		int valorAleatorio = (int) (Math.random() * 100);
		if (valorAleatorio < 50)
			intercambiarPaneles(panelSiguiente);
		else
			prepararEnfrentamiento(panelSiguiente, null, enemigo, direccion);
	}

	public void encuentroAleatorioActivarHuir() {
		panel0Batalla.activarHuir();
	}

	public PanelBatalla getPanel0Batalla() {
		return panel0Batalla;
	}

	public PanelBatallaHabilidades getPanel0BatallaHabilidades() {
		return panel0BatallaHabilidades;
	}

	public PanelBatallaMuerte getPanel0BatallaMuerte() {
		return panel0BatallaMuerte;
	}

	public Panel00Inventario getPanel0Inventario() {
		return panel0Inventario;
	}

	public Panel02Nombre getPanel2Nombre() {
		return panel2Nombre;
	}

	public Panel03Historia getPanel3Historia() {
		return panel3Historia;
	}

	public Panel04Ciudad getPanel4Ciudad() {
		return panel4Ciudad;
	}

	public Panel04CiudadMapa getPanel4CiudadMapa() {
		return panel4CiudadMapa;
	}

	public Panel05Mercado getPanel5Mercado() {
		return panel5Mercado;
	}

	public Panel05MercadoComerciante getPanel05MercadoComerciante() {
		return panel05MercadoComerciante;
	}

	public Panel05MercadoComercianteAdmin getPanel05MercadoComercianteAdmin() {
		return panel05MercadoComercianteAdmin;
	}

	public Panel06Taberna getPanel6Taberna() {
		return panel6Taberna;
	}

	public Panel07Bosque getPanel7Bosque() {
		return panel7Bosque;
	}

	public Panel08Ruinas getPanel8Ruinas() {
		return panel8Ruinas;
	}

	public Panel09Cementerio getPanel9Cementerio() {
		return panel9Cementerio;
	}

	public Panel09CementerioParte2 getPanel9CementerioParte2() {
		return panel9CementerioParte2;
	}

	public Panel10Puente getPanel10Puente() {
		return panel10Puente;
	}

	public Panel10PuenteComerciante getPanel10PuenteComerciante() {
		return panel10PuenteComerciante;
	}

	public Panel11Brisapura getPanel11Brisapura() {
		return panel11Brisapura;
	}

	public Panel11Mago getPanel11Mago() {
		return panel11Mago;
	}

	public Panel11Manticora getPanel11Manticora() {
		return panel11Manticora;
	}

	public Panel11ManticoraViaje getPanel11ManticoraViaje() {
		return panel11ManticoraViaje;
	}

	public Panel12Cueva getPanel12Cueva() {
		return panel12Cueva;
	}

	public Panel12CuevaParte2 getPanel12CuevaParte2() {
		return panel12CuevaParte2;
	}

	public Panel12CuevaEste getPanel12CuevaEste() {
		return panel12CuevaEste;
	}

	public Panel12CuevaOeste getPanel12CuevaOeste() {
		return panel12CuevaOeste;
	}

	public Panel12CuevaParte3 getPanel12CuevaParte3() {
		return panel12CuevaParte3;
	}

	public Panel12CuevaParte4 getPanel12CuevaParte4() {
		return panel12CuevaParte4;
	}

	public Panel12CuevaParte5 getPanel12CuevaParte5() {
		return panel12CuevaParte5;
	}

	public Panel12CuevaParte6 getPanel12CuevaParte6() {
		return panel12CuevaParte6;
	}

	public Panel13EntradaTemplo getPanel13EntradaTemplo() {
		return panel13EntradaTemplo;
	}

	public Panel13Templo getPanel13Templo() {
		return panel13Templo;
	}

	public Panel14Final getPanel14Final() {
		return panel14Final;
	}

	public Panel15Jugadores getPanel15Jugadores() {
		return panel15Jugadores;
	}

	/**
	 * Método que se llama si se presiona el botón Reiniciar juego. Cierra todos los
	 * clips de sonido y cierra el Frame y crea uno nuevo.
	 */
	public void reiniciarJuego() {
		sonido.cerrarSonido();
		dispose();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				FramePrincipal ex = new FramePrincipal();
				ex.setVisible(true);
			}
		});
	}
}