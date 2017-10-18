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
	
	private String [] archivos = {"e1", "e2","e3","e4","e5"};
	
	public GraficoEnemigo (Enemigo e) {
		super(e);
		
		enemigo = e;

		this.image = new Icon[4];
		this.image[0] = new ImageIcon(path + archivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + archivos[1] + ".gif"); //en movimiento
	
		initGrafico();
	}
	
	
	public void mover () {
		Celda izq = enemigo.getCelda().getIzq();
		if (izq != null && izq.getEnte() != null) {
			int velocidad = enemigo.getVelocidad();
			int delta = 100 / velocidad;
			pos.setLocation(pos.x - delta, pos.y);
			cambiarGrafico(1);
		} else
			cambiarGrafico(0);
	}
	
}