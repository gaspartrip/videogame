package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import juegoYZonas.Taberna;

/**
 * Esta clase contiene el panel que contiene la clase Taberna y al tabernero.
 */
public class Panel06Taberna extends JPanelPadre implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private String textoBienvenida;
	private JButton eleccion1;
	private JButton eleccion2;
	private JButton eleccion3;
	private JButton eleccion4;
	private JButton eleccion5;
	private String estado = "inicial";
	private Taberna taberna;

	public Panel06Taberna(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		taberna = getPrincipal().retornarTaberna();

		textoBienvenida = retornarTextoBienvenida();
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(textoBienvenida);
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel05Mercado.class.getResource("/resources/images/zona3-taberna.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		eleccion1 = new JButton("Estoy buscando al drag\u00F3n...");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.setActionCommand("c1");
		eleccion1.addActionListener(this);
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 295, 298, 20);
		add(eleccion1);

		eleccion2 = new JButton("Qu\u00E9 sitio tan concurrido...");
		eleccion2.setActionCommand("c2");
		eleccion2.addActionListener(this);
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 326, 298, 20);
		add(eleccion2);

		eleccion3 = new JButton("\u00BFD\u00F3nde consigo equipamiento?");
		eleccion3.setActionCommand("c3");
		eleccion3.addActionListener(this);
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 357, 298, 20);
		add(eleccion3);

		eleccion4 = new JButton("Pedir una botella de r\u00F3n");
		eleccion4.setActionCommand("c4");
		eleccion4.addActionListener(this);
		eleccion4.setBackground(Color.WHITE);
		eleccion4.setForeground(Color.BLACK);
		eleccion4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion4.setBounds(423, 388, 298, 20);
		add(eleccion4);

		eleccion5 = new JButton("Volver al centro de la ciudad");
		eleccion5.setActionCommand("c5");
		eleccion5.addActionListener(this);
		eleccion5.setForeground(Color.BLACK);
		eleccion5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion5.setBackground(Color.WHITE);
		eleccion5.setBounds(423, 418, 298, 20);
		add(eleccion5);
	}

	public void mostrarTextoBienvenidaEnElPanel() {
		areaCentral.setText(retornarTextoBienvenida());
	}

	private void mostrarTextoTaberneroUnaVezQueYaHablaste() {
		areaCentral.setText(retornarTextoTaberneroUnaVezQueYaHablaste());
	}

	private String retornarTextoBienvenida() {
		return "El tabernero te habla:\r\n\r\n- Bienvenido, forastero. \u00BFQu\u00E9 necesitas?";
	}

	private String retornarTextoTaberneroUnaVezQueYaHablaste() {
		return "El tabernero te habla:\r\n\r\n - ¿Qué necesitas forastero?";
	}

	private void hacerVisiblesTodosLosBotones() {
		eleccion1.setVisible(true);
		eleccion2.setVisible(true);
		eleccion3.setVisible(true);
		eleccion4.setVisible(true);
		eleccion5.setVisible(true);
	}

	private void ocultarBotones2a5() {
		eleccion2.setVisible(false);
		eleccion3.setVisible(false);
		eleccion4.setVisible(false);
		eleccion5.setVisible(false);
	}

	private void ocultarBotones3a5() {
		eleccion3.setVisible(false);
		eleccion4.setVisible(false);
		eleccion5.setVisible(false);
	}

	private void conversacionPrincipio() {
		hacerVisiblesTodosLosBotones();
		estado = "inicial";
		mostrarTextoTaberneroUnaVezQueYaHablaste();
		eleccion1.setText("Estoy buscando al dragón");
		eleccion2.setText("Qué sitio tan concurrido");
		eleccion3.setText("¿Dónde puedo conseguir equipamiento?");
		eleccion4.setText("Pedir una botella de rón");
		eleccion5.setText("Volver al centro de la ciudad");
	}

	private void preguntarPorElDragon() {
		estado = "preguntarPorElDragonLinea1";
		String conversacion = getPrincipal().retornarTaberna().getTabernero().contarSobreElDragon();
		areaCentral.setText(conversacion);
		eleccion1.setText("Sólo dime dónde puedo encontrarlo");
		eleccion2.setText("Mejor hablemos de otra cosa");
		ocultarBotones3a5();
	}

	private void preguntarPorElDragon2() {
		estado = "preguntarPorElDragon2";
		String conversacion = getPrincipal().retornarTaberna().getTabernero().darUbicacionDragon();
		areaCentral.setText(conversacion);
		eleccion1.setText("Gracias por la ayuda");
		ocultarBotones2a5();
	}

	private void preguntarPorLaTaberna() {
		estado = "preguntarPorLaTaberna";
		String conversacion = getPrincipal().retornarTaberna().getTabernero().contarSobreLaTaberna();
		areaCentral.setText(conversacion);
		eleccion1.setText("Interesante");
		ocultarBotones2a5();
	}

	private void preguntarPorArmas() {
		estado = "preguntarPorArmas";
		String conversacion = getPrincipal().retornarTaberna().getTabernero().darUbicacionMercado();
		areaCentral.setText(conversacion);
		eleccion1.setText("Gracias");
		ocultarBotones2a5();
	}

	private void preguntarPorArmas2() {
		estado = "preguntarPorArmas2";
		String conversacion = getPrincipal().retornarTaberna().getTabernero().advertirSobreElBosque();
		areaCentral.setText(conversacion);
		ocultarBotones2a5();
	}

	private void emborracharse() {
		String conversacion = getPrincipal().retornarTaberna().getMensajeSuspensionTaberna();
		areaCentral.setText(conversacion);
		remove(eleccion1);
		remove(eleccion2);
		remove(eleccion3);
		remove(eleccion4);
		repaint();
		revalidate();
		setSuspensionTaberna(true);
	}

	private void setSuspensionTaberna(boolean suspensionTaberna) {
		taberna.setSuspensionTaberna(suspensionTaberna);
	}

	private void salirDeLaTaberna() {
		getPrincipal().pausarCancionTaberna();
		getPrincipal().reproducirCancionPrincipal();
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel4Ciudad());
	}

	/**
	 * Según el botón presionado y el valor de String estado se llama X método.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (estado) {
		case "inicial":
			if (e.getActionCommand().equals("c1")) {
				preguntarPorElDragon();
			} else if (e.getActionCommand().equals("c2")) {
				preguntarPorLaTaberna();
			} else if (e.getActionCommand().equals("c3")) {
				preguntarPorArmas();
			} else if (e.getActionCommand().equals("c4")) {
				emborracharse();
			} else if (e.getActionCommand().equals("c5")) {
				salirDeLaTaberna();
			}
			break;
		case "preguntarPorElDragonLinea1":
			if (e.getActionCommand().equals("c1")) {
				preguntarPorElDragon2();
			} else if (e.getActionCommand().equals("c2")) {
				conversacionPrincipio();
			}
			break;
		case "preguntarPorElDragon2":
			if (e.getActionCommand().equals("c1")) {
				conversacionPrincipio();
			}
			break;
		case "preguntarPorLaTaberna":
			if (e.getActionCommand().equals("c1")) {
				conversacionPrincipio();
			}
			break;
		case "preguntarPorArmas":
			if (e.getActionCommand().equals("c1")) {
				preguntarPorArmas2();
			}
		case "preguntarPorArmas2":
			if (e.getActionCommand().equals("c1")) {
				conversacionPrincipio();
			}
		}
	}
}