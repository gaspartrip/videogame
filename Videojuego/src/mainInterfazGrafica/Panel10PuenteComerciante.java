package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import juegoYZonas.Puente;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene a la clase/zona Puente y al enemigo Bandido.
 */
public class Panel10PuenteComerciante extends JPanelPadre implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private String estado = "inicial";
	private JButton eleccion1;
	private JButton eleccion2;
	private JButton eleccion3;
	private Puente puente;

	public Panel10PuenteComerciante(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		puente = getPrincipal().retornarPuente();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText("El bandido te habla:\r\n\r\n" + getPrincipal().retornarPuente().getBandido().advertir());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(
				Panel10PuenteComerciante.class.getResource("/resources/images/zona7-puente-comerciante.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		eleccion1 = new JButton("Atacar");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.setActionCommand("c1");
		eleccion1.addActionListener(this);
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 317, 298, 31);
		add(eleccion1);

		eleccion2 = new JButton("Intentar dialogar");
		eleccion2.setActionCommand("c2");
		eleccion2.addActionListener(this);
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 359, 298, 31);
		add(eleccion2);

		eleccion3 = new JButton("Irse");
		eleccion3.setActionCommand("c3");
		eleccion3.addActionListener(this);
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 401, 298, 31);
		add(eleccion3);
	}

	private void ocultarBoton1() {
		eleccion1.setVisible(false);
	}

	private void ocultarBoton2() {
		eleccion2.setVisible(false);
	}

	private void ocultarBoton3() {
		eleccion3.setVisible(false);
	}

	private void ocultarBoton2y3() {
		eleccion2.setVisible(false);
		eleccion3.setVisible(false);
	}

	private void mostrarBoton1() {
		eleccion1.setVisible(true);
	}

	private void mostrarBoton2() {
		eleccion2.setVisible(true);
	}

	private void intentarDialogar() {
		estado = "dialogo1";
		String conversacion = getPrincipal().retornarPuente().getBandido().amenazar();
		areaCentral.setText(conversacion);
		eleccion1.setText("Deja ir a la chica, no quiero matarte"); // Conduce a intentarDialogar2
		eleccion3.setText("Sueltala o muere"); // Conduce a intentarDialogar7
		ocultarBoton2();
	}

	private void intentarDialogar2() {
		estado = "dialogo2";
		String conversacion = getPrincipal().retornarPuente().getBandido().negociar();
		areaCentral.setText(conversacion);
		eleccion1.setText("Te ofrezco oro"); // Conduce a intentarDialogar3
		eleccion3.setText("Cambie de opinión, voy a matarte"); // Conduce a irAlAtaque
	}

	private void intentarDialogar3() {
		estado = "dialogo3";
		String conversacion = getPrincipal().retornarPuente().getBandido().preguntarPorElOro();
		areaCentral.setText(conversacion);
		if (getPrincipal().retornarJugador().getOro() >= puente.getOroMaximoRescate())
			eleccion1.setText("Te ofrezco " + puente.getOroMaximoRescate() + " monedas de oro"); // Conduce a
																									// intentarDialogar5
		else
			ocultarBoton1();
		eleccion3.setText("Solo mereces " + puente.getOroMinimoRescate() + " monedas de oro"); // Conduce a
																								// intentarDialogar4
	}

	private void intentarDialogar4() {
		estado = "dialogo4";
		String conversacion = getPrincipal().retornarPuente().getBandido().echarViolentamente();
		areaCentral.setText(conversacion);
		if (getPrincipal().retornarJugador().getOro() >= puente.getOroMaximoRescate()) {
			mostrarBoton1();
			eleccion1.setText("Te ofrezco " + puente.getOroMaximoRescate() + " monedas de oro");
		}
		mostrarBoton2();
		eleccion2.setText("Atacar");
		eleccion3.setText("Irse");
	}

	private void intentarDialogar5() {
		estado = "dialogo5";
		String conversacion = getPrincipal().retornarPuente().getBandido().acordar() + "\n\n[-"
				+ puente.getOroMaximoRescate() + " de oro]\n\n[+" + puente.getCantidadDePocionesDeLoot() + " pociones]";
		getPrincipal().retornarJugador().disminuirOro(puente.getOroMaximoRescate());
		cargarHudOro();
		getPrincipal().retornarJugador().aumentarPociones(puente.getCantidadDePocionesDeLoot());
		areaCentral.setText(conversacion);
		ocultarBoton2y3();
		eleccion1.setText(">");
	}

	private boolean dineroSuficiente() {
		if (getPrincipal().retornarJugador().getOro() >= puente.getOroMinimoRescate())
			return true;
		else
			return false;
	}

	private void intentarDialogar6() {
		estado = "dialogo6";
		String conversacion = getPrincipal().retornarPuente().getBandido().echar();
		areaCentral.setText(conversacion);
		eleccion1.setText("Atacar");
		ocultarBoton2();
		eleccion3.setText("Irse");
	}

	private void intentarDialogar7() {
		estado = "dialogo7";
		String conversacion = getPrincipal().retornarPuente().getBandido().amenazarViolentamente();
		areaCentral.setText(conversacion);
		ocultarBoton3();
		eleccion1.setText(">");
	}

	private void irAlAtaque() {
		puente.setBatallaBandido(true);
		getPrincipal().getPanel10Puente().cambiarMensajeAMensajeTrasEncuentroConBandido();
		getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel10Puente(), getPrincipal().getPanel10Puente(),
				puente.getBandido(), "/resources/images/enemigo-bandido.jpg");
	}

	private void volverAlPuente() {
		getPrincipal().getPanel10Puente().cambiarMensajeAMensajeTrasEncuentroConBandido();
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel10Puente());
	}

	private void irAlPuente() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel10Puente());
	}

	/**
	 * Según el botón presionado y el valor de String estado se llama X método.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (estado) {
		case "inicial":
			if (e.getActionCommand().equals("c1")) {
				irAlAtaque();
			} else if (e.getActionCommand().equals("c2")) {
				intentarDialogar();
			} else if (e.getActionCommand().equals("c3")) {
				irAlPuente();
			}
			break;
		case "dialogo1":
			if (e.getActionCommand().equals("c1")) {
				intentarDialogar2();
			} else if (e.getActionCommand().equals("c3")) {
				intentarDialogar7();
			}
			break;
		case "dialogo2":
			if (e.getActionCommand().equals("c1")) {
				if (dineroSuficiente()) {
					intentarDialogar3();
				} else
					intentarDialogar6();

			} else if (e.getActionCommand().equals("c3")) {
				irAlAtaque();
			}
			break;
		case "dialogo3":
			if (e.getActionCommand().equals("c1")) {
				intentarDialogar5();
			} else if (e.getActionCommand().equals("c3")) {
				intentarDialogar4();
			}
			break;
		case "dialogo4":
			if (e.getActionCommand().equals("c1")) {
				intentarDialogar5();
			} else if (e.getActionCommand().equals("c2")) {
				irAlAtaque();
			} else if (e.getActionCommand().equals("c3")) {
				irAlPuente();
			}
			break;
		case "dialogo5":
			if (e.getActionCommand().equals("c1")) {
				volverAlPuente();
			}
			break;
		case "dialogo6":
			if (e.getActionCommand().equals("c1")) {
				irAlAtaque();
			} else if (e.getActionCommand().equals("c3")) {
				irAlPuente();
			}
			break;
		case "dialogo7":
			if (e.getActionCommand().equals("c1")) {
				irAlAtaque();
			}
			break;
		}
	}
}