package juego.ente;

public abstract class EstadoEnte {
	
	String sufijo;
	
	public String getSufijo () {
		return sufijo;
	}
	
	public boolean enMovimiento () {
		return false;
	}

}
