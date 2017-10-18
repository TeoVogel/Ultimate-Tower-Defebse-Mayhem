package grafica;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

import juego.ente.Enemigo;
import juego.ente.Ente;

public abstract class Grafico {
	
	protected final static String path = "C:/Users/Franco/Documents/";
	//protected final static String path = "C:/Users/teo/Documents/TDP/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
	//protected final static String path = "C:/Users/guido/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
	
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
	
	private static int calcularX (Ente e) {
		return e.getCelda().columna * 100;
	}
	private static int calcularY (Ente e) {
		return e.getCelda().fila * 100;
	}
	
	protected void cambiarGrafico(int dir){
		if (grafico != null) {
			grafico.setIcon(image[dir]);
			grafico.setBounds(pos.x, pos.y, width, height);
		}
	}
	
	public JLabel getLabel(){
		return grafico;
	}
	
}