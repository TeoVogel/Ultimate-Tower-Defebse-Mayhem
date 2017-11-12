package juego.ente;

import java.util.Random;

import grafica.GraficoEnemigo;
import juego.Juego;
import juego.visitor.DisparoEnemigo;
import juego.visitor.Visitor;

public class Enemigo extends Personaje {
	
	protected int velocidad, vel;
	protected int monedas;
	
	public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad, String name, int monedas) {
		super(vida, ataque, cadencia, rango);
		this.velocidad = velocidad;
		this.monedas = monedas;
		vel = 0;
		grafica = new GraficoEnemigo(this, name);
		v = new DisparoEnemigo(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		super.atacar();
		if (cad == cadencia-1) { // Cad se resetea en el visitor si el ataque fue exitoso
			v.reset();
			accept(v);
		} else cad = (cad+1)%(cadencia); 
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
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int getMonedas () {
		Random r = new Random();
		int m = r.nextInt(20);
		return monedas - 10 + m;
	}
}
