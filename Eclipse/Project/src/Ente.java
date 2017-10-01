import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Ente {
	
	protected JLabel grafico;
	protected Icon image[];
	protected final int width = 100;
	protected final int height = 160;
		
	protected Point pos;
	
	protected Ente(int x, int y) {
		this.pos = new Point(x, y);
		this.image = new Icon[4];
	}
	
	public Point getPos() {
		return pos;
	}
	
	protected void cambiarGrafico(int dir){
		if(grafico != null){
			grafico.setIcon(image[dir]);
			grafico.setBounds(pos.x, pos.y, width, height);
		}
	}
	
	public JLabel getGrafico(){
		if(grafico == null){
			grafico = new JLabel(image[2]);
			grafico.setBounds(pos.x, pos.y, width, height);
		}
		
		return grafico;
	}
}