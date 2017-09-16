

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Enemigo extends Ente {
	
	private int velocidad;
	
	public Enemigo(int v, int x, int y) {
		super(x, y);
		velocidad = v;
		this.grafico = new JLabel(new ImageIcon("e2.gif"));
	}
	
	public int getVelocidad() {
		return velocidad;
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
	}
}
