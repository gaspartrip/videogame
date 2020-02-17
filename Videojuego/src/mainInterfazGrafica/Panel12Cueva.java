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
public class Panel12Cueva extends JPanelPadre
{
	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private Cueva cueva;
	
	public Panel12Cueva(FramePrincipal principal)
	{
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);
		
		cueva = getPrincipal().retornarCueva();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cueva.getMensajeInicial());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);
		
		ambiente = new JLabel(new ImageIcon(Panel12Cueva.class.getResource("/resources/images/zona9cueva.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);
		
		JButton botonEntrarALasProfundidades = new JButton("Adentrarte en las profundidades de la cueva\r\n");
		botonEntrarALasProfundidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				entrarALasProfundidades();
			}
		});
		botonEntrarALasProfundidades.setBackground(Color.WHITE);
		botonEntrarALasProfundidades.setForeground(Color.BLACK);
		botonEntrarALasProfundidades.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonEntrarALasProfundidades.setBounds(423, 359, 298, 31);
		add(botonEntrarALasProfundidades);
	}
	
	private void entrarALasProfundidades()
	{
		getPrincipal().intercambiarPaneles(getPrincipal().getPanel12CuevaParte2());
	}
}