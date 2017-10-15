package juego.ente;

import juego.visitor.DisparoAliado;
import juego.visitor.Visitor;

public abstract class Aliado extends Personaje{
	
	public Aliado(int vida, Celda celda, int ataque, int cadencia, int rango) {
		super(vida, celda, ataque, cadencia, rango);
		v = new DisparoAliado(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia) {
			cad--;
			v.reset();
			accept(v);
		} else cad = (cad-1)%(cadencia+1);
	}
}
