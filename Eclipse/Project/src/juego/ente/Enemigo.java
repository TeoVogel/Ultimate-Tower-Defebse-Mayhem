package juego.ente;

import grafica.Grafico;
import grafica.GraficoEnemigo;
import juego.visitor.DisparoEnemigo;
import juego.visitor.Visitor;

public class Enemigo extends Personaje {
	
	protected int velocidad, vel;
	
	public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad, String name) {
		super(vida, celda, ataque, cadencia, rango);
		this.velocidad = velocidad;
		vel = 0;
		grafica = new GraficoEnemigo(this, name);
		celda.setEnte(this);
		v = new DisparoEnemigo(this);
	}
	
	public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad, String name) {
		super(vida, ataque, cadencia, rango);
		this.velocidad = velocidad;
		vel = 0;
		grafica = new GraficoEnemigo(this, name);
		v = new DisparoEnemigo(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia-1) { // Cad se resetea en el visitor si el ataque fue exitoso
			v.reset();
			accept(v);
		} else cad = (cad+1)%(cadencia);
	}
	
	public void mover() {
		((GraficoEnemigo)grafica).mover(); // TODO: DONDE VA ESTO??
		if (vel == velocidad-1) {
			Celda izq = celda.getIzq();
			if (izq == null) {
				System.out.println("MISSION FAILED"); // TODO: detectar cuando perdes el juego.
			} else {
				if (izq.getEnte() == null) {
					izq.setEnte(this);
					celda.setEnte(null);
					celda = izq;
					vel = 0;
					grafica.centrar();
				}
			}
		} else {
			vel = (vel+1)%(velocidad);
		}
	}	
	
	public int getVelocidad() {
		return velocidad;
	}
}
