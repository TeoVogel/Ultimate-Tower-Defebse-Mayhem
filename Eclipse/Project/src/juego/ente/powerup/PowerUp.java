package juego.ente.powerup;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Personaje;

public class PowerUp {
	protected Personaje afectado;
	protected int duracion;
	protected int duracionMax;
	protected Icon img;
	
	public PowerUp(Personaje p) {
		afectado=p;
		duracion=0;
		img = new ImageIcon();
	}
	
	protected PowerUp(Personaje p, int d) {
		afectado=p;
		duracionMax=d;
		duracion=d;
		img = new ImageIcon();
	}
	public void actualizar() {}
	
	public Icon getImg () {
		return img;
	}
	
}
