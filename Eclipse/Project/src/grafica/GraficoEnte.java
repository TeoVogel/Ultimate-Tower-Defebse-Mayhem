package grafica;

import java.awt.Color;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.ente.Celda;
import juego.ente.Ente;
import juego.ente.EstadoEnte;
import juego.Constantes;
import juego.Juego;

public class GraficoEnte extends JLabel implements Grafico {

	protected Ente ente;
	protected String name;
	protected Icon image[];
	protected static final String[] sufijosArchivos = {"_parar", "muerte", "_atacar", "_mover", "_frente"};
	
	public static final int BARRA_VIDA_WIDTH = 80;
	public static final int BARRA_VIDA_HIGHT = 4;
	
	protected JLabel barraVida;
	protected JLabel powerUp;	// TODO: no deberia estar en graficoPersonaje?
	
	protected Point pos;
	
	protected boolean inicializado = false;
	
	public void action() {
		ente.getEstado().doAction(this);
	}
	
	public GraficoEnte(Ente e, String n) {
		name = n;
		ente = e;
		
		image = new Icon[5];
		image[0] = new ImageIcon(Interfaz.path + name + sufijosArchivos[0] + ".gif"); //_parar
		image[1] = new ImageIcon(Interfaz.path	  + 	sufijosArchivos[1] + ".gif"); // muerte
		image[2] = new ImageIcon(Interfaz.path + name + sufijosArchivos[2] + ".gif"); //_atacar
		image[3] = new ImageIcon(Interfaz.path + name + sufijosArchivos[3] + ".gif"); //_mover
		image[4] = new ImageIcon(Interfaz.path + name + sufijosArchivos[4] + ".png"); //_frente
	}

	public void initGrafico (Celda c) {
		pos = new Point(calcularX(c), calcularY(c));
		setIcon(image[0]);
		setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
		
		barraVida = new JLabel();
		barraVida.setBackground(Color.GREEN);
		barraVida.setOpaque(true);
		
	    this.getParent().add(barraVida);
	    
	    // TODO: no tendria que estar en grafico graficoPersonaje?
		powerUp = new JLabel();
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
		this.getParent().add(powerUp);
		

		inicializado = true;	    
		actualizarVida();
	}
	
	public Point getPos() {
		return pos;
	}
	
	@Deprecated
	protected void cambiarGrafico(int dir) {
		setIcon(image[dir]);
		setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
	}
	
	public void cambiarGrafico(EstadoEnte estado) {
		if (!inicializado) {
			return;
		}
		
		setIcon(image[estado.getIndex()]);
		setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);
		repaint();
		actualizarVida();
	}
	
	public void actualizarVida () {		
		if (!inicializado) {
			return;
		}
		
		int max = ente.getMaxVida();
		int vida = ente.getVida();
		
		int barraLenght = BARRA_VIDA_WIDTH*vida/max;
		
		int barraWidthOffset = (PanelMapa.TILE_WIDTH - barraLenght)/2;
		int barraHeightOffset = PanelMapa.TILE_HIGHT - BARRA_VIDA_HIGHT/2;
		
		barraVida.setBounds(pos.x + barraWidthOffset, pos.y + barraHeightOffset, barraLenght, BARRA_VIDA_HIGHT);
	}
	
	
	protected int calcularX (Celda c) {
		return c.columna * 100;
	}
	
	protected int calcularY (Celda c) {
		return c.fila * 100;
	}
	
	// TODO: no tendria que estar en GraficoEnemigo?
	public void centrar () {
		Celda celda = ente.getCelda();
		pos.setLocation(celda.columna*PanelMapa.TILE_WIDTH, 
						celda.fila*PanelMapa.TILE_HIGHT);
		setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);	
		powerUp.setBounds(pos.x, pos.y, PanelMapa.TILE_WIDTH, PanelMapa.TILE_HIGHT);		
	}
	
	public void morir () {
		barraVida.setVisible(false);
		this.getParent().remove(barraVida);
		
		powerUp.setVisible(false);
		this.getParent().remove(powerUp);
		
		setIcon(image[1]);
		repaint();
		Juego.getJuego().getInterfaz().getPanelMapa().graficoTemporal(this, 7);
	}
	
}