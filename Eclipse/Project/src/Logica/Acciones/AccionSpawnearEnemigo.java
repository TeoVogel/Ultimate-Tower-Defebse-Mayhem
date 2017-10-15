package Logica.Acciones;

import logica.Enemigo;
import logica.Juego;

public class AccionSpawnearEnemigo implements Accion {

	private Enemigo enemigo;
	private Juego juego;	
	
	public AccionSpawnearEnemigo (Enemigo e, Juego j) {
		enemigo = e;
		juego = j;
	}
	
	public void ejecutar (int fila, int columna) {
		juego.getMapa().addEnemigo(enemigo, fila, columna);
	}
	
}
