package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import personajes.Jugador;

/**
 * Esta clase contiene el panel que se muestra al derrotar al dragón. Aquí sale
 * un botón para ver la estadísticas (pasar al panel Jugadores).
 */
public class Panel14Final extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private FramePrincipal principal;
	private Jugador jugador;

	public Panel14Final(FramePrincipal principal) {
		this.principal = principal;
		setBackground(Color.BLACK);
		setLayout(null);

		textField = new JTextField();
		textField.setText("Fin del juego. Gracias por jugar");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.BLACK);
		textField.setBounds(274, 360, 271, 28);
		add(textField);

		JButton btnVerEstadisticas = new JButton("VER ESTADISTICAS");
		btnVerEstadisticas.setFocusPainted(false);
		btnVerEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlPanelEstadisticas(jugador);
			}
		});
		btnVerEstadisticas.setBackground(Color.WHITE);
		btnVerEstadisticas.setForeground(Color.BLACK);
		btnVerEstadisticas.setFont(principal.getGotFont().deriveFont(16f));
		btnVerEstadisticas.setBounds(297, 420, 227, 47);
		add(btnVerEstadisticas);

		JLabel lblNewLabel = new JLabel(new ImageIcon(Panel14Final.class.getResource("/resources/images/final.png")));
		lblNewLabel.setBounds(-25, -93, 879, 618);
		add(lblNewLabel);
	}

	public void cargarJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	private void irAlPanelEstadisticas(Jugador jugador) {
		principal.getPanel15Jugadores().estadisticas(jugador);
		principal.intercambiarPaneles(principal.getPanel15Jugadores());
	}
}