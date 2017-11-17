package juego;

import juego.ente.Enemigo;

public class FactoryEnemigo {
	
	// TODO: cambiar nombre de los archivos
	
	// VIDA: 100 | ATAQUE:20 | CADENCIA: 25 | RANGO: 3 | VELOCIDAD: 25 
	public static Enemigo crearClot () {
		return new Enemigo(100, 20, 25, 3, 25, "e2", 20);
	}
	
	// VIDA: 110 | ATAQUE:30 | CADENCIA: 40 | RANGO: 3 | VELOCIDAD: 20
	public static Enemigo crearGorefast () {
		return new Enemigo(110, 30, 40, 3, 20, "e1", 30);
	}
	
	// VIDA: 50 | ATAQUE:60 | CADENCIA: 30 | RANGO: 1 | VELOCIDAD: 15 
	public static Enemigo crearStalker () {
		return new Enemigo(50, 60, 30, 1, 15, "e3", 40);
	}
	
	// VIDA: 250 | ATAQUE:40 | CADENCIA: 40 | RANGO: 1 | VELOCIDAD: 45
	public static Enemigo crearFleshpound () {
		return new Enemigo(250, 40, 40, 1, 45, "e5", 75);
	}
	
	// VIDA: 60 | ATAQUE:50 | CADENCIA: 40 | RANGO: 7 | VELOCIDAD: 35 
	public static Enemigo crearHusk () {
		return new Enemigo(60, 50, 40, 7, 35, "e4", 50);
	}


	public static Enemigo crearEnemigo (String tipo) {
		Enemigo enemigo;
		switch(tipo) {
			case("e1"): enemigo = crearClot(); break;
			case("e2"): enemigo = crearGorefast(); break;
			case("e3"): enemigo = crearStalker(); break;
			case("e4"): enemigo = crearFleshpound(); break;
			case("e5"): enemigo = crearHusk(); break;
			default: enemigo = null;
		}
		return enemigo;
	}

}
