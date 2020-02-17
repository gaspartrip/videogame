package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel inicial del juego. Solo contiene un label con un fondo.
 */
public class Panel01Comienzo extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel01Comienzo() {
		setBackground(Color.BLACK);
		setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(Panel01Comienzo.class.getResource("/resources/images/fondo.png")));
		lblNewLabel.setBounds(0, -17, 828, 533);
		add(lblNewLabel);
	}
}