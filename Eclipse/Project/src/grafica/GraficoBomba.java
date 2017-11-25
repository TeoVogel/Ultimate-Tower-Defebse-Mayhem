	package grafica;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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