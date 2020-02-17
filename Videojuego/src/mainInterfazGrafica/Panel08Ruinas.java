package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import juegoYZonas.Bosque;
import juegoYZonas.Ruinas;

/**
 * Esta clase contiene el panel que contiene la clase Ruinas.
 */
public class Panel08Ruinas extends JPanelPadre implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton eleccion1;
	private JButton eleccion2;
	private JButton eleccion3;
	private boolean textoDePuerta = false;
	private Ruinas ruinas;
	private Bosque bosque;

	public Panel08Ruinas(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		ruinas = getPrincipal().retornarRuinas();
		bosque = getPrincipal().retornarBosque();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(getMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel08Ruinas.class.getResource("/resources/images/zona5-ruinas.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		eleccion1 = new JButton("Entrar al templo");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.setActionCommand("c1");
		eleccion1.addActionListener(this);
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 323, 298, 31);
		add(eleccion1);
		eleccion2 = new JButton("Ir al cementerio");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlCementerio();
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 365, 298, 31);
		add(eleccion2);

		eleccion3 = new JButton("Ir al bosque");
		eleccion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion3();
			}
		});
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 407, 298, 31);
		add(eleccion3);
	}

	private String getMensajeInicial() {
		return ruinas.getMensajeInicial();
	}

	private void setTextoDePuerta(boolean bandera) {
		textoDePuerta = bandera;
	}

	private void entrarAlTemplo() {
		if (!ruinas.isLlave()) {
			setTextoDePuerta(true);
			String mensaje = ruinas.getMensajeAlIntentarEntrarAlTemplo();
			areaCentral.setText(mensaje);
			eleccion1.setText(">");
			eleccion2.setVisible(false);
			eleccion3.setVisible(false);
		} else {
			getPrincipal().intercambiarPaneles(getPrincipal().getPanel13EntradaTemplo());
		}
	}

	private void activarMensajeInicial() {

		setTextoDePuerta(false);
		areaCentral.setText(getMensajeInicial());
		eleccion1.setText("Entrar");
		eleccion2.setVisible(true);
		eleccion3.setVisible(true);
	}

	/**
	 * Método random que según una probabilidad pasa al siguiente panel, o según la
	 * otra probabilidad se inicia un ataque sin huída (por eso manda null en donde
	 * va el panel anterior) con un enemigo.
	 */
	private void irAlCementerio() {
		double x = Math.random();
		if (x > 0.4) {
			getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel9Cementerio(), null,
					getPrincipal().retornarCementerio().getSquirtle(), "/resources/images/enemigo-squirtle.jpg");
		} else {
			getPrincipal().intercambiarPaneles(getPrincipal().getPanel9Cementerio());

		}
	}

	private void eleccion3() {
		getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel7Bosque(), this, bosque.getLobo(),
				"/resources/images/enemigo-lobo.jpg");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!textoDePuerta) {
			if (e.getActionCommand().equals("c1")) {
				entrarAlTemplo();
			}
		} else {
			if (e.getActionCommand().equals("c1")) {
				activarMensajeInicial();
			}
		}
	}
}