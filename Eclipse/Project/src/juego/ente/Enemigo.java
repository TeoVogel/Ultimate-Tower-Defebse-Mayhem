package juego.ente;

import java.util.Random;

import grafica.GraficoEnemigo;
import juego.Juego;
import juego.acciones.DropPowerUp;
import juego.acciones.DropEfectoCelda;
import juego.ente.EfectoCelda.EfectoCelda;
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
	
	public void mover() {
		((GraficoEnemigo)grafica).mover();
		if (vel == velocidad-1) {
			Celda izq = celda.getIzq();
			if (izq == null) {
				System.out.println("MISSION FAILED");
				Juego.getJuego().perder();
			} else {
				if (izq.getEnte() == null){
					izq.setEnte(this);
					celda.RemoveEnte();
					celda = izq;
					vel = 0;
					grafica.centrar();
				}
			}
		} else {
			vel = (vel+1)%(velocidad);
		}
	}	
	
	public void afectar(EfectoCelda e) {
		e.aplicar(this);
	}
	
	public void desafectar(EfectoCelda e) {
		e.desaplicar(this);
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public void quitarVida(int cant) {
		vida -= cant;
		grafica.actualizarVida();
		if (vida <= 0) {
			estado = new EstadoEnteMorir();
			grafica.morir();
			dropea();
			celda.setEnte(null);
			celda = null;
		}
	}
	
	private void dropea(){
		Random random= new Random();
		int x= celda.fila * 100;
		int y= celda.columna * 100;
		int tipo= random.nextInt(7);
		if(tipo < 5){
			new DropPowerUp(x, y, tipo);
		}else if(tipo < 7){
			new DropEfectoCelda(x, y, tipo-5);
		}
	}
	
	public int getMonedas () {
		Random r = new Random();
		int m = r.nextInt(20);
		return monedas - 10 + m;
	}
	
	public GraficoEnemigo getGrafico() {
		return (GraficoEnemigo) grafica;
	}
}
