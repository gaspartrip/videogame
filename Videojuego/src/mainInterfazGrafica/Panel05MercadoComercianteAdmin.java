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
import personajes.Comerciante;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import archivo.Archivo;
import juegoYZonas.Mercado;

/**
 * Esta clase contiene el panel en el cual se agrega y quitan objetos del
 * mercado. Se accede solo mediante la clave admin.
 */
public class Panel05MercadoComercianteAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	private FramePrincipal principal;
	private Comerciante comerciante;
	private Mercado mercado;
	private JTextField nombreArma;
	private JTextField ataqueMinimoArma;
	private JTextField ataqueMaximoArma;
	private JTextField valorArma;
	private JLabel lblValorArmadura;
	private JLabel lblDefensaArmadura;
	private JLabel lblNombreArmadura;
	private JLabel lblArmaduras;
	private JLabel lblNombreArma;
	private JLabel lblAtaqueMinimoArma;
	private JLabel lblAtaqueMaximoArma;
	private JLabel lblValorArma;
	private JLabel lblPociones;
	private JButton btnEliminarArmaSeleccionada;
	private JButton btnEliminarArmaduraSeleccionada;
	private JComboBox<Arma> comboBoxArmas;
	private JComboBox<Armadura> comboBoxArmaduras;
	private JButton btnAgregarArma;
	private JButton btnAgregarArmadura;
	private JTextField nombreArmadura;
	private JTextField defensaArmadura;
	private JTextField valorArmadura;
	private JButton btnAgregarPocion;
	private JButton btnQuitarPocion;
	private JLabel lblCantidadPocion;
	private JTextField cantidadDePociones;

	public Panel05MercadoComercianteAdmin(FramePrincipal principal) {
		this.principal = principal;
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel lblArmas = new JLabel("ARMAS");
		lblArmas.setFont(principal.getGotFont().deriveFont(32f));
		lblArmas.setForeground(Color.WHITE);
		lblArmas.setBackground(Color.DARK_GRAY);
		lblArmas.setBounds(112, 11, 222, 81);
		add(lblArmas);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setFocusPainted(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGuardar.setBounds(499, 385, 184, 35);
		add(btnGuardar);

		nombreArma = new JTextField();
		nombreArma.setBounds(173, 198, 151, 20);
		add(nombreArma);
		nombreArma.setColumns(10);

		ataqueMinimoArma = new JTextField();
		ataqueMinimoArma.setBounds(173, 229, 151, 20);
		add(ataqueMinimoArma);
		ataqueMinimoArma.setColumns(10);

		ataqueMaximoArma = new JTextField();
		ataqueMaximoArma.setColumns(10);
		ataqueMaximoArma.setBounds(173, 260, 151, 20);
		add(ataqueMaximoArma);

		valorArma = new JTextField();
		valorArma.setColumns(10);
		valorArma.setBounds(173, 291, 151, 20);
		add(valorArma);

		lblValorArmadura = new JLabel("Valor");
		lblValorArmadura.setForeground(Color.WHITE);
		lblValorArmadura.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblValorArmadura.setBounds(441, 259, 115, 20);
		add(lblValorArmadura);

		lblDefensaArmadura = new JLabel("Defensa");
		lblDefensaArmadura.setForeground(Color.WHITE);
		lblDefensaArmadura.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDefensaArmadura.setBounds(441, 229, 115, 20);
		add(lblDefensaArmadura);

		lblNombreArmadura = new JLabel("Nombre");
		lblNombreArmadura.setForeground(Color.WHITE);
		lblNombreArmadura.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNombreArmadura.setBounds(441, 198, 116, 20);
		add(lblNombreArmadura);

		lblArmaduras = new JLabel("ARMADURAS");
		lblArmaduras.setForeground(Color.WHITE);
		lblArmaduras.setFont(principal.getGotFont().deriveFont(32f));
		lblArmaduras.setBackground(Color.DARK_GRAY);
		lblArmaduras.setBounds(451, 11, 352, 81);
		add(lblArmaduras);

		lblNombreArma = new JLabel("Nombre");
		lblNombreArma.setForeground(Color.WHITE);
		lblNombreArma.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNombreArma.setBounds(47, 198, 116, 20);
		add(lblNombreArma);

		lblAtaqueMinimoArma = new JLabel("Ataque m\u00EDnimo");
		lblAtaqueMinimoArma.setForeground(Color.WHITE);
		lblAtaqueMinimoArma.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAtaqueMinimoArma.setBounds(47, 229, 115, 20);
		add(lblAtaqueMinimoArma);

		lblAtaqueMaximoArma = new JLabel("Ataque m\u00E1ximo");
		lblAtaqueMaximoArma.setForeground(Color.WHITE);
		lblAtaqueMaximoArma.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAtaqueMaximoArma.setBounds(47, 260, 115, 20);
		add(lblAtaqueMaximoArma);

		lblValorArma = new JLabel("Valor");
		lblValorArma.setForeground(Color.WHITE);
		lblValorArma.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblValorArma.setBounds(47, 291, 115, 20);
		add(lblValorArma);

		lblPociones = new JLabel("POCIONES");
		lblPociones.setForeground(Color.WHITE);
		lblPociones.setFont(principal.getGotFont().deriveFont(32f));
		lblPociones.setBackground(Color.DARK_GRAY);
		lblPociones.setBounds(47, 370, 222, 81);
		add(lblPociones);

		comboBoxArmas = new JComboBox<Arma>();
		comboBoxArmas.setBounds(47, 133, 284, 22);
		add(comboBoxArmas);

		btnEliminarArmaSeleccionada = new JButton("Eliminar arma seleccionada");
		btnEliminarArmaSeleccionada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarArma();
			}
		});
		btnEliminarArmaSeleccionada.setForeground(Color.WHITE);
		btnEliminarArmaSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminarArmaSeleccionada.setFocusPainted(false);
		btnEliminarArmaSeleccionada.setContentAreaFilled(false);
		btnEliminarArmaSeleccionada.setBackground(Color.WHITE);
		btnEliminarArmaSeleccionada.setBounds(47, 87, 287, 35);
		add(btnEliminarArmaSeleccionada);

		btnEliminarArmaduraSeleccionada = new JButton("Eliminar armadura seleccionada");
		btnEliminarArmaduraSeleccionada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarArmadura();
			}
		});
		btnEliminarArmaduraSeleccionada.setForeground(Color.WHITE);
		btnEliminarArmaduraSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminarArmaduraSeleccionada.setFocusPainted(false);
		btnEliminarArmaduraSeleccionada.setContentAreaFilled(false);
		btnEliminarArmaduraSeleccionada.setBackground(Color.WHITE);
		btnEliminarArmaduraSeleccionada.setBounds(441, 87, 326, 35);
		add(btnEliminarArmaduraSeleccionada);

		comboBoxArmaduras = new JComboBox<Armadura>();
		comboBoxArmaduras.setBounds(441, 133, 284, 22);
		add(comboBoxArmaduras);

		btnAgregarArma = new JButton("Agregar arma");
		btnAgregarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarArma();
			}
		});
		btnAgregarArma.setForeground(Color.WHITE);
		btnAgregarArma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarArma.setFocusPainted(false);
		btnAgregarArma.setContentAreaFilled(false);
		btnAgregarArma.setBackground(Color.WHITE);
		btnAgregarArma.setBounds(76, 322, 202, 35);
		add(btnAgregarArma);

		btnAgregarArmadura = new JButton("Agregar armadura");
		btnAgregarArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarArmadura();
			}
		});
		btnAgregarArmadura.setForeground(Color.WHITE);
		btnAgregarArmadura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarArmadura.setFocusPainted(false);
		btnAgregarArmadura.setContentAreaFilled(false);
		btnAgregarArmadura.setBackground(Color.WHITE);
		btnAgregarArmadura.setBounds(473, 291, 227, 35);
		add(btnAgregarArmadura);

		nombreArmadura = new JTextField();
		nombreArmadura.setColumns(10);
		nombreArmadura.setBounds(512, 198, 151, 20);
		add(nombreArmadura);

		defensaArmadura = new JTextField();
		defensaArmadura.setColumns(10);
		defensaArmadura.setBounds(512, 229, 151, 20);
		add(defensaArmadura);

		valorArmadura = new JTextField();
		valorArmadura.setColumns(10);
		valorArmadura.setBounds(512, 260, 151, 20);
		add(valorArmadura);

		btnAgregarPocion = new JButton("Agregar");
		btnAgregarPocion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPocion();
			}
		});
		btnAgregarPocion.setForeground(Color.WHITE);
		btnAgregarPocion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarPocion.setFocusPainted(false);
		btnAgregarPocion.setContentAreaFilled(false);
		btnAgregarPocion.setBackground(Color.WHITE);
		btnAgregarPocion.setBounds(248, 385, 108, 42);
		add(btnAgregarPocion);

		btnQuitarPocion = new JButton("Quitar");
		btnQuitarPocion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarPocion();
			}
		});
		btnQuitarPocion.setForeground(Color.WHITE);
		btnQuitarPocion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuitarPocion.setFocusPainted(false);
		btnQuitarPocion.setContentAreaFilled(false);
		btnQuitarPocion.setBackground(Color.WHITE);
		btnQuitarPocion.setBounds(248, 438, 108, 42);
		add(btnQuitarPocion);

		lblCantidadPocion = new JLabel("Cantidad");
		lblCantidadPocion.setForeground(Color.WHITE);
		lblCantidadPocion.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCantidadPocion.setBounds(69, 451, 81, 20);
		add(lblCantidadPocion);

		cantidadDePociones = new JTextField();
		cantidadDePociones.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadDePociones.setEditable(false);
		cantidadDePociones.setColumns(10);
		cantidadDePociones.setBounds(145, 453, 51, 20);
		add(cantidadDePociones);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnVolver.setFocusPainted(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(499, 438, 184, 35);
		add(btnVolver);

		JLabel fondo = new JLabel();
		fondo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		fondo.setIcon(new ImageIcon(Panel05MercadoComercianteAdmin.class
				.getResource("/resources/images/zona2-mercado-comerciante-admin.jpg")));
		fondo.setBounds(-115, -105, 946, 733);
		add(fondo);
	}

	private void cargarArmas() {
		comboBoxArmas.removeAllItems();
		ArrayList<Arma> armas = new ArrayList<>();
		armas = comerciante.getArmasComerciante();
		for (Arma e : armas)
			comboBoxArmas.addItem(e);
	}

	private void cargarArmaduras() {
		comboBoxArmaduras.removeAllItems();
		ArrayList<Armadura> armaduras = new ArrayList<>();
		armaduras = comerciante.getArmadurasComerciante();
		for (Armadura e : armaduras)
			comboBoxArmaduras.addItem(e);
	}

	private void cargarPociones() {
		cantidadDePociones.setText(Integer.toString(comerciante.retornarCantidadDePociones()));
	}

	public void cargar(Comerciante comerciante, Mercado mercado) {
		this.comerciante = comerciante;
		this.mercado = mercado;
		cargarArmas();
		cargarArmaduras();
		cargarPociones();
	}

	private boolean comprobarDatosArma(String nombre, int ataqueMinimo, int ataqueMaximo, int valor) {
		boolean validacion = false;
		if (nombre.length() != 0 && ataqueMinimo > 0 && ataqueMaximo > ataqueMinimo && valor > 0)
			validacion = true;
		return validacion;
	}

	private boolean comprobarDatosArmadura(String nombre, int defensa, int valor) {
		boolean validacion = false;
		if (nombre.length() != 0 && defensa > 0 && valor > 0)
			validacion = true;
		return validacion;
	}

	/**
	 * Método para agregar un arma al inventario del Mercado/Comerciante. Se usan
	 * comprobaciones varias (como que el valor máx de sea mayor al mín, o valores
	 * mayores a 0). Se usa un try/catch para capturar la excepción
	 * NumberFormatException, si es que se ingresan datos en formatos erroneos, por
	 * ejemplo un String donde va un int.
	 */
	private void agregarArma() {
		String nombre;
		int ataqueMinimo;
		int ataqueMaximo;
		int valor;
		try {
			if (!nombreArma.getText().isEmpty() && !ataqueMinimoArma.getText().isEmpty()
					&& !ataqueMaximoArma.getText().isEmpty() && !valorArma.getText().isEmpty()) {
				nombre = nombreArma.getText();
				ataqueMinimo = Integer.parseInt(ataqueMinimoArma.getText());
				ataqueMaximo = Integer.parseInt(ataqueMaximoArma.getText());
				valor = Integer.parseInt(valorArma.getText());
				if (comprobarDatosArma(nombre, ataqueMinimo, ataqueMaximo, valor)) {
					Arma arma = new Arma(nombre, ataqueMinimo, ataqueMaximo, valor);
					comerciante.agregarArma(arma);
					cargarArmas();
					JOptionPane.showMessageDialog(null, "El arma fue agregada al mercado", "Arma agregada",
							JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null, "Los datos ingresados del arma no son correctos",
							"Acción inválida", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Los datos ingresados del arma no son correctos", "Acción inválida",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Los datos ingresados del arma no son correctos", "Acción inválida",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void quitarArma() {
		Arma arma = (Arma) comboBoxArmas.getSelectedItem();
		if (comerciante.quitarArma(arma))
			cargarArmas();
		else
			JOptionPane.showMessageDialog(null, "No hay nada que eliminar", "Acción invalida",
					JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Método para agregar una armadura al inventario del Mercado/Comerciante. Se
	 * usan comprobaciones varias (como valores mayores a 0). Se usa un try/catch
	 * para capturar la excepción NumberFormatException, si es que se ingresan datos
	 * en formatos erroneos, por ejemplo un String donde va un int.
	 */
	private void agregarArmadura() {
		String nombre;
		int defensa;
		int valor;
		try {
			if (!nombreArmadura.getText().isEmpty() && !defensaArmadura.getText().isEmpty()
					&& !valorArmadura.getText().isEmpty()) {
				nombre = nombreArmadura.getText();
				defensa = Integer.parseInt(defensaArmadura.getText());
				valor = Integer.parseInt(valorArmadura.getText());
				if (comprobarDatosArmadura(nombre, defensa, valor)) {
					Armadura armadura = new Armadura(nombre, defensa, valor);
					comerciante.agregarArmadura(armadura);
					cargarArmaduras();
					JOptionPane.showMessageDialog(null, "La armadura fue agregada al mercado", "Armadura agregada",
							JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null, "Los datos ingresados de la armadura no son correctos",
							"Acción inválida", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Los datos ingresados de la armadura no son correctos",
						"Acción inválida", JOptionPane.WARNING_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Los datos ingresados del arma no son correctos", "Acción inválida",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void quitarArmadura() {
		Armadura armadura = (Armadura) comboBoxArmaduras.getSelectedItem();
		if (comerciante.quitarArmadura(armadura))
			cargarArmaduras();
		else
			JOptionPane.showMessageDialog(null, "No hay nada que eliminar", "Acción inválida",
					JOptionPane.WARNING_MESSAGE);
	}

	private void agregarPocion() {
		comerciante.agregarPocion();
		cargarPociones();
	}

	private void quitarPocion() {
		if (comerciante.quitarPocion()) {
			cargarPociones();
		} else {
			JOptionPane.showMessageDialog(null, "No tienes pociones para quitar", "Acción inválida",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Al usar este metodo se guarda en disco el inventario actual que se tenga en
	 * el Mercado (incluyendo cualquier item nuevo que se haya creado). Usar con
	 * cuidado.
	 */
	private void guardar() {
		Archivo<Comerciante> archivo = new Archivo<Comerciante>();
		if(archivo.guardarDatos(comerciante, mercado.getDireccion()))
			JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", "Guardado", JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "No se pudo guardar", "Guardado", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Al usar este metodo se vuelve sin guardar en disco los items nuevos que se
	 * hayan agregado al Mercado (una vez cerrado el programa se perderan).
	 */
	private void volver() {
		principal.getPanel05MercadoComerciante().actualizarStock();
		principal.intercambiarPaneles(principal.getPanel05MercadoComerciante());
	}
}