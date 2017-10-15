package juego.ente;
import juego.visitor.*;

public abstract class Personaje extends Ente{
	protected int ataque;
	protected int rango;
	protected int cadencia, cad;
	protected Visitor v;
	protected EfectoPersonaje efecto;
	
	public Personaje(int v, Celda cell, int a, int c, int r) {
		super(v, cell);
		ataque = a;
		cadencia = c;
		rango = r;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public int getRango() {
		return rango;
	}
	
	public int getCadencia() {
		return cadencia;
	}
	
	public EfectoPersonaje getEfecto() {
		return efecto;
	}
	
	public abstract void atacar();
}
