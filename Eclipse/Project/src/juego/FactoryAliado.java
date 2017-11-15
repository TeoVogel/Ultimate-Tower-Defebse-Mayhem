package juego;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.powerup.Escudo;
import juego.ente.Aliado;

public class FactoryAliado {

	// public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad)
	// public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad)
	
	// VIDA: 100 | ATAQUE: 20 | CADENCIA: 20 | RANGO: 2 | PRECIO: 0 
	public static Aliado crearSupport () {
<<<<<<< HEAD
		return new Aliado(100, 20, 20, 2, 20, "a1");
=======
		Aliado aliado = new Aliado(100, 20, 20, 2, 0, "a1");
		aliado.setPowerUp(new Escudo(aliado));
		return aliado;
>>>>>>> efectos-graficamente
	}
	
	// VIDA: 80 | ATAQUE: 30 | CADENCIA: 35 | RANGO: 2 | PRECIO: 0
	public static Aliado crearCommando () {
		return new Aliado(80, 30, 35, 2, 30, "a2");
	}
	
	// VIDA: 100 | ATAQUE: 15 | CADENCIA: 25 | RANGO: 8 | PRECIO: 0
	public static Aliado crearSharpshooter () {
		return new Aliado(100, 15, 25, 8, 50, "a3");
	}
	
	// VIDA: 100 | ATAQUE: 15 | CADENCIA: 25 | RANGO: 8 | PRECIO: 0
	public static Aliado crearMago () {
		return new Aliado(70, 300, 50, 1, 75, "a4");
	}
	
	// VIDA: 100 | ATAQUE: 15 | CADENCIA: 25 | RANGO: 8 | PRECIO: 0
	public static Aliado crearTanque () {
		return new Aliado(200, 30, 30, 2, 50, "a5");
	}
	
	public static Aliado crearAliado (String tipo) {
		Aliado aliado;
		switch(tipo) {
			case("e1"): aliado = crearSupport(); break;
			case("e2"): aliado = crearCommando(); break;
			case("e3"): aliado = crearSharpshooter(); break;
			case("e4"): aliado = crearMago(); break; //TODO: crear dos mas
			case("e5"): aliado = crearTanque(); break;
			default: aliado = null;
		}
		return aliado;
	}

}