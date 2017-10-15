package juego.ente;

import grafica.Grafico;
import juego.visitor.Visitor;

public abstract class Ente {
	protected int vida;
	protected Grafico grafico;
	protected Celda celda;
	
	//public 
	
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
