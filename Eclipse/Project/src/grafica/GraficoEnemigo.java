package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juego.ente.Celda;
import juego.ente.Enemigo;


public class GraficoEnemigo extends Grafico implements Movible {
	
	private Enemigo enemigo;
	
	private String [] archivos = {"e1", "e2"};
	
	public GraficoEnemigo (Enemigo e) {		
		enemigo = e;

		this.image = new Icon[4];
		this.image[0] = new ImageIcon(path + archivos[0] + ".gif"); //quieto
		this.image[1] = new ImageIcon(path + archivos[1] + ".gif"); //en movimiento

		//this.image[2] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //atacando
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif"); //muriendo
		
	}
	
	public void mover () {
		Celda cel = enemigo.getCelda();
		if (cel != null) { 
			Celda izq = cel.getIzq();
			if (izq != null && izq.getEnte() != null) {
				int velocidad = enemigo.getVelocidad();
				int delta = 100 / velocidad;
				pos.setLocation(pos.x - delta, pos.y);
				cambiarGrafico(1);
			} else
				cambiarGrafico(0);
		}
	}
	
}