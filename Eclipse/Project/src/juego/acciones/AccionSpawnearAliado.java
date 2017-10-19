package juego.acciones;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.AliadoFactory;
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
	
	public void ejecutar (int fila, int columna) {
		juego.getMapa().addAliado(AliadoFactory.crearAliado1(juego.getMapa().getCelda(fila, columna)));
	}
	
}
