package juego;

import juego.ente.Celda;
import juego.ente.Enemigo;

public class EnemigoFactory {
	// TODO: cambiarle el nomre a los constructores por Tanque, Melee, etc.
	// public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad)
	// public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad)
	
	// VIDA: 100 | ATAQUE:15 | CADENCIA: 30 | RANGO: 2 | VELOCIDAD: 15 
	public static Enemigo crearEnemigo1 (Celda celda) {
		return new Enemigo(100, celda, 15, 30, 2, 15);
	}
	public static Enemigo crearEnemigo1 () {
		return new Enemigo(100, 15, 30, 2, 15);
	}
	
	// VIDA: 80 | ATAQUE:20 | CADENCIA: 40 | RANGO: 3 | VELOCIDAD: 25
	public static Enemigo crearEnemigo2 (Celda celda) {
		return new Enemigo(80, celda, 20, 40, 3, 25);
	}
	public static Enemigo crearEnemigo2 () {
		return new Enemigo(80, 20, 40, 3, 25);
	}

}
