package grafica;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;

public abstract class Grafico extends JLabel{
	
//	protected final static String path = "C:/Users/Franco/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
	protected final static String path = "C:/Users/teo/Documents/TDP/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 
//	protected final static String path = "C:/Users/guido/Documents/GitHub/Ultimate-Tower-Defense-Mayhem/Eclipse/Project/src/assets/"; 

	protected Ente ente;
	protected String name;
	protected Icon image[];
	protected String[] sufijosArchivos = {"_parar", "_morir", "_frente", "_atacar", "_mover"};
	public final static int width = 100;
	public final static int height = 100;
	protected Point pos;
	
	protected Grafico(Ente e, String n) {
		name = n;
		ente = e;
	}
	
	public void initGrafico (Celda c) {
		pos = new Point(calcularX(c), calcularY(c));
		setIcon(image[0]);
		setBounds(pos.x, pos.y, width, height);
		
		/*
		addMouseListener(new MouseAdapter() {
			
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
	
	protected void cambiarGrafico(int dir) {
		setIcon(image[dir]);
		setBounds(pos.x, pos.y, width, height);
	}
	
	
	private int calcularX (Celda c) {
		return c.columna * 100;
	}
	
	private int calcularY (Celda c) {
		return c.fila * 100;
	}
	
	//TODO esto es horrible
	private Grafico getThis() { return this; }
	
}