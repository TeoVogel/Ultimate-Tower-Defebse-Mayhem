package juego.niveles;

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
		 * TODO: crear obstaculos y setear el fondo del mapa
		 */

		Obstaculo o1 = new Obstaculo(100);
		Celda celda = mapa.getCelda(4, 4);
		o1.init(celda);
		mapa.addObstaculo(o1);		

		Obstaculo o2 = new Obstaculo(100);
		celda = mapa.getCelda(2, 6);
		o2.init(celda);
		mapa.addObstaculo(o2);	
		
		this.start();
	}
	
}
