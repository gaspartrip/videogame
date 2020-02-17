package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import juegoYZonas.Cementerio;

/**
 * Esta clase contiene el panel que contiene la clase Cementerio.
 */
public class Panel09CementerioParte2 extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private Cementerio cementerio;

	public Panel09CementerioParte2(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		cementerio = getPrincipal().retornarCementerio();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cementerio.getMensajeInicialParte2());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);
		ambiente = new JLabel(
				new ImageIcon(Panel09CementerioParte2.class.getResource("/resources/images/zona6-cementerio-parte2.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton eleccion1 = new JButton("Ir al puente");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion1();
			}
		});
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 323, 298, 31);
		add(eleccion1);

		JButton eleccion2 = new JButton("Ir hacia las ruinas");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion2();
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 407, 298, 31);
		add(eleccion2);
	}

	private String retornarMensajeTrasToparteConNigromante() {
		return cementerio.getMensajeInicialPorSegundaVezParte2();
	}

	private void eleccion1() {
		areaCentral.setText(retornarMensajeTrasToparteConNigromante());
		getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel10Puente(), this, cementerio.getNigromante(), "/resources/images/enemigo-nigromante.jpg");
	}

	private void eleccion2() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel9Cementerio());
	}
}