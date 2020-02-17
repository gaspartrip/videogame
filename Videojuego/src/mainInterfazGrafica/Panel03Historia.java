package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Esta clase muestra un texto introductorio, antes de empezar el juego.
 */
public class Panel03Historia extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel03Historia(FramePrincipal principal) {
		setBackground(Color.BLACK);
		setLayout(null);
		JTextPane txtpnMientrasLosVientos = new JTextPane();
		txtpnMientrasLosVientos.setEditable(false);
		txtpnMientrasLosVientos.setForeground(Color.WHITE);
		txtpnMientrasLosVientos.setBackground(Color.BLACK);
		txtpnMientrasLosVientos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnMientrasLosVientos.setText(principal.getJuego().retornarMensajeAlIniciarJuego());
		txtpnMientrasLosVientos.setBounds(73, 71, 693, 244);
		add(txtpnMientrasLosVientos);

		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.intercambiarPaneles(principal.getPanel4Ciudad());
			}
		});
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnContinuar.setBounds(317, 446, 184, 26);
		add(btnContinuar);
	}
}