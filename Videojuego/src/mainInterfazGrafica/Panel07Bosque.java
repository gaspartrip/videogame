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

/**
 * Esta clase contiene el panel que contiene la clase Bosque.
 */
public class Panel07Bosque extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton eleccion2;
	private Bosque bosque;

	public Panel07Bosque(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		bosque = getPrincipal().retornarBosque();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(bosque.getMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(new ImageIcon(Panel05Mercado.class.getResource("/resources/images/zona4-bosque.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton eleccion1 = new JButton("Ir al sur");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarAtaqueAlLobo();
			}
		});
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 317, 298, 31);
		add(eleccion1);

		eleccion2 = new JButton("Intentar evadirlo");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trataDeEvadirAlLobo();
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 359, 298, 31);
		add(eleccion2);

		JButton eleccion3 = new JButton("Ir al norte, a la ciudad");
		eleccion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverALaCiudad();
			}
		});
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 401, 298, 31);
		add(eleccion3);
	}

	private void iniciarAtaqueAlLobo() {
		areaCentral.setText(retornarMensajeTrasToparteConLobo());
		removerBotonDeEvadir();
		getPrincipal().prepararEnfrentamiento(getPrincipal().getPanel8Ruinas(), this, bosque.getLobo(), "/resources/images/enemigo-lobo.jpg");
	}

	private void removerBotonDeEvadir() {
		remove(eleccion2);
		repaint();
		revalidate();
	}

	private String retornarMensajeTrasToparteConLobo() {
		return bosque.getMensajeAlEncontrarteConLobo();
	}

	private void trataDeEvadirAlLobo() {
		areaCentral.setText(retornarMensajeTrasToparteConLobo());
		removerBotonDeEvadir();
	}

	private void volverALaCiudad() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel4Ciudad());
	}
}