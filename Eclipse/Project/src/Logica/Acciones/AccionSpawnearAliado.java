package Logica.Acciones;

import logica.Aliado;
import logica.Juego;

public class AccionSpawnearAliado implements Accion {

	private Aliado aliado;
	private Juego juego;	
	
	public AccionSpawnearAliado (Aliado a, Juego j) {
		aliado = a;
		juego = j;
	}
	
	public void ejecutar (int fila, int columna) {
		juego.getMapa().addAliado(aliado, fila, columna);
	}
	
}
