package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import juegoYZonas.Templo;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene el panel que contiene la clase Templo
 */
public class Panel13Templo extends JPanelPadre {
	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private Templo templo;

	public Panel13Templo(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		templo = getPrincipal().retornarTemplo();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(templo.getMensajeInicial2());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel13Templo.class.getResource("/resources/images/zona10-templo.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton botonEnfrentarAlDragon = new JButton("Enfrentar al drag\u00F3n");
		botonEnfrentarAlDragon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonEnfrentarAlDragon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enfrentarAlDragon();
			}
		});
		botonEnfrentarAlDragon.setForeground(Color.BLACK);
		botonEnfrentarAlDragon.setBackground(Color.WHITE);
		botonEnfrentarAlDragon.setBounds(423, 323, 298, 31);
		add(botonEnfrentarAlDragon);

		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		botonVolver.setBackground(Color.WHITE);
		botonVolver.setForeground(Color.BLACK);
		botonVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonVolver.setBounds(423, 407, 298, 31);
		add(botonVolver);
	}

	/**
	 * Inicia una batalla con el enemigo final Dragón, sin huída, por eso el null en
	 * donde va el panel anterior.
	 */
	private void enfrentarAlDragon() {
		getPrincipal().reproducirSonidoAtaqueDragon();
		getPrincipal().prepararEnfrentamiento(null, null, templo.getDragon(), "/resources/images/enemigo-dragon.gif");
	}

	private void volver() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel13EntradaTemplo());
	}
}