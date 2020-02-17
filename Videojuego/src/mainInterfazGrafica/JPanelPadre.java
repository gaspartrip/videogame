package mainInterfazGrafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Esta clase abstracta contiene botones y campos de texto comunes a muchos
 * paneles (básicamente todo el HUD que aparece arriba en la mayoría de los
 * paneles, la vida, oro, etc).
 */
public abstract class JPanelPadre extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField hudVida;
	private JTextField hudArma;
	private JTextField hudOro;
	private JTextField hudArmadura;
	private FramePrincipal principal;
	private JButton btnInventario;

	public JPanelPadre() {

	}

	public JPanelPadre(FramePrincipal principal) {
		this.principal = principal;

		JLabel inventario = new JLabel(new ImageIcon(getClass().getResource("/resources/images/inventario.jpg")));
		inventario.setBounds(772, 21, 34, 34);
		add(inventario);

		btnInventario = new JButton("");
		btnInventario.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnInventario.setContentAreaFilled(false);
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				irAlInventario();
			}
		});
		btnInventario.setBounds(772, 21, 34, 34);
		btnInventario.setBackground(SystemColor.activeCaptionBorder);
		add(btnInventario);

		hudVida = new JTextField();
		hudVida.setHorizontalAlignment(SwingConstants.CENTER);
		hudVida.setEditable(false);
		hudVida.setForeground(Color.WHITE);
		hudVida.setBackground(Color.BLACK);
		hudVida.setBounds(52, 27, 55, 20);
		add(hudVida);
		hudVida.setColumns(10);

		JLabel vidaTotal = new JLabel(new ImageIcon(getClass().getResource("/resources/images/hp.jpg")));
		vidaTotal.setBounds(10, 22, 32, 31);
		add(vidaTotal);

		JLabel armaPrincipal = new JLabel(new ImageIcon(Panel04Ciudad.class.getResource("/resources/images/arma.jpg")));
		armaPrincipal.setBounds(224, 22, 32, 31);
		add(armaPrincipal);

		JLabel oroTotal = new JLabel(new ImageIcon(getClass().getResource("/resources/images/oro.jpg")));
		oroTotal.setBounds(117, 22, 32, 31);
		add(oroTotal);

		hudOro = new JTextField();
		hudOro.setText("0");
		hudOro.setHorizontalAlignment(SwingConstants.CENTER);
		hudOro.setForeground(Color.WHITE);
		hudOro.setEditable(false);
		hudOro.setColumns(10);
		hudOro.setBackground(Color.BLACK);
		hudOro.setBounds(159, 27, 55, 20);
		add(hudOro);

		JLabel armadura = new JLabel(new ImageIcon(getClass().getResource("/resources/images/armadura.jpg")));
		armadura.setBounds(495, 22, 32, 31);
		add(armadura);

		hudArmadura = new JTextField();
		hudArmadura.setText((String) null);
		hudArmadura.setHorizontalAlignment(SwingConstants.CENTER);
		hudArmadura.setForeground(Color.WHITE);
		hudArmadura.setEditable(false);
		hudArmadura.setColumns(10);
		hudArmadura.setBackground(Color.BLACK);
		hudArmadura.setBounds(537, 27, 220, 20);
		add(hudArmadura);

		hudArma = new JTextField();
		hudArma.setHorizontalAlignment(SwingConstants.CENTER);
		hudArma.setEditable(false);
		hudArma.setForeground(Color.WHITE);
		hudArma.setBackground(Color.BLACK);
		hudArma.setColumns(10);
		hudArma.setBounds(266, 27, 220, 20);
		add(hudArma);

		cargarHud();
	}

	public JTextField getHudVida() {
		return hudVida;
	}

	public void setHudVida(JTextField hudVida) {
		this.hudVida = hudVida;
	}

	public JTextField getHudArma() {
		return hudArma;
	}

	public void setHudArma(JTextField hudArma) {
		this.hudArma = hudArma;
	}

	public FramePrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(FramePrincipal principal) {
		this.principal = principal;
	}

	public JTextField getHudOro() {
		return hudOro;
	}

	public void setHudOro(JTextField hudOro) {
		this.hudOro = hudOro;
	}

	public JTextField getHudArmadura() {
		return hudArmadura;
	}

	public void setHudArmadura(JTextField hudArmadura) {
		this.hudArmadura = hudArmadura;
	}
	
	/**
	 * Método que pasa al panel del inventario.
	 */
	public void irAlInventario() {
		principal.getPanel0Inventario().cargarDatosDelJugadorEnElInventario();
		principal.intercambiarAPanelInventario(this);
		desactivarBotonInventario();
	}

	/**
	 * Método que desactiva el botón para acceder al inventario.
	 */
	public void desactivarBotonInventario() {
		btnInventario.setVisible(false);
	}

	/**
	 * Carga el HUD de todos los stats (vida, oro, arma, armadura). Los datos los
	 * saca del jugador. Sirve para actualizar los valores.
	 */
	public void cargarHudSinInventario() {
		hudVida.setText(String.valueOf(principal.retornarJugador().getVidaActual()));
		hudOro.setText(String.valueOf(principal.retornarJugador().getOro()));
		hudArma.setText(principal.retornarJugador().retornarNombreArma());
		hudArmadura.setText(principal.retornarJugador().retornarNombreArmadura());
	}

	/**
	 * Carga el HUD de todos los stats (vida, oro, arma, armadura) + activa el botón
	 * del inventario. Los datos los saca del jugador. Sirve para actualizar los
	 * valores.
	 */
	public void cargarHud() {
		cargarHudSinInventario();
		btnInventario.setVisible(true);
	}

	/**
	 * Carga el HUD que muestra la vida. El dato de la vida lo saca del jugador.
	 * Sirve para actualizar el valor.
	 */
	public void cargarHudVida() {
		hudVida.setText(String.valueOf(principal.retornarJugador().getVidaActual()));
	}

	/**
	 * Carga el HUD que muestra el oro. El dato del oro lo saca del jugador. Sirve
	 * para actualizar el valor.
	 */
	public void cargarHudOro() {
		hudOro.setText(String.valueOf(principal.retornarJugador().getOro()));
	}
}