package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import juegoYZonas.Cueva;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene el panel que contiene la clase Cueva.
 */
public class Panel12CuevaParte3 extends JPanelPadre
{
	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton botonMecanismo;
	private Cueva cueva;
	
	public Panel12CuevaParte3(FramePrincipal principal)
	{
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);
		
		cueva = getPrincipal().retornarCueva();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cueva.getMensajeInicialCuevaParte3());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);
		
		ambiente = new JLabel(new ImageIcon(Panel12CuevaParte3.class.getResource("/resources/images/zona9cueva-parte3.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);
		
		botonMecanismo = new JButton("Activar mecanismo");
		botonMecanismo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonMecanismo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activarMecanismo();
			}
		});
		botonMecanismo.setForeground(Color.BLACK);
		botonMecanismo.setBackground(Color.WHITE);
		botonMecanismo.setBounds(423, 359, 298, 31);
		add(botonMecanismo);
	}
	
	public void activarMecanismo()
	{
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel12CuevaParte4());
	}
}