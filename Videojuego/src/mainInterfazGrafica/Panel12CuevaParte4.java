package mainInterfazGrafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import juegoYZonas.Cueva;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene el panel que contiene la clase Cueva.
 */
public class Panel12CuevaParte4 extends JPanelPadre implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextPane areaCentral;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JLabel puerta;
	private JButton botonAvanzar;
	private Cueva cueva;

	public Panel12CuevaParte4(FramePrincipal principal) {
		super(principal);
		setBackground(Color.BLACK);
		setLayout(null);

		cueva = getPrincipal().retornarCueva();

		areaCentral = new JTextPane();
		areaCentral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		areaCentral.setText(cueva.getMensajeInicialCuevaParte4());
		areaCentral.setForeground(Color.WHITE);
		areaCentral.setBackground(Color.DARK_GRAY);
		areaCentral.setBounds(91, 81, 653, 192);
		add(areaCentral);

		botonAvanzar = new JButton("");
		botonAvanzar.setContentAreaFilled(false);
		botonAvanzar.setFocusPainted(false);
		botonAvanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPrincipal().intercambiarPaneles(getPrincipal().getPanel12CuevaParte5());
			}
		});
		botonAvanzar.setBounds(608, 365, 82, 65);
		add(botonAvanzar);
		botonAvanzar.setVisible(false);

		puerta = new JLabel("");
		puerta.setIcon(new ImageIcon(Panel12CuevaParte4.class.getResource("/resources/images/puertaCerrada.png")));
		puerta.setBounds(602, 365, 95, 65);
		add(puerta);

		// PUZZLE

		b1 = new JButton("5");
		b1.setBackground(SystemColor.desktop);
		b1.setForeground(SystemColor.info);
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b1.setIcon(null);
		b1.setBounds(232, 291, 114, 69);
		b2 = new JButton("2");
		b2.setBackground(SystemColor.desktop);
		b2.setForeground(SystemColor.info);
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b2.setIcon(null);
		b2.setBounds(348, 291, 114, 69);
		b3 = new JButton("1");
		b3.setBackground(SystemColor.desktop);
		b3.setForeground(SystemColor.info);
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b3.setIcon(null);
		b3.setBounds(463, 291, 114, 69);
		b4 = new JButton("");
		b4.setBackground(SystemColor.desktop);
		b4.setForeground(SystemColor.info);
		b4.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b4.setIcon(null);
		b4.setBounds(232, 361, 114, 69);
		b5 = new JButton("3");
		b5.setBackground(SystemColor.desktop);
		b5.setForeground(SystemColor.info);
		b5.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b5.setIcon(null);
		b5.setBounds(348, 361, 114, 69);
		b6 = new JButton("4");
		b6.setBackground(SystemColor.desktop);
		b6.setForeground(SystemColor.info);
		b6.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b6.setIcon(null);
		b6.setBounds(463, 361, 114, 69);
		b7 = new JButton("8");
		b7.setBackground(SystemColor.desktop);
		b7.setForeground(SystemColor.info);
		b7.setFont(new Font("Tahoma", Font.PLAIN, 72));
		b7.setIcon(null);
		b7.setBounds(232, 431, 114, 69);
		b8 = new JButton("7");
		b8.setBackground(SystemColor.desktop);
		b8.setForeground(SystemColor.info);
		b8.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b8.setIcon(null);
		b8.setBounds(348, 431, 114, 69);
		b9 = new JButton("6");
		b9.setBackground(SystemColor.desktop);
		b9.setForeground(SystemColor.info);
		b9.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		b9.setIcon(null);
		b9.setBounds(463, 431, 114, 69);
		setLayout(null);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		// FIN PUZZLE
	}

	/**
	 * JUEGO PUZZLE SLIDER. Método que se activa al presionar alguno de los 9
	 * botones fijos ubicados en una matriz 3x3 y cuyo nombre es por orden numerico
	 * (b1, b2 y b3 en la fila 1, b4, b5 y b6 en la fila 2 y así) que se muestran en
	 * pantalla. Cada botón va a estar rodeado de 2 o 3 botones, por ejemplo en el
	 * caso del bóton 1, estará rodeado del botón 2 y del botón 4. Por otra parte
	 * solo 8 botones tendrán texto (número del 1 a 8) y 1 estará vacio ("").
	 * Partiendo de esta base, el método chequea si al presionar uno de los 9
	 * algunos de los botones de alrededor está vacio, si es así, se cambia de lugar
	 * el texto (uno vacío por uno con el número).
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String label = b1.getText();
			if (b2.getText().equals("")) {
				b2.setText(label);
				b1.setText("");
			}
			if (b4.getText().equals("")) {
				b4.setText(label);
				b1.setText("");
			}
		}
		if (e.getSource() == b2) {
			String label = b2.getText();
			if (b1.getText().equals("")) {
				b1.setText(label);
				b2.setText("");
			}
			if (b3.getText().equals("")) {
				b3.setText(label);
				b2.setText("");
			}
			if (b5.getText().equals("")) {
				b5.setText(label);
				b2.setText("");
			}
		}
		if (e.getSource() == b3) {
			String label = b3.getText();
			if (b2.getText().equals("")) {
				b2.setText(label);
				b3.setText("");
			}
			if (b6.getText().equals("")) {
				b6.setText(label);
				b3.setText("");
			}
		}
		if (e.getSource() == b4) {
			String label = b4.getText();
			if (b1.getText().equals("")) {
				b1.setText(label);
				b4.setText("");
			}
			if (b7.getText().equals("")) {
				b7.setText(label);
				b4.setText("");
			}
			if (b5.getText().equals("")) {
				b5.setText(label);
				b4.setText("");
			}
		}
		if (e.getSource() == b5) {
			String label = b5.getText();
			if (b2.getText().equals("")) {
				b2.setText(label);
				b5.setText("");
			}
			if (b6.getText().equals("")) {
				b6.setText(label);
				b5.setText("");
			}
			if (b4.getText().equals("")) {
				b4.setText(label);
				b5.setText("");
			}
			if (b8.getText().equals("")) {
				b8.setText(label);
				b5.setText("");
			}
		}
		if (e.getSource() == b6) {
			String label = b6.getText();
			if (b9.getText().equals("")) {
				b9.setText(label);
				b6.setText("");
			}
			if (b3.getText().equals("")) {
				b3.setText(label);
				b6.setText("");
			}
			if (b5.getText().equals("")) {
				b5.setText(label);
				b6.setText("");
			}
		}
		if (e.getSource() == b7) {
			String label = b7.getText();
			if (b4.getText().equals("")) {
				b4.setText(label);
				b7.setText("");
			}
			if (b8.getText().equals("")) {
				b8.setText(label);
				b7.setText("");
			}
		}
		if (e.getSource() == b8) {
			String label = b8.getText();
			if (b9.getText().equals("")) {
				b9.setText(label);
				b8.setText("");
			}
			if (b7.getText().equals("")) {
				b7.setText(label);
				b8.setText("");
			}
			if (b5.getText().equals("")) {
				b5.setText(label);
				b8.setText("");
			}
		}
		if (e.getSource() == b9) {
			String label = b9.getText();
			if (b6.getText().equals("")) {
				b6.setText(label);
				b9.setText("");
			}
			if (b8.getText().equals("")) {
				b8.setText(label);
				b9.setText("");
			}
		}
		if (b1.getText().equals("1") && b2.getText().equals("2") && b3.getText().equals("3") && b4.getText().equals("4")
				&& b5.getText().equals("5") && b6.getText().equals("6") && b7.getText().equals("7")
				&& b8.getText().equals("8") && b9.getText().equals("")) {
			puerta.setIcon(new ImageIcon(PanelBatalla.class.getResource("/resources/images/puertaAbierta.png")));
			botonAvanzar.setVisible(true);
		}
	}
}