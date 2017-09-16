

import javax.swing.ImageIcon;


public class Enemigo extends Ente{
	private int velocidad;
	
	public Enemigo(int v, int x, int y) {
		super(x, y);
		velocidad=v;
		this.image[0] = new ImageIcon("C:/Users/Franco/Google Drive/Tower Defence/Gifs/e1.gif");
		this.image[1] = new ImageIcon("C:/Users/Franco/Google Drive/Tower Defence/Gifs/e1.gif");
		this.image[2] = new ImageIcon("C:/Users/Franco/Google Drive/Tower Defence/Gifs/e1.gif");
		this.image[3] = new ImageIcon("C:/Users/Franco/Google Drive/Tower Defence/Gifs/e1.gif");
	}
	
	public void mover(int dir){	
		
	}
	
	public int getVelocidad() {
		return velocidad;
	}
}
