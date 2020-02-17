package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import juegoYZonas.Brisapura;
import juegoYZonas.Cementerio;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene a la clase Mago y todas las interacciones con él.
 */
public class Panel11Mago extends JPanelPadre implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private String estado = "inicial";
	private JButton eleccion1;
	private JButton eleccion2;
	private boolean importanciaCarta = false;
	private Brisapura brisapura;
	private Cementerio cementerio;

	public Panel11Mago(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		brisapura = getPrincipal().retornarBrisapura();
		cementerio = getPrincipal().retornarCementerio();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(
				brisapura.getMensajeMago() + "- " + getPrincipal().retornarBrisapura().getMago().preguntarNombre());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(
				new ImageIcon(Panel11Mago.class.getResource("/resources/images/zona8-brisapura - mago.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		eleccion1 = new JButton("Soy un caballero" + ". Estoy buscando al dragón");
		eleccion1.setActionCommand("c2");
		eleccion1.addActionListener(this);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.setBounds(423, 317, 298, 31);
		add(eleccion1);

		eleccion2 = new JButton("Volver al centro del pueblo");
		eleccion2.setActionCommand("c3");
		eleccion2.addActionListener(this);
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 401, 298, 31);
		add(eleccion2);
	}

	/**
	 * Activa el botón "Entregar carta" si ya hable con el mago sin tener la carta y
	 * si se toma la carta del cementerio.
	 */
	public void cartaEnMano() { // Se llama desde Cementerio
		if (estado == "charla1") {
			eleccion1.setVisible(true);
			eleccion1.setText("Entregar carta");
		}
	}

	private void charlarConElMago1() {
		estado = "charla1";
		String conversacion = getPrincipal().retornarBrisapura().getMago().echar();
		areaCentral.setText(conversacion);
		if (cementerio.isCartaSellada() == true) {
			eleccion1.setVisible(true);
			eleccion1.setText("Entregar carta");
		} else
			eleccion1.setVisible(false);
		eleccion2.setText("Irse");
	}

	private void charlarConElMago2() {
		estado = "charla2";
		String conversacion = getPrincipal().retornarBrisapura().getMago().agradecerPorLaCarta();
		eleccion1.setVisible(true);
		eleccion1.setText("Solo dime la ubicación del dragón"); // Conduce a charlarConElMago4
		if (importanciaCarta == false) {
			eleccion2.setVisible(true);
			eleccion2.setText("¿Por qué es tan importante la carta?"); // Conduce a charlarConElMago3
		} else {
			conversacion = "- No sé cómo devolverte el favor...";
			eleccion2.setVisible(false);
		}
		areaCentral.setText(conversacion);
	}

	private void charlarConElMago3() {
		importanciaCarta = true;
		estado = "charla3";
		String conversacion = getPrincipal().retornarBrisapura().getMago().contarSobreLaCarta();
		areaCentral.setText(conversacion);
		eleccion1.setVisible(true);
		eleccion1.setText("Me alegra haber sido útil"); // Conduce a charlarConElMago2
		eleccion2.setVisible(false);
	}

	private void charlarConElMago4() {
		estado = "charla4";
		String conversacion = getPrincipal().retornarBrisapura().getMago().buscarInformacionDelDragon();
		areaCentral.setText(conversacion);
		eleccion2.setVisible(false);
		eleccion1.setText(">"); // Conduce a charlarConElMago4
	}

	private void charlarConElMago4Parte2() {
		estado = "charla4parte2";
		String conversacion = getPrincipal().retornarBrisapura().getMago().darInformacionDelDragon();
		areaCentral.setText(conversacion);
		eleccion1.setText("¿Dónde está esa cueva?"); // Conduce a charlarConElMago5
	}

	private void charlarConElMago5() {
		estado = "charla5";
		String conversacion = getPrincipal().retornarBrisapura().getMago().darUbicacionCueva();
		areaCentral.setText(conversacion);
		eleccion1.setText("Viajar");
		eleccion2.setVisible(true);
		eleccion2.setText("Volver al centro del pueblo");
	}

	private void setearNuevoMenu() {
		estado = "nuevoMenu";
		String conversacion = getPrincipal().retornarBrisapura().getMago().desearSuerte();
		areaCentral.setText(conversacion);
		eleccion1.setText("Viajar");
	}

	private void volverAlCentroDelPueblo() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel11Brisapura());
	}

	private void irAlPanelDeViaje() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel11Manticora());
	}

	/**
	 * Según el botón presionado y el valor de String estado se llama X método.
	 */
	public void actionPerformed(ActionEvent e) {
		switch (estado) {
		case "inicial":
			if (e.getActionCommand().equals("c2")) {
				charlarConElMago1();
			} else if (e.getActionCommand().equals("c3")) {
				volverAlCentroDelPueblo();
			}
			break;
		case "charla1":
			if (e.getActionCommand().equals("c2")) {
				charlarConElMago2();
			} else if (e.getActionCommand().equals("c3")) {
				volverAlCentroDelPueblo();
			}
			break;
		case "charla2":
			if (e.getActionCommand().equals("c2")) {
				charlarConElMago4();
			} else if (e.getActionCommand().equals("c3")) {
				charlarConElMago3();
			}
			break;
		case "charla3":
			if (e.getActionCommand().equals("c2")) {
				charlarConElMago2();
			}
			break;
		case "charla4":
			if (e.getActionCommand().equals("c2")) {
				charlarConElMago4Parte2();
			}
			break;
		case "charla4parte2":
			if (e.getActionCommand().equals("c2")) {
				charlarConElMago5();
			}
			break;
		case "charla5":
		case "nuevoMenu":
			if (e.getActionCommand().equals("c2")) {
				irAlPanelDeViaje();
			} else if (e.getActionCommand().equals("c3")) {
				volverAlCentroDelPueblo();
			}
			setearNuevoMenu();
			break;
		}
	}
}