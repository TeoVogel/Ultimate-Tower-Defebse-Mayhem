package juego;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Obstaculo;

public class FactoryObstaculo {
	
	// VIDA: 200
	public static Obstaculo crearAbominacion () {
		return new Obstaculo(200, "o1");
	}

	// VIDA: 300
	public static Obstaculo crearPiedra () {
		return new Obstaculo(300, "o2");
	}

}
