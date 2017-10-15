package juego.ente;

import juego.visitor.DisparoAliado;
import juego.visitor.Visitor;

public abstract class Aliado extends Personaje{
	
	public Aliado(int v, Celda cell, int a, int c, int r) {
		super(v, cell, a, c, r);
		v = new DisparoAliado(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia) {
			cad--;
			Visitor v = new DisparoAliado(celda);
			accept(v);
		} else cad = (cad-1)%(cadencia+1);
	}
}
