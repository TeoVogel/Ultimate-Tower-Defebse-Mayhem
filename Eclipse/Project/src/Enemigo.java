package tmp;

import javax.swing.ImageIcon;

public class Enemigo extends Ente {
	
	private int velocidad;
	
	public Enemigo(int v, int x, int y) {
		super(x, y);
		velocidad=v;
		this.image[0] = new ImageIcon("C:/Users/teo/Documents/TDP/tmp/tmp/src/tmp/e2.gif");
		this.image[1] = new ImageIcon("C:/Users/teo/Documents/TDP/tmp/tmp/src/tmp/e2.gif");
		this.image[2] = new ImageIcon("C:/Users/teo/Documents/TDP/tmp/tmp/src/tmp/e2.gif");
		this.image[3] = new ImageIcon("C:/Users/teo/Documents/TDP/tmp/tmp/src/tmp/e2.gif");
	}
	
	public void mover(int dir){	
		switch (dir) {
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - velocidad);
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + velocidad);
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - velocidad, pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + velocidad, pos.y);
				break;
		}
		cambiarGrafico(dir);
	}
	
	public int getVelocidad() {
		return velocidad;
	}
}