package grafica;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Enemigo;

public class GraficoEnemigo extends Grafico {
	
	private Enemigo enemigo;
	
	public GraficoEnemigo (Enemigo e) {
		super(calcularX(e), calcularY(e));
		
		enemigo = e;

		this.image = new Icon[4];
		this.image[0] = new ImageIcon("assets/e1.gif");
		this.image[1] = new ImageIcon("assets/e2.gif");
		//this.image[2] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		
	}
	
	private static int calcularX (Enemigo e) {
		return e.getCelda().getFila() * 100;
	}
	
	private static int calcularY (Enemigo e) {
		return e.getCelda().getColumna() * 100;
	}
	
	public void mover () {
		if (enemigo.getCelda().getIzq().getEnte() != null) {
			int velocidad = enemigo.getVelocidad();
			int delta = 100 / velocidad;
			pos.setLocation(pos.x - delta, pos.y);
			cambiarGrafico(1);
		} else 
			cambiarGrafico(0);
	}
	
}