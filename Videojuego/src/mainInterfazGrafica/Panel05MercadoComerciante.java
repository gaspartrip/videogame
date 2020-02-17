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
import objetos.Arma;
import objetos.Armadura;
import objetos.Objeto;
import objetos.Pocion;
import personajes.Comerciante;
import personajes.Jugador;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import juegoYZonas.Mercado;

/**
 * Esta clase contiene a la clase Comerciante.
 */
public class Panel05MercadoComerciante extends JPanel {

	private static final long serialVersionUID = 1L;
	private FramePrincipal principal;
	private JComboBox<Objeto> comboBox;
	private Comerciante comerciante;
	private Mercado mercado;
	private Jugador jugador;
	private JTextField tuOro;
	private JPasswordField passwordField;
	/**
	 * Contraseña de acceso al menu de admin del mercado para agregar/quitar items.
	 */
	private static final String CODIGO_DE_ENTRADA = "dracarys";

	public Panel05MercadoComerciante(FramePrincipal principal) {
		this.principal = principal;
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel seleccionaItem = new JLabel("Selecciona el item a comprar");
		seleccionaItem.setFont(principal.getGotFont().deriveFont(32f));
		seleccionaItem.setForeground(Color.WHITE);
		seleccionaItem.setBackground(Color.DARK_GRAY);
		seleccionaItem.setBounds(92, 0, 737, 142);
		add(seleccionaItem);

		comboBox = new JComboBox<Objeto>();
		comboBox.setOpaque(false);
		comboBox.setBounds(135, 174, 545, 34);
		add(comboBox);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setContentAreaFilled(false);
		btnComprar.setFocusPainted(false);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar();
			}
		});
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnComprar.setBounds(394, 119, 146, 44);
		add(btnComprar);

		JButton btnContinuar = new JButton("Volver");
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
		btnContinuar.setBounds(334, 464, 137, 35);
		add(btnContinuar);

		JLabel tuOroIcono = new JLabel("");
		tuOroIcono.setIcon(
				new ImageIcon(Panel05MercadoComerciante.class.getResource("/resources/images/oroMercado.jpg")));
		tuOroIcono.setForeground(Color.WHITE);
		tuOroIcono.setFont(principal.getGotFont().deriveFont(16f));
		tuOroIcono.setBackground(Color.DARK_GRAY);
		tuOroIcono.setBounds(257, 119, 44, 44);
		add(tuOroIcono);

		tuOro = new JTextField();
		tuOro.setForeground(Color.WHITE);
		tuOro.setOpaque(false);
		tuOro.setEditable(false);
		tuOro.setHorizontalAlignment(SwingConstants.CENTER);
		tuOro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tuOro.setBounds(311, 127, 62, 31);
		add(tuOro);
		tuOro.setColumns(10);

		JLabel lblAccesoEspecial = new JLabel("Acceso especial");
		lblAccesoEspecial.setForeground(Color.WHITE);
		lblAccesoEspecial.setFont(principal.getGotFont().deriveFont(32f));
		lblAccesoEspecial.setBackground(Color.DARK_GRAY);
		lblAccesoEspecial.setBounds(238, 325, 479, 50);
		add(lblAccesoEspecial);

		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accesoEspecial();
			}
		});
		btnAcceder.setForeground(Color.WHITE);
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAcceder.setFocusPainted(false);
		btnAcceder.setContentAreaFilled(false);
		btnAcceder.setBackground(Color.WHITE);
		btnAcceder.setBounds(466, 386, 137, 35);
		add(btnAcceder);

		passwordField = new JPasswordField(10);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, Color.DARK_GRAY));
		passwordField.setBounds(196, 386, 243, 34);
		add(passwordField);

		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(
				Panel05MercadoComerciante.class.getResource("/resources/images/zona2-mercado-comerciante.jpg")));
		fondo.setBounds(-294, 0, 1157, 844);
		add(fondo);

		agregarItems();
	}

	private void agregarItems() {
		comerciante = principal.retornarMercado().getComerciante();
		mercado = principal.retornarMercado();
		jugador = principal.retornarJugador();
		comboBox.removeAllItems();
		cargarArmas();
		cargarArmaduras();
		cargarPociones();
		tuOro.setText(String.valueOf(jugador.getOro()));
	}

	private void cargarArmas() {
		ArrayList<Arma> armas = new ArrayList<>();
		armas = comerciante.getArmasComerciante();
		for (Arma e : armas)
			comboBox.addItem(e);
	}

	private void cargarArmaduras() {
		ArrayList<Armadura> armaduras = new ArrayList<>();
		armaduras = comerciante.getArmadurasComerciante();
		for (Armadura e : armaduras)
			comboBox.addItem(e);
	}

	private void cargarPociones() {
		ArrayList<Pocion> pociones = new ArrayList<>();
		pociones = comerciante.getPocionesComerciante();
		for (Pocion e : pociones)
			comboBox.addItem(e);
	}

	private void cargarArmasArmadurasYPociones() {
		cargarArmas();
		cargarArmaduras();
		cargarPociones();
		tuOro.setText(String.valueOf(jugador.getOro()));
	}

	/**
	 * Carga del actual stock de armas, armaduras y pociones del Comerciante. Esta
	 * carga se hace en el comboBox, donde se llamará al toString correspondiente de
	 * cada objeto (Arma, Armadura, Pocion).
	 */
	public void actualizarStock() {
		comboBox.removeAllItems();
		cargarArmasArmadurasYPociones();
	}

	/**
	 * Método que comprueba si hay un ítem en el comboBox, si no es así, muestra
	 * mensaje correspondiente. Si hay un ítem, efectua la compra del mismo llamando
	 * al método comprar() de Jugador, no sin antes comprobar si hay oro suficiente
	 * para hacerlo.
	 */
	private void comprar() {
		if (comboBox.getItemCount() != 0) {
			Objeto objetoAComprar = (Objeto) comboBox.getSelectedItem();
			if (objetoAComprar instanceof Arma && jugador.comprarArma(comerciante, (Arma) objetoAComprar)) {
				principal.getPanel0Inventario().cargarArmasArmadurasYPociones();
				comboBox.removeAllItems();
				cargarArmasArmadurasYPociones();
				principal.reproducirSonidoCompra();
			} else if (objetoAComprar instanceof Armadura
					&& jugador.comprarArmadura(comerciante, (Armadura) objetoAComprar)) {
				principal.getPanel0Inventario().cargarArmasArmadurasYPociones();
				comboBox.removeAllItems();
				cargarArmasArmadurasYPociones();
				principal.reproducirSonidoCompra();
			} else if (objetoAComprar instanceof Pocion
					&& jugador.comprarPocion(comerciante, (Pocion) objetoAComprar)) {
				principal.getPanel0Inventario().cargarArmasArmadurasYPociones();
				comboBox.removeAllItems();
				cargarArmasArmadurasYPociones();
				principal.reproducirSonidoCompra();
			} else {
				JOptionPane.showMessageDialog(null, "No tienes suficiente oro", "No se puede comprar",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay nada para comprar", "No se puede comprar",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void volver() {
		principal.intercambiarPaneles(principal.getPanel5Mercado());
	}

	/**
	 * Método que da acceso al panel para administradores, en el cual podrán
	 * ingresar y quitar armas/armaduras/pociones y, si se desea, guardar el actual
	 * stock del inventario del mercado/comerciante.
	 */
	private void accesoEspecial() {
		if (String.valueOf(passwordField.getPassword()).equals(CODIGO_DE_ENTRADA)) {
			principal.getPanel05MercadoComercianteAdmin().cargar(comerciante, mercado);
			principal.intercambiarPaneles(principal.getPanel05MercadoComercianteAdmin());
		} else {
			JOptionPane.showMessageDialog(principal, "Contraseña invalida. Intente nuevamente.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		passwordField.setText("");
	}
}