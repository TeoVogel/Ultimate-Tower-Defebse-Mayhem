package grafica;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.ente.Celda;
import juego.ente.Ente;
import juego.Constantes;
import juego.ente.Aliado;
import juego.ente.Obstaculo;

public class GraficoEnte extends JLabel{

	protected Ente ente;
	protected String name;
	protected Icon image[];			//	 [	  0   |    1    |     2    |    3     |    4    ]
	protected String[] sufijosArchivos = {"_parar", "_morir", "_frente", "_atacar", "_mover"};
	public final static int width = 100;
	public final static int height = 100;
	protected Point pos;
	
	public GraficoEnte(Ente e, String name) {
		this.name = name;
		ente = e;
	}
	
	public GraficoEnte(Aliado a, String name) {
		this.name = name;
		ente = a;
		image = new Icon[4];
		image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif");
		image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[1] + ".gif");
		image[2] = new ImageIcon(Constantes.path + name + sufijosArchivos[2] + ".gif");
		image[3] = new ImageIcon(Constantes.path + name + sufijosArchivos[3] + ".gif");
	}
	
	public GraficoEnte(Obstaculo o, String name) {
		this.name = name;
		ente = o;
		image = new Icon[2];
		image[0] = new ImageIcon(Constantes.path + name + sufijosArchivos[0] + ".gif");
		image[1] = new ImageIcon(Constantes.path + name + sufijosArchivos[1] + ".gif");
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
	private GraficoEnte getThis() { return this; }
	
}
