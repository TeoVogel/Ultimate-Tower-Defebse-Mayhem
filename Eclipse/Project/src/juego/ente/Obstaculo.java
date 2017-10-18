package juego.ente;

import grafica.Grafico;

/*
 * TODO: algunos obstaculos tienen que ser comprables
 */

public abstract class Obstaculo extends Ente {
	protected Grafico miGrafico;
	
	public Obstaculo(int v, Celda c) {
		super(v, c);
	}
	
	public Obstaculo(int vida) {
		super(vida);
	}
	
}
