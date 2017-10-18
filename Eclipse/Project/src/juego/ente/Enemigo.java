package juego.ente;


import javax.swing.JLabel;
import grafica.Grafico;
import grafica.GraficoEnemigo;
import juego.visitor.DisparoEnemigo;
import juego.visitor.Visitor;

public class Enemigo extends Personaje {
	protected int velocidad, vel;
	protected GraficoEnemigo miGrafico;
	
	public Enemigo (int vida, Celda celda, int ataque, int cadencia, int rango, int velocidad, String name) {
		super(vida, celda, ataque, cadencia, rango);
		this.velocidad = velocidad;
		vel = 0;
		miGrafico = new GraficoEnemigo(this, name);
		celda.setEnte(this);
	}
	
	public Enemigo (int vida, int ataque, int cadencia, int rango, int velocidad, String name) {
		super(vida, ataque, cadencia, rango);
		this.velocidad = velocidad;
		vel = 0;
		miGrafico = new GraficoEnemigo(this, name);
	}
	
	public Grafico getGrafico () {
		return miGrafico;
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
		miGrafico.mover(); // TODO: DONDE VA ESTO??
		if (vel == velocidad-1) {
			Celda izq = celda.getIzq();
			if (izq == null) 
				System.out.println("MISSION FAILED"); // TODO: detectar cuando perdes el juego.
			else 
				if (izq.getEnte() == null) {
					izq.setEnte(this);
					celda.setEnte(null);
					celda = izq;
					vel = 0;
				}
		} else {
			vel = (vel+1)%(velocidad);
		}
		System.out.println("vel: " + vel + " columna: " + celda.columna);
	}	
	
	public int getVelocidad() {
		return velocidad;
	}
}
