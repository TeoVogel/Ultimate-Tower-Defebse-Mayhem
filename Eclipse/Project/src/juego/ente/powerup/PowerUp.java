package juego.ente.powerup;
import juego.ente.Comprable;
import juego.ente.Personaje;

public class PowerUp implements Comprable {
	protected Personaje afectado;
	protected int duracion;
	protected int duracionMax;
	protected int precio;
	
	public PowerUp() {
		duracion=0;
		precio = 50;
	}
	
	protected PowerUp(int d) {
		duracionMax=d;
		duracion=d;
		precio = 50;
	}
	
	public void setPersonaje (Personaje p) {
		afectado = p;
	}
	
	public void actualizar() {}

	@Override
	public int getPrecio() {
		return precio;
	}
	
}
