package juego.niveles;

import juego.FactoryObstaculo;
import juego.Juego;
import juego.Mapa;
import juego.ente.Celda;
import juego.ente.Obstaculo;

public class Nivel3 extends Nivel {

	public Nivel3 (Mapa mapa, int d) {
		super(mapa, d+2);			
	}
	
	public void init () {
		
		/*
		 * TODO: setear el fondo del mapa
		 */

		Obstaculo o1 = FactoryObstaculo.crearAbominacion();
		mapa.addObstaculo(o1, 3, 4);		

		Obstaculo o2 = FactoryObstaculo.crearPiedra();
		mapa.addObstaculo(o2, 1, 3);	

		Obstaculo o3 = FactoryObstaculo.crearAbominacion();
		mapa.addObstaculo(o3, 4, 5);	

		Obstaculo o4 = FactoryObstaculo.crearPiedra();
		mapa.addObstaculo(o4, 5, 7);	
		
		this.start();
	}
	
}
