package juego.acciones;

import juego.ente.Celda;

public interface Accion {

	public void ejecutar (Celda c);
	
	public abstract int getPrecio ();
	
}
