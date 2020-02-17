package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase contiene un mapa de la zona.
 */
public class Panel04CiudadMapa extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel04CiudadMapa(FramePrincipal principal) {
		setBackground(Color.BLACK);
		setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.intercambiarPaneles(principal.getPanel4Ciudad());
			}
		});
		btnSalir.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
		btnSalir.setBounds(360, 471, 101, 29);
		add(btnSalir);

		JLabel mapa = new JLabel("");
		mapa.setIcon(new ImageIcon(Panel04CiudadMapa.class.getResource("/resources/images/mapa.jpg")));
		mapa.setBounds(67, 0, 800, 516);
		add(mapa);
	}
}