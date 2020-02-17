package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import objetos.Arma;
import objetos.Armadura;
import personajes.Jugador;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Point;

/**
 * Esta clase contiene el inventario del jugador
 */
public class Panel00Inventario extends JPanel {

	private static final long serialVersionUID = 1L;
	private FramePrincipal principal;
	private JComboBox<Armadura> boxArmaduras;
	private JComboBox<Arma> boxArmas;
	private JTextField cantidadDeVida;
	private JTextField cantidadDeOro;
	private JTextField textField_nombreJugador;
	private JPanelPadre panelSiguiente;
	private Jugador jugador;
	private JTextField cantidadDePociones;

	public Panel00Inventario(FramePrincipal principal) {
		this.principal = principal;
		setBackground(Color.BLACK);
		setLayout(null);

		boxArmaduras = new JComboBox<Armadura>();
		boxArmaduras.setOpaque(false);
		boxArmaduras.setBounds(107, 222, 352, 35);
		add(boxArmaduras);

		boxArmas = new JComboBox<Arma>();
		boxArmas.setOpaque(false);
		boxArmas.setBounds(107, 267, 352, 35);
		add(boxArmas);

		JButton btnContinuar = new JButton("VOLVER");
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnContinuar.setBounds(317, 446, 184, 26);
		add(btnContinuar);

		JLabel armaPrincipal = new JLabel(new ImageIcon(Panel04Ciudad.class.getResource("/resources/images/arma.jpg")));
		armaPrincipal.setBounds(65, 262, 32, 40);
		add(armaPrincipal);

		JLabel armadura = new JLabel(new ImageIcon(getClass().getResource("/resources/images/armadura.jpg")));
		armadura.setBounds(65, 222, 32, 35);
		add(armadura);

		JLabel pocion = new JLabel(new ImageIcon(PanelBatalla.class.getResource("/resources/images/pocion.jpg")));
		pocion.setBounds(65, 313, 32, 35);
		add(pocion);

		JLabel vidaTotal = new JLabel(new ImageIcon(getClass().getResource("/resources/images/hp.jpg")));
		vidaTotal.setBounds(65, 355, 32, 40);
		add(vidaTotal);

		JLabel oroTotal = new JLabel(new ImageIcon(getClass().getResource("/resources/images/oro.jpg")));
		oroTotal.setBounds(65, 406, 32, 35);
		add(oroTotal);

		cantidadDeVida = new JTextField();
		cantidadDeVida.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadDeVida.setEditable(false);
		cantidadDeVida.setColumns(10);
		cantidadDeVida.setBounds(107, 359, 55, 35);
		add(cantidadDeVida);

		cantidadDeOro = new JTextField();
		cantidadDeOro.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadDeOro.setEditable(false);
		cantidadDeOro.setColumns(10);
		cantidadDeOro.setBounds(107, 406, 55, 35);
		add(cantidadDeOro);

		textField_nombreJugador = new JTextField();
		textField_nombreJugador.setBorder(null);
		textField_nombreJugador.setOpaque(false);
		textField_nombreJugador.setRequestFocusEnabled(false);
		textField_nombreJugador.setFocusTraversalKeysEnabled(false);
		textField_nombreJugador.setDisabledTextColor(Color.WHITE);
		textField_nombreJugador.setForeground(Color.WHITE);
		textField_nombreJugador.setFocusable(false);
		textField_nombreJugador.setEditable(false);
		textField_nombreJugador.setColumns(10);
		textField_nombreJugador.setFont(principal.getGotFont().deriveFont(23f));
		textField_nombreJugador.setBounds(107, 141, 506, 45);
		add(textField_nombreJugador);

		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setForeground(new Color(211, 211, 211));
		lblInventario.setFont(principal.getGotFont().deriveFont(40f));
		lblInventario.setBounds(245, 65, 456, 65);
		add(lblInventario);

		JButton btnEquiparArmadura = new JButton("Equipar armadura");
		btnEquiparArmadura.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEquiparArmadura.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEquiparArmadura.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), null, null, null));
		btnEquiparArmadura.setOpaque(false);
		btnEquiparArmadura.setFocusable(false);
		btnEquiparArmadura.setLocation(new Point(0, 1));
		btnEquiparArmadura.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnEquiparArmadura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEquiparArmadura.setFocusPainted(false);
		btnEquiparArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equiparArmadura();
				principal.reproducirSonidoEquipar();
			}
		});
		btnEquiparArmadura.setForeground(Color.WHITE);
		btnEquiparArmadura.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		btnEquiparArmadura.setBackground(Color.DARK_GRAY);
		btnEquiparArmadura.setBounds(469, 222, 212, 35);
		add(btnEquiparArmadura);

		JButton btnEquiparArma = new JButton("Equipar arma");
		btnEquiparArma.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEquiparArma.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEquiparArma.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), null, null, null));
		btnEquiparArma.setOpaque(false);
		btnEquiparArma.setFocusable(false);
		btnEquiparArma.setLocation(new Point(0, 1));
		btnEquiparArma.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnEquiparArma.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEquiparArma.setFocusPainted(false);
		btnEquiparArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equiparArma();
				principal.reproducirSonidoEquipar();
			}
		});
		btnEquiparArma.setForeground(Color.WHITE);
		btnEquiparArma.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		btnEquiparArma.setBackground(Color.DARK_GRAY);
		btnEquiparArma.setBounds(469, 267, 189, 36);
		add(btnEquiparArma);

		JButton btnBeberPocion = new JButton("Beber poci\u00F3n");
		btnBeberPocion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBeberPocion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBeberPocion.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), null, null, null));
		btnBeberPocion.setOpaque(false);
		btnBeberPocion.setFocusable(false);
		btnBeberPocion.setLocation(new Point(0, 1));
		btnBeberPocion.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnBeberPocion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBeberPocion.setFocusPainted(false);
		btnBeberPocion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beberPocion();
			}
		});
		btnBeberPocion.setForeground(Color.WHITE);
		btnBeberPocion.setFont(new Font("Sylfaen", Font.PLAIN, 21));
		btnBeberPocion.setBackground(Color.DARK_GRAY);
		btnBeberPocion.setBounds(172, 313, 169, 35);
		add(btnBeberPocion);

		cantidadDePociones = new JTextField();
		cantidadDePociones.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadDePociones.setEditable(false);
		cantidadDePociones.setColumns(10);
		cantidadDePociones.setBounds(107, 313, 55, 35);
		add(cantidadDePociones);

		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(Panel00Inventario.class.getResource("/resources/images/zona0-inventario.jpg")));
		fondo.setBounds(-23, 0, 1139, 529);
		add(fondo);
	}

	/**
	 * Método que llama al metodo beberPocion del jugador, el cual comprueba si hay
	 * pociones, y si las hay elimina la poción del inventario del jugador y sana la
	 * vida, actualizando el HUD. Si no se pudo beber muestra los carteles
	 * correspondientes según el caso.
	 */
	private void beberPocion() {
		if (jugador.beberPocion()) {
			principal.reproducirSonidoPocion();
			cargarPociones();
			cargarDatosDelJugadorEnElInventario();
		} else {
			if (!jugador.hayPociones())
				JOptionPane.showMessageDialog(null, "No tienes pociones", "Beber poción", JOptionPane.WARNING_MESSAGE);
			else if (jugador.vidaAlMaximo())
				JOptionPane.showMessageDialog(null, "Tienes la vida al máximo", "Beber poción",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Actualiza con los datos actuales todas las muestras de datos de los stats del
	 * jugador (nombre, vida, oro, armas, etc).
	 */
	public void cargarDatosDelJugadorEnElInventario() {
		jugador = principal.retornarJugador();
		textField_nombreJugador.setText(jugador.getNombre());
		cantidadDeVida.setText(String.valueOf(jugador.getVidaActual()));
		cantidadDeOro.setText(String.valueOf(jugador.getOro()));
		cargarArmasArmadurasYPociones();
	}

	public void cargarArmasArmadurasYPociones() {
		cargarArmas();
		cargarArmaduras();
		cargarPociones();
	}

	private void cargarArmas() {
		boxArmas.removeAllItems();
		ArrayList<Arma> armas = new ArrayList<>();
		armas = jugador.getArmas();
		for (Arma e : armas)
			boxArmas.addItem(e);
	}

	private void cargarArmaduras() {
		boxArmaduras.removeAllItems();
		ArrayList<Armadura> armaduras = new ArrayList<>();
		armaduras = jugador.getArmaduras();
		for (Armadura e : armaduras)
			boxArmaduras.addItem(e);
	}

	private void cargarPociones() {
		cantidadDePociones.setText(String.valueOf(jugador.retornarCantidadDePociones()));
	}

	public void equiparArmadura() {
		jugador.equiparArmadura((Armadura) boxArmaduras.getSelectedItem());
	}

	public void equiparArma() {
		jugador.equiparArma((Arma) boxArmas.getSelectedItem());
	}

	public void cargarPanelSiguiente(JPanelPadre panelSiguiente) {
		this.panelSiguiente = panelSiguiente;
	}

	private void volver() {
		principal.intercambiarPaneles(panelSiguiente);
	}
}