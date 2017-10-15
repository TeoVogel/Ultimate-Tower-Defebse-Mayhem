package Logica.Acciones;
import logica.Juego;
import loquequieras.Aliado;

public class AccionVenderAliado implements Accion {

	private Aliado aliado;
	private Juego juego;	
	
	public AccionVenderAliado (Aliado a, Juego j) {
		aliado = a;
		juego = j;
	}
	
	public void ejecutar (int fila, int columna) {
		juego.getMapa().addAliado(aliado, fila, columna);
		juego.getMercado().sumarMonedas(aliado.precio());
	}
	
}
