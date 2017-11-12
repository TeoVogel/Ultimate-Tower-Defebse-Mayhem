package juego.acciones;

import juego.ente.Celda;

public interface Accion {

	public void ejecutar (int fila, int columna);
	
	public abstract int getPrecio ();
	
}
