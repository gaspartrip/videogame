package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import juegoYZonas.Cueva;
import juegoYZonas.Ruinas;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene el panel que contiene la clase Cueva. Aquí se encuentra
 * la llave del templo de las ruinas (por eso se trae por parámetro a la clase
 * Ruinas).
 */
public class Panel12CuevaParte5 extends JPanelPadre {
	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private Cueva cueva;
	private Ruinas ruinas;

	public Panel12CuevaParte5(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		cueva = getPrincipal().retornarCueva();
		ruinas = getPrincipal().retornarRuinas();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cueva.getMensajeInicialCuevaParte5());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel12CuevaParte5.class.getResource("/resources/images/zona9cueva-parte5.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton botonNadarATierra = new JButton("Nadar a tierra");
		botonNadarATierra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nadarATierra();
			}
		});
		botonNadarATierra.setBackground(Color.WHITE);
		botonNadarATierra.setForeground(Color.BLACK);
		botonNadarATierra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonNadarATierra.setBounds(423, 359, 298, 31);
		add(botonNadarATierra);
	}

	private void nadarATierra() {
		getPrincipal().encuentroAleatorioActivarHuir();
		ruinas.setLlave(true);
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel12CuevaParte6());
	}
}