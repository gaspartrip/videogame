package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import juegoYZonas.Brisapura;
import personajes.Jugador;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene a la clase/zona Brisapura.
 */
public class Panel11Brisapura extends JPanelPadre {

	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton eleccion2;
	private Brisapura brisapura;

	public Panel11Brisapura(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		brisapura = getPrincipal().retornarBrisapura();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(reproducirMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		ambiente = new JLabel(
				new ImageIcon(Panel11Brisapura.class.getResource("/resources/images/zona8-brisapura.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);

		JButton eleccion1 = new JButton("Ir a hablar con el mago");
		eleccion1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion1();
			}
		});
		eleccion1.setForeground(Color.BLACK);
		eleccion1.setBackground(Color.WHITE);
		eleccion1.setBounds(423, 317, 298, 31);
		add(eleccion1);

		eleccion2 = new JButton("Descansar en la posada");
		eleccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dormirEnLaPosada(getPrincipal().retornarJugador().getOro());
			}
		});
		eleccion2.setBackground(Color.WHITE);
		eleccion2.setForeground(Color.BLACK);
		eleccion2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion2.setBounds(423, 359, 298, 31);
		add(eleccion2);

		JButton eleccion3 = new JButton("Ir al puente");
		eleccion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlPuente();
			}
		});
		eleccion3.setBackground(Color.WHITE);
		eleccion3.setForeground(Color.BLACK);
		eleccion3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eleccion3.setBounds(423, 401, 298, 31);
		add(eleccion3);
	}

	public String reproducirMensajeInicial() {
		return brisapura.getMensajeInicial();
	}

	private void eleccion1() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel11Mago());
	}

	/**
	 * Método para dormir en la posada y restituir toda la salud a cambio de oro.
	 * Comprueba que esté el oro suficiente. Llama a métodos de Brisapura y Jugador.
	 * 
	 * @param Se trae por parámetro el oro del jugador.
	 */
	private void dormirEnLaPosada(int oroJugador) // Al dormir, la vida pasa a estar al máximo
	{
		int precioPosada = brisapura.getPrecioPosada();
		Jugador jugador = getPrincipal().retornarJugador();
		String datoSalud = "";
		if (brisapura.dineroSuficientePosada(oroJugador) && (jugador.dormirEnLaPosada(precioPosada))) {
			datoSalud = brisapura.dormirEnLaPosada();
			getHudVida().setText(String.valueOf(jugador.getVidaActual()));
			getHudOro().setText(String.valueOf(jugador.getOro()));
		} else {
			datoSalud = brisapura.noPoderDormirEnLaPosada();
		}
		areaCentral.setText(brisapura.getMensajeInicial() + datoSalud);
	}

	private void irAlPuente() {
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel10Puente());
	}
}