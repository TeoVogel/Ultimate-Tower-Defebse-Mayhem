package juego.niveles;

import juego.FactoryObstaculo;
import juego.Juego;
import juego.Mapa;
import juego.ente.Celda;
import juego.ente.Obstaculo;

public class Nivel1 extends Nivel {

	public Nivel1 (Mapa mapa, int d) {
		super(mapa, d);			
	}
	
	public void init () {
		
		/*
		 * TODO: setear el fondo del mapa
		 */

		Obstaculo o1 = FactoryObstaculo.crearPiedra();
		mapa.addObstaculo(o1, 4, 4);		

		Obstaculo o2 = FactoryObstaculo.crearPiedra();
		mapa.addObstaculo(o2, 2, 6);	
		
		this.start();
	}
	
}
