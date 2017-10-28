package juego.ente.powerup;
import juego.ente.Personaje;

public class PowerUp {
	protected Personaje afectado;
	protected int duracion;
	protected int duracionMax;
	
	public PowerUp(Personaje p) {
		afectado=p;
		duracion=0;
	}
	
	public void actualizar() {}
	
}
