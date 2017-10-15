package ente;

import vistor.Visitor;

public abstract class Ente {
	protected int vida;
//	protected JLabel grafico;
//	protected Icon[] imagen;
	protected Celda celda;
	
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
