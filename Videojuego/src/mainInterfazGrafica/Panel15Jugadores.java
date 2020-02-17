package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import personajes.Jugador;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import jsonEstadisticasJugador.JSONUtiles;
import javax.swing.ScrollPaneConstants;

/**
 * Esta clase contiene el panel que se muestra al final del juego, con la
 * información de todos los jugadores que pasaron el juego. Carga y guardado de
 * JSON.
 */
public class Panel15Jugadores extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane salidaDeInformacion;

	public Panel15Jugadores(FramePrincipal principal) {
		setBackground(Color.BLACK);
		setLayout(null);

		salidaDeInformacion = new JTextPane();
		salidaDeInformacion.setEditable(false);
		salidaDeInformacion.setBounds(67, 249, 706, 247);

		JScrollPane jsp = new JScrollPane(salidaDeInformacion);
		jsp.setToolTipText("");
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setPreferredSize(new Dimension(200, 50));
		jsp.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		jsp.setBounds(89, 248, 646, 238);
		add(jsp);

		JLabel lblNewLabel = new JLabel(
				new ImageIcon(Panel15Jugadores.class.getResource("/resources/images/jugadores.png")));
		lblNewLabel.setBounds(-62, 0, 936, 565);
		add(lblNewLabel);
	}

	/**
	 * Carga (si existe) el archivo .json guardado en disco, y muestra las
	 * estadísticas (junto con las del nuevo jugador) en pantalla. Finalmente guarda
	 * el archivo .json del disco (pisando el viejo si este existía).
	 */
	public void estadisticas(Jugador jugador) {
		JSONUtiles jsonUtiles = new JSONUtiles();
		String datos = jsonUtiles.retornarDatosJugadores(jugador);
		salidaDeInformacion.setText(datos);
	}
}