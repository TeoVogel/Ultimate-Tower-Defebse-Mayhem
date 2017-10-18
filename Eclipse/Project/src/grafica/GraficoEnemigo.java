package grafica;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import juego.ente.Celda;
import juego.ente.Enemigo;



public class GraficoEnemigo extends Grafico {
	
	private Enemigo enemigo;
	
	public GraficoEnemigo (Enemigo e, String name) {
		super(e, name);
		
		enemigo = e;

		this.image = new Icon[4];
		this.image[0] = new ImageIcon(path + archivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + archivos[1] + ".gif"); //en movimiento
	
		initGrafico();
	}
	
	
	public void mover() {
		Celda izq = enemigo.getCelda().getIzq();
		if (izq != null && izq.getEnte() != null) {
			int velocidad = enemigo.getVelocidad();
			int delta = 100 / velocidad;
			pos.setLocation(pos.x - delta, pos.y);
			cambiarGrafico(1);
			System.out.println("Moviendose");
		} else {
			cambiarGrafico(0);
			System.out.println("Parado");
		}
	}
	
}