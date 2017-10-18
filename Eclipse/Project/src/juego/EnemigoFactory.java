package juego;

import java.util.Random;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Enemigo1;

public class EnemigoFactory {

	public static Enemigo crearEnemigo (Celda celda) {
		return new Enemigo1(celda);
	}
	
}
