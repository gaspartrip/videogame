package juegoYZonas;

import archivo.Archivo;
import personajes.Comerciante;

/**
 * Esta clase sirve de plantilla para generar una zona espec�fica del juego, la
 * cual contiene m�todos que retornan Strings y aliado de tipo Comerciante, al
 * cual se le podr�n comprar objetos.
 */
public class Mercado extends Zona {
	private Comerciante comerciante;
	private static final String DIRECCION = "mercado.dat";

	public Mercado(int id) {
		super(id);
		cargarDatosComerciante();
	}

	private void cargarDatosComerciante() {
		Comerciante comerciante;
		Archivo<Comerciante> archivo = new Archivo<Comerciante>();
		comerciante = archivo.cargarDatos(DIRECCION);
		if(comerciante == null)
		{
			comerciante = new Comerciante();
		}
		this.comerciante = comerciante;
	}

	public Comerciante getComerciante() {
		return comerciante;
	}

	public String getDireccion() {
		return DIRECCION;
	}

	@Override
	public String getMensajeInicial() {
		return "Llegas al mercado de la ciudad de Cantoblanco. Un comerciante te saluda:\n\n- " + comerciante.saludar();
	}
}