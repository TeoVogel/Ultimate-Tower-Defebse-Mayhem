package juego.acciones;

import juego.ente.Celda;

public interface AccionSobreMapa extends AccionMonetaria{

	public void ejecutar (int fila, int columna);
	
}
