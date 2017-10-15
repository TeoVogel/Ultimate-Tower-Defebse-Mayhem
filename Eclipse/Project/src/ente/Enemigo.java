package ente;

import vistor.AtaqueEnemigo;
import vistor.Visitor;

public abstract class Enemigo extends Personaje{
	protected int velocidad;
	private int vel;
	
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
