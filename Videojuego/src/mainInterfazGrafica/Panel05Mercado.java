package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import juegoYZonas.Mercado;

/**
 * Esta clase contiene el panel Mercado y a la clase Comerciante.
 */
public class Panel05Mercado extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	// Tiene un Mercader - A su vez el Mercader tiene 4 armas, 1 para cada clase
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton botonComprar;
	private JButton botonVolver;
	private Mercado mercado;

	public Panel05Mercado(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		mercado = getPrincipal().retornarMercado();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(retornarTextoBienvenida());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel05Mercado.class.getResource("/resources/images/zona2-mercado.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		botonComprar = new JButton("Comprar");
		botonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar();
			}
		});
		botonComprar.setBackground(Color.WHITE);
		botonComprar.setForeground(Color.BLACK);
		botonComprar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonComprar.setBounds(423, 340, 298, 34);
		add(botonComprar);

		botonVolver = new JButton("Volver a la ciudad");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverALaCiudad();
			}
		});
		botonVolver.setBackground(Color.WHITE);
		botonVolver.setForeground(Color.BLACK);
		botonVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonVolver.setBounds(423, 385, 298, 34);
		add(botonVolver);
	}

	public void mostrarTextoBienvenidaEnElPanel() {
		areaCentral.setText(retornarTextoBienvenida());
	}

	private String retornarTextoBienvenida() {
		return mercado.getMensajeInicial();
	}

	private void comprar() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel05MercadoComerciante());
	}

	private void volverALaCiudad() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel4Ciudad());
	}
}