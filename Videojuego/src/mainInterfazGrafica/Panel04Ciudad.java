package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import juegoYZonas.Ciudad;
import juegoYZonas.Taberna;

/**
 * Esta clase contiene el panel de la zona principal, Ciudad, y su acceso a
 * Taberna, Bosque o Mapa.
 */
public class Panel04Ciudad extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private Ciudad ciudad;
	private Taberna taberna;

	public Panel04Ciudad() {
		super();
	}

	public Panel04Ciudad(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		ciudad = getPrincipal().retornarCiudad();
		taberna = getPrincipal().retornarTaberna();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(ciudad.getMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(getClass().getResource("/resources/images/zona1-ciudad.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton eleccion1 = new JButton("Ir a la taberna");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irALaTaberna();
			}
		});
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 295, 298, 34);
		add(eleccion1);

		JButton eleccion2 = new JButton("Ir al mercado");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlMercado();
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 340, 298, 34);
		add(eleccion2);

		JButton eleccion3 = new JButton("Ir al bosque");
		eleccion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlBosque();
			}
		});
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 385, 298, 34);
		add(eleccion3);

		JButton eleccion4 = new JButton("Ver mapa");
		eleccion4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verElMapa();
			}
		});
		eleccion4.setBackground(Color.WHITE);
		eleccion4.setForeground(Color.BLACK);
		eleccion4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion4.setBounds(423, 430, 298, 34);
		add(eleccion4);
	}

	private void irALaTaberna() {
		getPrincipal().pausarCancionPrincipal();
		getPrincipal().reproducirCancionTaberna();
		if (!taberna.isSuspensionTaberna())
			taberna.getMensajeInicial();
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel6Taberna());
	}

	private void irAlMercado() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel5Mercado());
	}

	private void irAlBosque() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel7Bosque());
	}

	private void verElMapa() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel4CiudadMapa());
	}
}