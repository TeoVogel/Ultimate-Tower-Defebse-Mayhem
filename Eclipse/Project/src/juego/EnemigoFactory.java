package juego;

import java.util.Random;

import juego.ente.Enemigo;
import juego.ente.Enemigo1;

public class EnemigoFactory {


	public static Enemigo crearEnemigo (Mapa mapa, int fila, int columna) {
		Random r = new Random();
		return new Enemigo1(mapa.getCelda(fila, columna));
	}
	
}
