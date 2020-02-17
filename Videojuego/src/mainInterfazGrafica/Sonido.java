package mainInterfazGrafica;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Esta clase se encarga de reproducir el sonido del juego. Cada atributo de
 * clase Clip contendrá la información necesaria para reproducir los distintos
 * sonidos.
 */
public class Sonido {
	private Clip cancionPrincipal;
	private Clip cancionTaberna;
	private Clip cancionBatalla;
	private Clip sonidoMuerte;
	private Clip sonidoCompra;
	private Clip sonidoAtaqueDragon;
	private Clip sonidoMuerteDragon;
	private Clip sonidoPocion;
	private Clip sonidoBolaDeFuego;
	private Clip sonidoNovaDeEscarcha;
	private Clip sonidoGolpeDeCruzado;
	private Clip sonidoBarreraDivina;
	private Clip sonidoAtacar;
	private Clip sonidoEquipar;

	public Sonido() {
	}

	/**
	 * Reproduce la canción principal. Se reproduce constantemente, termina y vuelve
	 * a arrancar, usando el método loop. Usando la clase FloatControl se puede
	 * regular la intensidad del sonido.
	 */
	public void reproducirCancionPrincipal() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/MainTheme.wav"));
			cancionPrincipal = AudioSystem.getClip();
			cancionPrincipal.open(audioInputStream);
			cancionPrincipal.start(); // Reproduce

			cancionPrincipal.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Para modificar el sonido, entre 0 y 1
		FloatControl gainControl = (FloatControl) cancionPrincipal.getControl(FloatControl.Type.MASTER_GAIN);
		float range = gainControl.getMaximum() - gainControl.getMinimum();
		float gain = (range * 0.8f) + gainControl.getMinimum();
		gainControl.setValue(gain);
	}

	public void pausarCancionPrincipal() {
		cancionPrincipal.stop();
	}

	/**
	 * Reproduce la canción de la taberna. Se reproduce constantemente, termina y
	 * vuelve a arrancar, usando el método loop. Usando la clase FloatControl se
	 * puede regular la intensidad del sonido.
	 */
	public void reproducirCancionTaberna() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/Taberna.wav"));
			cancionTaberna = AudioSystem.getClip();
			cancionTaberna.open(audioInputStream);
			cancionTaberna.start();
			cancionTaberna.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Para modificar el sonido, entre 0 y 1
		FloatControl gainControl = (FloatControl) cancionTaberna.getControl(FloatControl.Type.MASTER_GAIN);
		float range = gainControl.getMaximum() - gainControl.getMinimum();
		float gain = (range * 0.8f) + gainControl.getMinimum();
		gainControl.setValue(gain);
	}

	public void pausarCancionTaberna() {
		cancionTaberna.stop();
	}

	/**
	 * Reproduce la canción de las batallas. Se reproduce constantemente, termina y
	 * vuelve a arrancar, usando el método loop. Usando la clase FloatControl se
	 * puede regular la intensidad del sonido.
	 */
	public void reproducirCancionBatalla() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/Batalla.wav"));
			cancionBatalla = AudioSystem.getClip();
			cancionBatalla.open(audioInputStream);
			cancionBatalla.start();
			cancionBatalla.loop(Clip.LOOP_CONTINUOUSLY);
			// Para modificar el sonido, entre 0 y 1
			FloatControl gainControl = (FloatControl) cancionBatalla.getControl(FloatControl.Type.MASTER_GAIN);
			float range = gainControl.getMaximum() - gainControl.getMinimum();
			float gain = (range * 0.75f) + gainControl.getMinimum();
			gainControl.setValue(gain);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void pausarCancionBatalla() {
		cancionBatalla.stop();
	}

	/**
	 * Reproduce el sonido cuando se muere -sin iteracion, no hace falta un metodo
	 * stop().
	 */
	public void reproducirSonidoMuerte() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/has muerto.wav"));
			sonidoMuerte = AudioSystem.getClip();
			sonidoMuerte.open(audioInputStream);
			sonidoMuerte.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Reproduce el sonido cuando se compra un item -sin iteracion, no hace falta un
	 * metodo stop().
	 */
	public void reproducirSonidoCompra() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/compra.wav"));
			sonidoCompra = AudioSystem.getClip();
			sonidoCompra.open(audioInputStream);
			sonidoCompra.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// SONIDOS DE ATAQUES, sin loop:

	public void reproducirSonidoAtaqueDragon() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/ataqueDragon.wav"));
			sonidoAtaqueDragon = AudioSystem.getClip();
			sonidoAtaqueDragon.open(audioInputStream);
			sonidoAtaqueDragon.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoMuerteDragon() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/muerteDragon.wav"));
			sonidoMuerteDragon = AudioSystem.getClip();
			sonidoMuerteDragon.open(audioInputStream);
			sonidoMuerteDragon.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoPocion() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/pocion.wav"));
			sonidoPocion = AudioSystem.getClip();
			sonidoPocion.open(audioInputStream);
			sonidoPocion.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoBolaDeFuego() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/bolaDeFuego.wav"));
			sonidoBolaDeFuego = AudioSystem.getClip();
			sonidoBolaDeFuego.open(audioInputStream);
			sonidoBolaDeFuego.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoNovaDeEscarcha() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/novaDeEscarcha.wav"));
			sonidoNovaDeEscarcha = AudioSystem.getClip();
			sonidoNovaDeEscarcha.open(audioInputStream);
			sonidoNovaDeEscarcha.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoGolpeDeCruzado() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/golpeDeCruzado.wav"));
			sonidoGolpeDeCruzado = AudioSystem.getClip();
			sonidoGolpeDeCruzado.open(audioInputStream);
			sonidoGolpeDeCruzado.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoBarreraDivina() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/barreraDivina.wav"));
			sonidoBarreraDivina = AudioSystem.getClip();
			sonidoBarreraDivina.open(audioInputStream);
			sonidoBarreraDivina.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoAtacar() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/atacar.wav"));
			sonidoAtacar = AudioSystem.getClip();
			sonidoAtacar.open(audioInputStream);
			sonidoAtacar.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void reproducirSonidoEquipar() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(Sonido.class.getResource("/resources/sound/equipar.wav"));
			sonidoEquipar = AudioSystem.getClip();
			sonidoEquipar.open(audioInputStream);
			sonidoEquipar.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void cerrarCancionPrincipal() {
		if (cancionPrincipal != null)
			cancionPrincipal.close();
	}

	public void cerrarCancionTaberna() {
		if (cancionTaberna != null)
			cancionTaberna.close();
	}

	public void cerrarCancionBatalla() {
		if (cancionBatalla != null)
			cancionBatalla.close();
	}

	public void cerrarSonidoMuerte() {
		if (sonidoMuerte != null)
			sonidoMuerte.close();
	}

	public void cerrarSonidoCompra() {
		if (sonidoCompra != null)
			sonidoCompra.close();
	}

	public void cerrarSonidoAtaqueDragon() {
		if (sonidoAtaqueDragon != null)
			sonidoAtaqueDragon.close();
	}

	public void cerrarSonidoMuerteDragon() {
		if (sonidoMuerteDragon != null)
			sonidoMuerteDragon.close();
	}

	public void cerrarSonidoPocion() {
		if (sonidoPocion != null)
			sonidoPocion.close();
	}

	public void cerrarSonidaBolaDeFuego() {
		if (sonidoBolaDeFuego != null)
			sonidoBolaDeFuego.close();
	}

	public void cerrarSonidoNovaDeEscarcha() {
		if (sonidoNovaDeEscarcha != null)
			sonidoNovaDeEscarcha.close();
	}

	public void cerrarSonidoGolpeDeCruzado() {
		if (sonidoGolpeDeCruzado != null)
			sonidoGolpeDeCruzado.close();
	}

	public void cerrarSonidoBarreraDivina() {
		if (sonidoBarreraDivina != null)
			sonidoBarreraDivina.close();
	}

	public void cerrarSonidoAtacar() {
		if (sonidoAtacar != null)
			sonidoAtacar.close();
	}

	public void cerrarSonidoEquipar() {
		if (sonidoEquipar != null)
			sonidoEquipar.close();
	}

	/**
	 * Cierra todos los clips de sonido. Se utiliza al reinicar el juego, para que
	 * no se superpongan los sonidos.
	 */
	public void cerrarSonido() {
		cerrarCancionPrincipal();
		cerrarCancionTaberna();
		cerrarCancionBatalla();
		cerrarSonidoMuerte();
		cerrarSonidoCompra();
		cerrarSonidoAtaqueDragon();
		cerrarSonidoMuerteDragon();
		cerrarSonidoPocion();
		cerrarSonidaBolaDeFuego();
		cerrarSonidoNovaDeEscarcha();
		cerrarSonidoGolpeDeCruzado();
		cerrarSonidoBarreraDivina();
		cerrarSonidoAtacar();
		cerrarSonidoEquipar();
	}
}