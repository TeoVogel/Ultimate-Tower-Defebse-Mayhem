package juego.acciones;
import juego.ente.Aliado;
import juego.Juego;

public class AccionVenderAliado implements Accion {

	private Aliado aliado;
	private Juego juego;	
	
	public AccionVenderAliado (Aliado a, Juego j) {
		aliado = a;
		juego = j;
	}
	
	
}
