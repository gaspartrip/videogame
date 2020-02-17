package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import juegoYZonas.Cementerio;

/**
 * Esta clase contiene el panel que contiene la clase Cementerio.
 */
public class Panel09Cementerio extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	/**
	 * Se usa para agregar texto al JTextPane / Lo usamos para agregar un texto SIN
	 * borrar todo lo demás (append).
	 */
	private StyledDocument doc;
	private JButton eleccion2;
	private Cementerio cementerio;

	public Panel09Cementerio(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		cementerio = getPrincipal().retornarCementerio();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cementerio.getMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);
		doc = areaCentral.getStyledDocument();

		ambiente = new JLabel(
				new ImageIcon(Panel09Cementerio.class.getResource("/resources/images/zona6-cementerio.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton eleccion1 = new JButton("Ir hacia el puente");
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

		eleccion2 = new JButton("Abrir morral\r\n");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revisarMorral();
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 365, 298, 31);
		add(eleccion2);

		JButton eleccion3 = new JButton("Ir a las ruinas");
		eleccion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverALasRuinas();
			}
		});
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 407, 298, 31);
		add(eleccion3);
	}

	private void eleccion1() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel9CementerioParte2());
		setearNuevoTexto();
	}

	private void revisarMorral() {
		String conversacion = cementerio.getMensajeAlVerMorral();
		try {
			doc.insertString(doc.getLength(), conversacion, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		cementerio.setCartaSellada(true);
		eleccion2.setVisible(false);
		getPrincipal().getPanel11Mago().cartaEnMano(); // Si tomas la carta se habilita el botón de conversación
														// correspondiente con el mago
	}

	private void setearNuevoTexto() {
		areaCentral.setText(cementerio.getMensajeInicialAlternativo());
	}

	/**
	 * Método random que según una probabilidad pasa al siguiente panel, o según la
	 * otra probabilidad se inicia un ataque sin huída (por eso manda null en donde
	 * va el panel anterior) con un enemigo.
	 */
	private void volverALasRuinas() {
		double x = Math.random();
		setearNuevoTexto();
		if (x > 0.4) {
			getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel8Ruinas(), null, cementerio.getSquirtle(),
					"/resources/images/enemigo-squirtle.jpg");
		} else {
			getPrincipal().intercambiarPaneles(getPrincipal().getPanel8Ruinas());

		}
	}
}