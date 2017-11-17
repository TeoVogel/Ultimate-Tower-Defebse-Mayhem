	package grafica;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.EstadoEnte;
import juego.ente.EstadoEnteParar;
import juego.ente.Obstaculo;
import juego.ente.powerup.PowerUp;
import juego.Constantes;
import juego.Juego;

public class GraficoEfectoCelda extends JLabel {
	
	protected Point pos;
	protected String name;
	
	public GraficoEfectoCelda(String n) {
		name = n;
	}
	
	public void initGrafico (Celda c) {
		pos = new Point(calcularX(c), calcularY(c));
		setIcon(new ImageIcon(Interfaz.path + name));
		setBounds(pos.x, pos.y, Constantes.width, Constantes.height);
		Juego.getJuego().getInterfaz().getPanelMapa().add(this);
		
		repaint();
		
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
	
	private int calcularX (Celda c) {
		return c.columna * 100;
	}
	
	private int calcularY (Celda c) {
		return c.fila * 100;
	}
	
	public void eliminar () {
		setVisible(false);
		remove(getParent());
	}
	
}