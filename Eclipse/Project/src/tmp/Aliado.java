package tmp;
import javax.swing.ImageIcon;

public class Aliado extends Ente {
	
	private int velocidad;
	private final int puntos = 100;
	
	public Aliado(int v, int x, int y) {
		super(x, y, 10);
		velocidad=v;
		
		//this.image[0] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		//this.image[1] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		this.image[2] = new ImageIcon("C://Users//teo//Documents//TDP//Ultimate-Tower-Defense-Mayhem//Eclipse//Project//src//Grafica/a1.gif");
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		cambiarGrafico(2);
	}
	
	public void mover(){	
		cambiarGrafico(2);
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int getPuntos () {
		return puntos;
	}
	
	
}