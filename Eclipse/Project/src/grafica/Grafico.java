package grafica;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Grafico {
	
	protected final static String path = "C:/Users/Franco/Documents/"; 
//	protected final static String path = "C:/Users/teo/Documents/TDP/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
//	protected final static String path = "C:/Users/guido/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
	
	protected JLabel grafico;
	protected Icon image[];
	public final static int width = 100;
	public final static int height = 100;
		
	protected Point pos;
	
	protected Grafico(int x, int y) {
		pos = new Point(x, y);
	}

	protected void initGrafico () {
		grafico = new JLabel(image[0]);
		grafico.setBounds(pos.x, pos.y, width, height);
		
		grafico.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				grafico.setVisible(false);
				grafico.getParent().remove(grafico);
			}
			
		});
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
		return grafico;
	}
	
	public void mover () {
		//sobreescribir en GraficoEnemigo
	}
	
}