package juego.ente.powerup;
<<<<<<< HEAD
import juego.ente.Comprable;
=======
import javax.swing.Icon;
import javax.swing.ImageIcon;

>>>>>>> efectos-graficamente
import juego.ente.Personaje;

public class PowerUp implements Comprable {
	protected Personaje afectado;
	protected int duracion;
	protected int duracionMax;
<<<<<<< HEAD
	protected int precio;
=======
	protected Icon img;
>>>>>>> efectos-graficamente
	
	public PowerUp() {
		duracion=0;
<<<<<<< HEAD
		precio = 50;
=======
		img = new ImageIcon();
>>>>>>> efectos-graficamente
	}
	
	protected PowerUp(int d) {
		duracionMax=d;
		duracion=d;
<<<<<<< HEAD
		precio = 50;
=======
		img = new ImageIcon();
>>>>>>> efectos-graficamente
	}
	
	public void setPersonaje (Personaje p) {
		afectado = p;
	}
	
	public void actualizar() {}

	@Override
	public int getPrecio() {
		return precio;
	}
	
	public Icon getImg () {
		return img;
	}
	
}
