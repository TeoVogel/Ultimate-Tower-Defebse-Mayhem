package juego.ente;

import grafica.Grafico;
import juego.visitor.Visitor;

public abstract class Ente {
	
	protected int vida;
	protected Celda celda;
	protected Grafico grafica;
	
	// Este lo volamos en lo posible
	public Ente(int v, Celda c) {
		vida = v;
		celda = c;
	}
	
	public Ente(int vida) {
		this.vida = vida;
	}
	
	public void init (Celda c) {
		celda = c;
		grafica.initGrafico(c);
	}
	
	public void setCelda(Celda celda) {
		this.celda = celda;
	}
	
	public int getVida(){
		return vida;
	}
	
	public Celda getCelda() {
		return celda;
	}
	
	public abstract void accept(Visitor v);
	
	public void quitarVida(int cant) {
		vida -= cant;
		if (vida <= 0) {
			celda.setEnte(null);
			celda = null;
		}
	}
	
}
