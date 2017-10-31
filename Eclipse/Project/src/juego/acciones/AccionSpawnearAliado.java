package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.FactoryAliado;
import juego.Juego;

public class AccionSpawnearAliado implements Accion {

	private Aliado aliado;
	private Juego juego;	
	
	public AccionSpawnearAliado (String tipo, Juego j) {
		juego = j;
		aliado = FactoryAliado.crearAliado(tipo);
	}
	
	public void ejecutar (Celda celda){
		aliado.init(celda);
		juego.getMapa().addAliado(aliado);
	}
	
}
