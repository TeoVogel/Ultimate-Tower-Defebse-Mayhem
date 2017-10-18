package juego.ente;

import grafica.Grafico;
import javax.swing.JLabel;
import juego.visitor.Visitor;

public abstract class Ente {
	protected int vida;
	protected Celda celda;
	// TODO: Ente deberia tener Grafico?
	
	public Ente(int vida, Celda celda) {
		this.vida = vida;
		this.celda = celda;
	}
	
	public Ente(int vida) {
		this.vida = vida;
	}
	
	public void setCelda(Celda celda){
		this.celda = celda;
	}
	
	public int getVida(){
		return vida;
	}
	
	public abstract Grafico getGrafico();
	
	public Celda getCelda() {
		return celda;
	}
	
	public abstract void accept(Visitor v);
	
	public void quitarVida(int cant) {
		vida -= cant;
		if (vida <= 0) {
			// TODO: Matar bien al chabon, probablemente haya que redefinir
			celda.setEnte(null);
			celda = null;
		}
	}
	
}
