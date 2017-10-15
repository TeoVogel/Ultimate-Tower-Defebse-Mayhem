package grafica;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Grafico {
	
	protected JLabel grafico;
	protected Icon image[];
	protected final int width = 100;
	protected final int height = 160;
		
	protected Point pos;
	
	protected Grafico(int x, int y) {
		this.pos = new Point(x, y);
	}
	
	public Point getPos() {
		return pos;
	}
	
	protected void cambiarGrafico(int dir){
		if (grafico != null) {
			grafico.setIcon(image[dir]);
			grafico.setBounds(pos.x, pos.y, width, height);
		}
	}
	
	public JLabel getGrafico(){
		if (grafico == null) {
			grafico = new JLabel(image[2]);
			grafico.setBounds(pos.x, pos.y, width, height);
			
			grafico.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					grafico.setVisible(false);
					grafico.getParent().remove(grafico);
				}
				
			});
		}
		
		return grafico;
	}
	
	public void mover () {
		//sobreescribir en AtacarEnemigo
	}
	
}