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
 * Esta clase contiene el panel que se usa para ir directo al panel 12 Cueva o
 * al panel 4 Ciudad (mediante un mapa).
 */
public class Panel11ManticoraViaje extends JPanel {

	private static final long serialVersionUID = 1L;
	private FramePrincipal principal;
	private JButton botonCueva;

	public Panel11ManticoraViaje(FramePrincipal principal) {
		this.principal = principal;
		setBackground(Color.BLACK);
		setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		btnSalir.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
		btnSalir.setBounds(360, 471, 101, 29);
		add(btnSalir);

		botonCueva = new JButton("");
		botonCueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viajarALaCueva();
			}
		});
		botonCueva.setIcon(new ImageIcon(Panel11ManticoraViaje.class.getResource("/resources/images/icono.png")));
		botonCueva.setForeground(Color.DARK_GRAY);
		botonCueva.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
		botonCueva.setBackground(Color.DARK_GRAY);
		botonCueva.setBounds(187, 294, 24, 19);
		add(botonCueva);

		JButton botonCantoblanco = new JButton("");
		botonCantoblanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viajarACantoblanco();
			}
		});
		botonCantoblanco.setIcon(new ImageIcon(Panel11ManticoraViaje.class.getResource("/resources/images/icono.png")));
		botonCantoblanco.setForeground(Color.WHITE);
		botonCantoblanco.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
		botonCantoblanco.setBackground(Color.BLACK);
		botonCantoblanco.setBounds(631, 53, 24, 19);
		add(botonCantoblanco);

		JLabel mapa = new JLabel("");
		mapa.setIcon(new ImageIcon(Panel11ManticoraViaje.class.getResource("/resources/images/mapaDeViaje.jpg")));
		mapa.setBounds(69, -11, 693, 619);
		add(mapa);
	}

	private void viajarALaCueva() {
		principal.intercambiarPaneles(principal.getPanel12Cueva());
		botonCueva.setVisible(false);
	}

	private void viajarACantoblanco() {
		principal.intercambiarPaneles(principal.getPanel4Ciudad());
	}

	private void volver() {
		principal.intercambiarPaneles(principal.getPanel11Manticora());
	}
}