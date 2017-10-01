
public class SpawnearEnemigo implements Accion {

	private Enemigo enemigo;
	private Juego juego;	
	
	public SpawnearEnemigo (Enemigo e, Juego j) {
		enemigo = e;
		juego = j;
	}
	
	public void ejecutar (int fila, int columna) {
		juego.getMapa().addEnemigo(enemigo, fila, columna);
	}
	
}
