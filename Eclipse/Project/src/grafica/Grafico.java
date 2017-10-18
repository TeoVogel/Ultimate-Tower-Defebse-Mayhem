package grafica;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

import juego.ente.Enemigo;
import juego.ente.Ente;

public abstract class Grafico extends JLabel{
	
	//protected final static String path = "C:/Users/Franco/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/";
	//protected final static String path = "C:/Users/teo/Documents/TDP/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
	protected final static String path = "C:/Users/guido/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
	
	protected String name;
	protected JLabel grafico;
	protected Icon image[];
	protected String[] archivos;
	public final static int width = 100;
	public final static int height = 100;
		
	protected Point pos;
	
	protected Grafico(Ente e, String name) {
		this.name = name;
		archivos = new String[]{name+"_parar", name+"_morir", name+"_frente", name+"_atacar", name+"_mover"};
		pos = new Point(calcularX(e), calcularY(e));
	}
	
	protected Grafico(int x, int y, String name) {
		this.name = name;
		archivos = new String[]{name+"_parar", name+"_morir", name+"_frente", name+"_atacar", name+"_mover"};
		pos = new Point(x, y);
	}

	public void initGrafico (Ente e) {
		pos = new Point(calcularX(e), calcularY(e));
		setIcon(image[0]);
		setBounds(pos.x, pos.y, width, height);
		
		/*addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				getParent().remove(getThis());
			}
			
		});*/
	}
	
	public Point getPos() {
		return pos;
	}
	
	private static int calcularX (Ente e) {
		return e.getCelda().columna * 100;
	}
	private static int calcularY (Ente e) {
		return e.getCelda().fila * 100;
	}
	
	protected void cambiarGrafico(int dir) {
		setIcon(image[dir]);
		setBounds(pos.x, pos.y, width, height);
	}
	
}