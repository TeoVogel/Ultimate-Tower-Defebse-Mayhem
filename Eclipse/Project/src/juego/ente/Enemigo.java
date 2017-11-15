package juego.ente;

import grafica.GraficoEnemigo;
import juego.Juego;
import juego.ente.EfectoCelda.EfectoCelda;
import juego.visitor.DisparoEnemigo;
import juego.visitor.Visitor;

public class Enemigo extends Personaje {
	
	protected int velocidad, vel;
	
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
	
	public void mover() {
		((GraficoEnemigo)grafica).mover();
		if (vel == velocidad-1) {
			Celda izq = celda.getIzq();
			if (izq == null) {
				System.out.println("MISSION FAILED");
				Juego.getJuego().perder();
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
	
	public void afectar(EfectoCelda e){
		e.aplicar(this);
	}
	
	public void desafectar(EfectoCelda e){
		e.desaplicar(this);
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int v){
		velocidad=v;
	}
}
