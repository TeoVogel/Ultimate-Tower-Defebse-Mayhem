package juego.niveles;

import juego.Juego;
import juego.Mapa;
import juego.ente.Celda;
import juego.ente.Obstaculo;

public class Nivel1 extends Nivel {

	public Nivel1 (int d) {
		super(d);
		
		/*
		 * TODO: crear obstaculos y setear el fondo del mapa
		 */
		
		Obstaculo o1 = new Obstaculo(100);
		Juego juego = Juego.getJuego();
		Mapa mapa = juego.getMapa();
		Celda celda = mapa.getCelda(1, 1);
		//o1.init(celda);

		Obstaculo o2 = new Obstaculo(100);
		//o2.init(Juego.getJuego().getMapa().getCelda(3, 6));
		
	}
	
}
