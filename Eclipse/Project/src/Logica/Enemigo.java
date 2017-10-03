package Logica;
import javax.swing.ImageIcon;

public class Enemigo extends Ente {
	
	private int velocidad;
	private final int puntos = 100;
	
	public Enemigo(int v, int x, int y) {
		super(x, y, 10);
		velocidad=v;
		
		//this.image[0] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		//this.image[1] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		this.image[2] = new ImageIcon("C:/Users/Franco/Google Drive/Tower Defence/Gifs/e5.gif");
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		cambiarGrafico(2);
	}
	
	public void mover(){	
		pos.setLocation(pos.x - velocidad, pos.y);
		cambiarGrafico(2);
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int getPuntos () {
		return puntos;
	}
	
	
}