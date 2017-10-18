package juego.ente;

/*
 * TODO: algunos obstaculos tienen que ser comprables
 */

public abstract class Obstaculo extends Ente {
	
	// TODO: Este lo volamos maybe.
	public Obstaculo(int v, Celda c) {
		super(v, c);
	}
	
	public Obstaculo(int vida) {
		super(vida);
	}
	
}
