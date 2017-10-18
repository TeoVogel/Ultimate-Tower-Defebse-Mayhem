package juego.acciones;

import juego.ente.Celda;

public interface Accion {

	public void ejecutar (Celda celda);
	
	public void ejecutar (int fila, int columna);
}
