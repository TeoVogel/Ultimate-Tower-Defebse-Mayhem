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

public class GraficoBomba extends JLabel implements Grafico {
	
	protected Point pos;
	
	public GraficoBomba(int fila, int columna) {
		pos = new Point(columna*100 - 50, fila*100 - 50);
		setIcon(new ImageIcon(Interfaz.path + "bomba.gif"));
		setBounds(pos.x, pos.y, 200, 200);
		Juego.getJuego().getInterfaz().getPanelMapa().add(this);
		
		repaint();
	}
	
	public void action() {
		setVisible(false);
		repaint();
		Juego.getJuego().getInterfaz().getPanelMapa().remove(this);
	}
	
	public Point getPos() {
		return pos;
	}	
	
}