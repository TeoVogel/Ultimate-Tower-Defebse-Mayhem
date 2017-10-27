package juego.ente;

public class EstadoEnteMover extends EstadoEnte {
	
	public EstadoEnteMover () {
		sufijo = "_mover";
	}
	
	public boolean enMovimiento () {
		return true;
	}

}
