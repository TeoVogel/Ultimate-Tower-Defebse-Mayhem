package ente;

import visitor.AtaqueAliado;
import visitor.Visitor;

public abstract class Aliado extends Personaje{
	
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia) {
			cad--;
			Visitor v = new AtaqueAliado(celda);
			accept(v);
		} else cad = (cad-1)%(cadencia+1);
	}
}
