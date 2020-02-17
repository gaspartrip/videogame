package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import personajes.HabilidadDeAtaque;
import personajes.HabilidadDeDefensa;
import java.awt.SystemColor;

/**
 * Esta clase contiene el panel de habilidades del jugador. Al tocar un botón de
 * una habilidad, se llama al método usarHabilidadDeAtaque o
 * usarHabilidadDeDefensa en el panel de batalla.
 */
public class PanelBatallaHabilidades extends JPanel {

	private static final long serialVersionUID = 1L;
	private FramePrincipal principal;
	private HashMap<Integer, HabilidadDeAtaque> hda;
	private HabilidadDeDefensa hdd;

	public PanelBatallaHabilidades(FramePrincipal principal) {
		this.principal = principal;
		hda = principal.retornarJugador().getHabilidadesDeAtaque();
		hdd = principal.retornarJugador().getHabilidadDeDefensa();

		setBackground(Color.BLACK);
		setLayout(null);

		JButton botonNovaDeEscarcha = new JButton();
		botonNovaDeEscarcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usarNovaDeEscarcha();
			}
		});
		botonNovaDeEscarcha.setContentAreaFilled(false);
		botonNovaDeEscarcha.setBackground(SystemColor.activeCaptionBorder);
		botonNovaDeEscarcha.setBounds(168, 226, 62, 62);
		add(botonNovaDeEscarcha);

		JButton botonGolpeDeCruzado = new JButton();
		botonGolpeDeCruzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usarGolpeDeCruzado();
			}
		});
		botonGolpeDeCruzado.setContentAreaFilled(false);
		botonGolpeDeCruzado.setBackground(SystemColor.activeCaptionBorder);
		botonGolpeDeCruzado.setBounds(168, 296, 62, 62);
		add(botonGolpeDeCruzado);

		JButton botonBarreraDivina = new JButton();
		botonBarreraDivina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usarBarreraDivina();
			}
		});
		botonBarreraDivina.setContentAreaFilled(false);
		botonBarreraDivina.setBackground(SystemColor.activeCaptionBorder);
		botonBarreraDivina.setBounds(168, 369, 62, 62);
		add(botonBarreraDivina);

		JButton botonBolaDeFuego = new JButton();
		botonBolaDeFuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usarBolaDeFuego();
			}
		});
		botonBolaDeFuego.setContentAreaFilled(false);
		botonBolaDeFuego.setBackground(SystemColor.activeCaptionBorder);
		botonBolaDeFuego.setBounds(168, 153, 62, 62);
		add(botonBolaDeFuego);

		JLabel tuNombre = new JLabel("Selecciona la habilidad");
		tuNombre.setFont(principal.getGotFont().deriveFont(32f));
		tuNombre.setForeground(Color.WHITE);
		tuNombre.setBackground(Color.DARK_GRAY);
		tuNombre.setBounds(168, 0, 597, 142);
		add(tuNombre);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel
				.setIcon(new ImageIcon(PanelBatallaHabilidades.class.getResource("/resources/images/bolaDeFuego.png")));
		lblNewLabel.setBounds(168, 153, 62, 62);
		add(lblNewLabel);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(PanelBatallaHabilidades.class.getResource("/resources/images/novaDeEscarcha.png")));
		label.setBounds(168, 226, 62, 62);
		add(label);

		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(
				new ImageIcon(PanelBatallaHabilidades.class.getResource("/resources/images/golpeDeCruzado.png")));
		label_1.setBounds(168, 296, 62, 62);
		add(label_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(
				new ImageIcon(PanelBatallaHabilidades.class.getResource("/resources/images/barreraDivina.png")));
		label_2.setBounds(168, 369, 62, 62);
		add(label_2);

		JTextArea txtrBolaDeFuego = new JTextArea();
		txtrBolaDeFuego.setEditable(false);
		txtrBolaDeFuego.setForeground(new Color(255, 228, 225));
		txtrBolaDeFuego.setFont(new Font("Cambria Math", Font.BOLD, 14));
		txtrBolaDeFuego.setOpaque(false);
		txtrBolaDeFuego.setText("|" + hda.get(1).getNombre() + "|\r\nLanza al enemigo una bola \u00EDgnea que causa "
				+ hda.get(1).getDañoMin() + "-" + hda.get(1).getDañoMax()
				+ " puntos de da\u00F1o.\r\nContra enemigos de tipo " + hda.get(1).getClaseDañoBonus() + " causa un "
				+ (int) hda.get(1).getPorcentajeDañoBonus() + "% más de daño.");
		txtrBolaDeFuego.setBounds(256, 153, 509, 62);
		add(txtrBolaDeFuego);

		JTextArea txtrNovaDeEscarcha = new JTextArea();
		txtrNovaDeEscarcha.setEditable(false);
		txtrNovaDeEscarcha.setForeground(new Color(255, 228, 225));
		txtrNovaDeEscarcha
				.setText("|" + hda.get(2).getNombre() + "|\r\nLanza al enemigo una nova de escarcha que causa "
						+ hda.get(2).getDañoMin() + "-" + hda.get(2).getDañoMax()
						+ " puntos de\r\nda\u00F1o. Contra enemigos de tipo " + hda.get(2).getClaseDañoBonus()
						+ " causa un " + (int) hda.get(2).getPorcentajeDañoBonus() + "% más de daño.");
		txtrNovaDeEscarcha.setOpaque(false);
		txtrNovaDeEscarcha.setFont(new Font("Cambria Math", Font.BOLD, 14));
		txtrNovaDeEscarcha.setBounds(255, 226, 509, 62);
		add(txtrNovaDeEscarcha);

		JTextArea txtrGolpeDeCruzado = new JTextArea();
		txtrGolpeDeCruzado.setEditable(false);
		txtrGolpeDeCruzado.setForeground(new Color(255, 228, 225));
		txtrGolpeDeCruzado.setText("|" + hda.get(3).getNombre() + "|\r\nGolpea al enemigo y le causa "
				+ hda.get(3).getDañoMin() + "-" + hda.get(3).getDañoMax()
				+ " puntos de da\u00F1o. Contra \nenemigos de tipo " + hda.get(3).getClaseDañoBonus() + " causa un "
				+ (int) hda.get(3).getPorcentajeDañoBonus() + "% más de daño.");
		txtrGolpeDeCruzado.setOpaque(false);
		txtrGolpeDeCruzado.setFont(new Font("Cambria Math", Font.BOLD, 14));
		txtrGolpeDeCruzado.setBounds(255, 296, 509, 62);
		add(txtrGolpeDeCruzado);

		JTextArea txtrBarreraDivina = new JTextArea();
		txtrBarreraDivina.setEditable(false);
		txtrBarreraDivina.setForeground(new Color(255, 228, 225));
		txtrBarreraDivina.setText("|" + hdd.getNombre()
				+ "|\r\nInvoca un escudo m\u00E1gico que reduce el da\u00F1o recibido por enemigos\nde tipo NoHumanoide un "
				+ (int) (hdd.getPorcentajeAtaqueAbsorbido() * 100) + "%\r durante "
				+ principal.retornarJugador().getTurnosHabilidad() + " turnos.");
		txtrBarreraDivina.setOpaque(false);
		txtrBarreraDivina.setFont(new Font("Cambria Math", Font.BOLD, 14));
		txtrBarreraDivina.setBounds(255, 369, 509, 62);
		add(txtrBarreraDivina);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setContentAreaFilled(false);
		btnVolver.setFocusPainted(false);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAlPanelDeBatallaSinElegirHabilidad();
			}
		});
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnVolver.setBounds(317, 446, 184, 35);
		add(btnVolver);

		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(PanelBatallaHabilidades.class.getResource("/resources/images/habilidades.png")));
		fondo.setBounds(0, 0, 1157, 556);
		add(fondo);
	}

	private void usarBolaDeFuego() {
		volverAlPanelDeBatalla();
		principal.getPanel0Batalla().usarHabilidadDeAtaque(1);
	}

	private void usarNovaDeEscarcha() {
		volverAlPanelDeBatalla();
		principal.getPanel0Batalla().usarHabilidadDeAtaque(2);
	}

	private void usarGolpeDeCruzado() {
		volverAlPanelDeBatalla();
		principal.getPanel0Batalla().usarHabilidadDeAtaque(3);
	}

	private void usarBarreraDivina() {
		volverAlPanelDeBatalla();
		principal.getPanel0Batalla().usarHabilidadDeDefensa();
	}

	private void volverAlPanelDeBatalla() {
		principal.irDelPanelHabilidadesAlPanelBatalla();
	}

	private void volverAlPanelDeBatallaSinElegirHabilidad() {
		volverAlPanelDeBatalla();
		principal.getPanel0Batalla().setearHudPanelHabilidadesAlPanelDeBatallaSinElegirHabilidad();
	}
}