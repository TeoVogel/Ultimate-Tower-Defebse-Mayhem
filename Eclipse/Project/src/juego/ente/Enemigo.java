package juego.ente;

import javax.swing.JLabel;

import grafica.GraficoEnemigo;
import juego.visitor.DisparoEnemigo;
import juego.visitor.Visitor;

public abstract class Enemigo extends Personaje {
	protected int velocidad;
	private int vel;
	
	public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad) {
		super(vida, celda, ataque, cadencia, rango);
		this.velocidad = velocidad;
		grafica = new GraficoEnemigo(this);
		
		celda.setEnte(this);
	}
	
	public JLabel getGrafico () {
		return grafica.getGrafico();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia) {
			cad--;
			v.reset();
			accept(v);
		} else cad = (cad+1)%(cadencia);
	}
	
	public void mover() {
		grafica.mover(); // TODO: DONDE VA ESTO??
		if (vel == velocidad) {
			Celda izq = celda.getIzq();
			if (izq == null) 
				System.out.println("MISSION FAILED");
			else 
				if (izq.getEnte() == null) {
					izq.setEnte(this);
					celda.setEnte(null);
					celda = izq;
				}
		} else {
			vel = (vel+1)%(velocidad);
		}
	}	
	
	public int getVelocidad() {
		return velocidad;
	}
}
