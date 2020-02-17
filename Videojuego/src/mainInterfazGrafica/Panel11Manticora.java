package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import juegoYZonas.Brisapura;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene el panel que se usa para ver el gif de la mantícora, y
 * viajar (pasar al panel Manticora Viaje) o volver.
 */
public class Panel11Manticora extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private Brisapura brisapura;

	public Panel11Manticora(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		brisapura = getPrincipal().retornarBrisapura();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(brisapura.getMensajeManticora());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel11Manticora.class.getResource("/resources/images/manticora.gif")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton eleccion1 = new JButton("Elegir destino");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viajar();
			}
		});
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 317, 298, 31);
		add(eleccion1);

		JButton eleccion2 = new JButton("Volver");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 401, 298, 31);
		add(eleccion2);
	}

	private void viajar() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel11ManticoraViaje());
	}

	private void volver() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel11Mago());
	}
}