package juego.ente;

import juego.visitor.Visitor;

public abstract class Ente {
	protected int vida;
//	protected JLabel grafico;
//	protected Icon[] imagen;
	protected Celda celda;
	
	public Ente(int v) {
		vida = v;
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
