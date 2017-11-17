package juego.ente.EfectoCelda;

public class FactoryEfectoCelda {

	public static final int EFECTO_CELDA_ACIDO = 0;
	public static final int EFECTO_CELDA_PEGAMENTO = 1;
	
	public static EfectoCelda crearEfectoCelda (int tipo) {
		EfectoCelda efecto;
		switch(tipo) {
			case (EFECTO_CELDA_ACIDO):     efecto = new Acido(); break;
			case (EFECTO_CELDA_PEGAMENTO): efecto = new Pegamento(); break;
			default:                       efecto = new EfectoCelda();
		}
		return efecto;
	}
	
}
