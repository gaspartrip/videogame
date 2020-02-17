package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import juegoYZonas.Cementerio;
import juegoYZonas.Puente;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene a la clase/zona Puente.
 */
public class Panel10Puente extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton eleccion2;
	private Puente puente;
	private Cementerio cementerio;

	public Panel10Puente(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		puente = getPrincipal().retornarPuente();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(puente.getMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel10Puente.class.getResource("/resources/images/zona7-puente.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton eleccion1 = new JButton("Ir a Brisapura");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion1();
			}
		});
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 317, 298, 31);
		add(eleccion1);

		eleccion2 = new JButton("Ayudar al comerciante");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion2();
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 359, 298, 31);
		add(eleccion2);

		JButton eleccion3 = new JButton("Ir al cementerio");
		eleccion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion3();
			}
		});
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 401, 298, 31);
		add(eleccion3);
	}

	private String mensajeTrasRescate() {
		return puente.getMensajeInicialAlEncontrarteConBandido();
	}

	public void cambiarMensajeAMensajeTrasEncuentroConBandido() {
		eleccion2.setVisible(false);
		areaCentral.setText(mensajeTrasRescate());
	}

	private void eleccion1() {
		cambiarMensajeAMensajeTrasEncuentroConBandido();
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel11Brisapura());
	}

	private void eleccion2() {
		cambiarMensajeAMensajeTrasEncuentroConBandido();
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel10PuenteComerciante());
	}

	private void eleccion3() {
		cementerio = getPrincipal().retornarCementerio();
		cambiarMensajeAMensajeTrasEncuentroConBandido();
		getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel9CementerioParte2(), this, cementerio.getNigromante(), "/resources/images/enemigo-nigromante.jpg");
	}
}