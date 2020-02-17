package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import juegoYZonas.Cueva;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene el panel que contiene la clase Cueva.
 */
public class Panel12CuevaEste extends JPanelPadre
{
	private static final long serialVersionUID = 1L;
	private JLabel ambiente;
	private JTextPane areaCentral;
	private JButton botonBuscasEnCadaver;
	private JButton botonVolverAlCentro;
	private StyledDocument doc; // Interface que se usa para agregar texto al JTextPanel
	private Cueva cueva;
	
	public Panel12CuevaEste(FramePrincipal principal)
	{
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);
		
		cueva = getPrincipal().retornarCueva();
		
		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cueva.getMensajeInicialCuevaEste());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);
		doc = areaCentral.getStyledDocument();
		
		ambiente = new JLabel(new ImageIcon(Panel12CuevaEste.class.getResource("/resources/images/zona9cueva-este.jpg")));
		ambiente.setBounds(109, 295, 304, 167);
		add(ambiente);
		
		botonBuscasEnCadaver = new JButton("Revisar cadáver");
		botonBuscasEnCadaver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonBuscasEnCadaver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEnCadaver();
			}
		});
		botonBuscasEnCadaver.setForeground(Color.BLACK);
		botonBuscasEnCadaver.setBackground(Color.WHITE);
		botonBuscasEnCadaver.setBounds(423, 317, 298, 31);
		add(botonBuscasEnCadaver);

		botonVolverAlCentro = new JButton("Volver");
		botonVolverAlCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverAlCentro();
			}
		});
		botonVolverAlCentro.setBackground(Color.WHITE);
		botonVolverAlCentro.setForeground(Color.BLACK);
		botonVolverAlCentro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonVolverAlCentro.setBounds(423, 401, 298, 31);
		add(botonVolverAlCentro);
	}
	
	private void buscarEnCadaver()
	{
		String mensaje = "\n\n[+" + cueva.getCantidadDeOroCadaver() + " oro]";
		try {
			doc.insertString(doc.getLength(), mensaje, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		getPrincipal().retornarJugador().aumentarOro(cueva.getCantidadDeOroCadaver());
		cargarHud();
		botonBuscasEnCadaver.setVisible(false);
	}
	
	private void volverAlCentro()
	{
		areaCentral.setText(cueva.getMensajeInicialCuevaEste());
		getPrincipal().encuentroAleatorioConArañaGigante(getPrincipal().getPanel12CuevaParte2(), this, cueva.getArañaGigante(), "/resources/images/enemigo-arañaGigante.jpg");
	}
}