package juego.ente.powerup;

import juego.ente.Comprable;

import javax.swing.Icon;
import javax.swing.ImageIcon;


import juego.ente.Personaje;

public class PowerUp implements Comprable {
	protected Personaje afectado;
	protected int duracion;
	protected int duracionMax;
	protected int precio;

	protected Icon img;

	// TODO: En un merge aparecio otro constructor...
	public PowerUp() {
		duracion = 0;
		precio = 50;
		img = new ImageIcon();
	}
	
	protected PowerUp(int d) {
		duracionMax = d;
		duracion =  d;
		precio = 50;
		img = new ImageIcon();
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
