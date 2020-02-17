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
public class Panel12CuevaParte2 extends JPanelPadre
{
	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton botonNorte;
	private JButton botonOeste;
	private JButton botonEste;
	private Cueva cueva;
	
	public Panel12CuevaParte2(FramePrincipal principal)
	{
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);
		
		cueva = getPrincipal().retornarCueva();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cueva.getMensajeInicialCuevaParte2());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);
		
		ambiente = new JLabel(new ImageIcon(Panel12CuevaParte2.class.getResource("/resources/images/zona9cueva-parte2.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);
		
		botonNorte = new JButton("Ir al norte");
		botonNorte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonNorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlNorte();
			}
		});
		botonNorte.setForeground(Color.BLACK);
		botonNorte.setBackground(Color.WHITE);
		botonNorte.setBounds(423, 317, 298, 31);
		add(botonNorte);

		botonOeste = new JButton("Ir al oeste");
		botonOeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlOeste();
			}
		});
		botonOeste.setBackground(Color.WHITE);
		botonOeste.setForeground(Color.BLACK);
		botonOeste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonOeste.setBounds(423, 359, 298, 31);
		add(botonOeste);

		botonEste = new JButton("Ir al este");
		botonEste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlEste();
			}
		});
		botonEste.setBackground(Color.WHITE);
		botonEste.setForeground(Color.BLACK);
		botonEste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonEste.setBounds(423, 401, 298, 31);
		add(botonEste);
	}
	
	public void irAlNorte()
	{
		getPrincipal().encuentroAleatorioConArañaGigante(getPrincipal().getPanel12CuevaParte3(), this, cueva.getArañaGigante(), "/resources/images/enemigo-arañaGigante.jpg");
	}
	
	public void irAlOeste()
	{
		getPrincipal().encuentroAleatorioConArañaGigante(getPrincipal().getPanel12CuevaOeste(), this, cueva.getArañaGigante(), "/resources/images/enemigo-arañaGigante.jpg");
	}
	
	public void irAlEste()
	{
		getPrincipal().encuentroAleatorioConArañaGigante(getPrincipal().getPanel12CuevaEste(), this, cueva.getArañaGigante(), "/resources/images/enemigo-arañaGigante.jpg");
	}
}