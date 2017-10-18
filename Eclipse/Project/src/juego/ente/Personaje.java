package juego.ente;
import juego.visitor.*;

public abstract class Personaje extends Ente{
	protected int ataque;
	protected int rango;
	protected int cadencia, cad;
	protected Visitor v;
	protected EfectoPersonaje efecto;
	
	
	public Personaje(int vida, Celda celda, int ataque, int cadencia, int rango) {
		super(vida, celda);
		this.ataque = ataque;
		this.cadencia = cadencia;
		cad = 0;
		this.rango = rango;
	}
	
	public Personaje(int vida, int ataque, int cadencia, int rango) {
		super(vida);
		this.ataque = ataque;
		this.cadencia = cadencia;
		cad = 0;
		this.rango = rango;
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
	
	public void setCad(int c) {
		cad = c;
	}
	
	public EfectoPersonaje getEfecto() {
		return efecto;
	}
	
	public abstract void atacar();
}
