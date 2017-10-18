package juego;

import java.util.Random;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Enemigo1;

public class EnemigoFactory {
	// public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad)
	// public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad)
	
	// VIDA
	public static Enemigo crearEnemigo1 (Celda celda) {
		return new Enemigo(celda);
	}
	
}
