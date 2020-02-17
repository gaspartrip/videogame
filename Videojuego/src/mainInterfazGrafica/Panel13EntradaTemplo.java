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
public class Panel13EntradaTemplo extends JPanelPadre {
	private static final long serialVersionUID = 1L;
	private JButton botonEnfrentarAlDragon;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private Templo templo;

	public Panel13EntradaTemplo(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		templo = getPrincipal().retornarTemplo();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(templo.getMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(
				new ImageIcon(Panel13EntradaTemplo.class.getResource("/resources/images/zona10-entrada-templo.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		botonEnfrentarAlDragon = new JButton("Enfrentar al no-muerto");
		botonEnfrentarAlDragon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonEnfrentarAlDragon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enfentarAlNoMuerto();
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
	 * Inicia una batalla con el enemigo No Muerto, sin huída, por eso el null en
	 * donde va el panel anterior.
	 */
	private void enfentarAlNoMuerto() {
		if (!templo.isEnfrentamientoNoMuerto()) {
			templo.setEnfrentamientoNoMuerto(true);
			getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel13Templo(), null, templo.getNoMuerto(),
					"/resources/images/enemigo-nomuerto.jpg");
			botonEnfrentarAlDragon.setText("Continuar");
			areaCentral.setText(templo.getMensajeInicialAlternativo());
		} else {
			getPrincipal().intercambiarPaneles(getPrincipal().getPanel13Templo());
		}
	}

	private void volver() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel8Ruinas());
	}
}