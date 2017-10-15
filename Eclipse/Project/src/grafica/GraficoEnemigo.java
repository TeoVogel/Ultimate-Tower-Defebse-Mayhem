package grafica;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tmp.Enemigo;

public class GraficoEnemigo extends Grafico {
	
	private Enemigo enemigo;
	
	public GraficoEnemigo (Enemigo e) {
		super(calcularX(e), calcularY(e));
		
		enemigo = e;
		
		//this.image[0] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		//this.image[1] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		this.image[2] = new ImageIcon("C://Users//teo//Documents//TDP//Ultimate-Tower-Defense-Mayhem//Eclipse//Project//src//Grafica/e2.gif");
		//this.image[3] = new ImageIcon("C:/Users/Franco/Documents/e2.gif");
		
	}
	
	private static int calcularX (Enemigo e) {
		return e.getCelda().getFila() * 100;
	}
	
	private static int calcularY (Enemigo e) {
		return e.getCelda().getColumna() * 100;
	}
	
}