package mainInterfazGrafica;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Esta clase contiene el panel que sale al morir en el juego.
 */
public class PanelBatallaMuerte extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtHasMuerto;
	private JLabel fotoHasMuerto;

	public PanelBatallaMuerte() {
		setBackground(Color.BLACK);
		setLayout(null);
		fotoHasMuerto = new JLabel("");
		fotoHasMuerto.setBounds(102, 172, 597, 112);
		add(fotoHasMuerto);

		txtHasMuerto = new JTextField();
		txtHasMuerto.setHorizontalAlignment(SwingConstants.CENTER);
		txtHasMuerto.setEditable(false);
		txtHasMuerto.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtHasMuerto.setForeground(Color.WHITE);
		txtHasMuerto.setBackground(Color.BLACK);
		txtHasMuerto.setText("Has muerto");
		txtHasMuerto.setBounds(360, 424, 96, 20);
		add(txtHasMuerto);
		txtHasMuerto.setColumns(10);
	}

	public void reproducirGif() {
		fotoHasMuerto.setIcon(new ImageIcon(PanelBatallaMuerte.class.getResource("/resources/images/has muerto.gif")));
	}
}