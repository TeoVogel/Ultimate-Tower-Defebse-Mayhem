package juego;

import juego.ente.Celda;
import juego.ente.Aliado;

public class AliadoFactory {
	// TODO: cambiarle el nomre a los constructores por Tanque, Melee, etc.
	// public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad)
	// public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad)
	
	// VIDA: 100 | ATAQUE:15 | CADENCIA: 30 | RANGO: 2 | PRECIO: 0 
	public static Aliado crearAliado1 (Celda celda) {
		return new Aliado(100, celda, 15, 30, 2, 0, "a1");
	}
	public static Aliado crearAliado1 () {
		return new Aliado(100, 10, 30, 2, 0, "a1");
	}
	
	// VIDA: 80 | ATAQUE:20 | CADENCIA: 40 | RANGO: 3 | PRECIO: 0
	public static Aliado crearAliado2 (Celda celda) {
		return new Aliado(80, celda, 20, 40, 3, 0, "a2");
	}
	public static Aliado crearAliado2 () {
		return new Aliado(80, 10, 10, 3, 0, "a2");
	}

}