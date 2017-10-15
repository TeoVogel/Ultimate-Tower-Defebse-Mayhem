package juego.ente;

import grafica.GraficoEnemigo;
import juego.visitor.AtaqueEnemigo;
import juego.visitor.Visitor;

public abstract class Enemigo extends Personaje {
	protected int velocidad;
	private int vel;
	
	public Enemigo (int v, Celda cel, int a, int c, int rango, int velocidad) {
		super(v, cel, a, c);
		this.velocidad = velocidad;
		grafico = new GraficoEnemigo(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia) {
			cad--;
			Visitor v = new AtaqueEnemigo(celda);
			accept(v);
		} else cad = (cad+1)%(cadencia);
	}
	
	public void mover() {
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
		} else vel = (vel+1)%(velocidad);
	}	
	
	public int getVelocidad() {
		return velocidad;
	}
}
