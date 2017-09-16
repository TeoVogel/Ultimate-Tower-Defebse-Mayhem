

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Ente {
	
	protected JLabel grafico;
	protected final int width = 72;
	protected final int height = 100;
	
	protected Point pos;
	
	protected Ente(int x, int y) {
		this.pos = new Point(x, y);
	}
	
	public Point getPos() {
		return pos;
	}
	
	protected void cambiarGrafico(int dir){
		
	}
	
	public JLabel getGrafico(){		
		return grafico;
	}
	
	
	
}