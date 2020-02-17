package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import personajes.Jugador;

/**
 * Esta clase contiene un panel donde se introduce el nombre del jugador.
 */
public class Panel02Nombre extends JPanel {

	private static final long serialVersionUID = 1L;
	private FramePrincipal principal;
	private JTextField nombre;
	private JButton btnContinuar;

	public Panel02Nombre(FramePrincipal principal) {
		this.principal = principal;
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel tuNombre = new JLabel("TU NOMBRE");
		tuNombre.setFont(principal.getGotFont().deriveFont(32f));
		tuNombre.setForeground(Color.WHITE);
		tuNombre.setBackground(Color.DARK_GRAY);
		tuNombre.setBounds(117, 30, 484, 142);
		add(tuNombre);

		nombre = new JTextField();
		nombre.setOpaque(false);
		nombre.setBackground(Color.BLACK);
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setForeground(Color.WHITE);
		nombre.setFont(principal.getGotFont().deriveFont(32f));
		nombre.setBounds(384, 73, 305, 58);
		add(nombre);
		nombre.setColumns(10);

		btnContinuar = new JButton("CONTINUAR");
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel();
			}
		});
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnContinuar.setBounds(317, 446, 184, 26);
		add(btnContinuar);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Panel02Nombre.class.getResource("/resources/images/nombre.gif")));
		fondo.setBounds(-205, 0, 1080, 692);
		add(fondo);
	}

	/**
	 * Aquí "arranca" el juego. Al ingresar un nombre correcto se puede crear al
	 * Jugador y cargar el dato de la hora/dia en que empezó a jugar.
	 */
	private void cambiarPanel() {
		String nombreJugador = nombre.getText();
		if (!nombreJugador.equals("")) {
			Jugador jugador = principal.retornarJugador();
			jugador.setNombre(nombreJugador);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime ahora = LocalDateTime.now();
			jugador.setFechaDeInicio(dtf.format(ahora));
			jugador.setMomentoInicio(System.nanoTime());
			principal.getPanel0Inventario().cargarDatosDelJugadorEnElInventario();
			principal.intercambiarPaneles(principal.getPanel3Historia());
		}
	}
}