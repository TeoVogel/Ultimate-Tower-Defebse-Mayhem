import javax.swing.ImageIcon;

public class Malo extends Entidad{
	
	public Malo(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon("e2.gif");
		this.image[1] = new ImageIcon("e2.gif");
		this.image[2] = new ImageIcon("e2.gif");
		this.image[3] = new ImageIcon("e2.gif");
	}
}
