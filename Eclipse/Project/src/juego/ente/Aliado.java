package juego.ente;

import juego.ente.EfectoCelda.EfectoCelda;
import juego.visitor.DisparoAliado;
import juego.visitor.Visitor;
import grafica.GraficoAliado;
import grafica.GraficoEnte;

public class Aliado extends Personaje implements Comprable {
	
	protected int precio;

	public Aliado(int vida, int ataque, int cadencia, int rango, int precio, String name) {
		super(vida, ataque, cadencia, rango);
		this.precio = precio;
		grafica = new GraficoAliado(this, name);
		v = new DisparoAliado(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void afectar(EfectoCelda e) {
		e.aplicar(this);
	}
	
	public void desafectar(EfectoCelda e) {
		e.desaplicar(this);
	}
	
	public int getPrecio() {
		return precio;
	}
}
