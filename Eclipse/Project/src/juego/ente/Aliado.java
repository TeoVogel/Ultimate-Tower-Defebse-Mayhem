package juego.ente;

import javax.swing.JLabel;
import juego.visitor.DisparoAliado;
import juego.visitor.Visitor;
import grafica.Grafico;
import grafica.GraficoAliado;

public abstract class Aliado extends Personaje{
	protected GraficoAliado miGrafico;
	
	// TODO: Este lo volamos
	public Aliado(int vida, Celda celda, int ataque, int cadencia, int rango) {
		super(vida, celda, ataque, cadencia, rango);
		v = new DisparoAliado(this);
	}

	public Aliado(int vida, int ataque, int cadencia, int rango) {
		super(vida, ataque, cadencia, rango);
		v = new DisparoAliado(this);
	}
	
	public Grafico getGrafico() {
		return miGrafico;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void atacar() {
		if (cad == cadencia-1) {
			cad--;
			v.reset();
			accept(v);
		} else cad = (cad-1)%(cadencia+1);
	}
}
