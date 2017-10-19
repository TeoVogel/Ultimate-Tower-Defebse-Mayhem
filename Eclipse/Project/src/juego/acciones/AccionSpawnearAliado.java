package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.AliadoFactory;
import juego.EnemigoFactory;
import juego.Juego;

public class AccionSpawnearAliado implements Accion {

	private Aliado aliado;
	private Juego juego;	
	
	public AccionSpawnearAliado ( Juego j) {
		juego = j;
		aliado = AliadoFactory.crearAliado1();
	}
	
	public void ejecutar (Celda celda){
		aliado.init(celda);
		juego.getMapa().addAliado(aliado);
	}
	
}
