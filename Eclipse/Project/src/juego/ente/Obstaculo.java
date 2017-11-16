package juego.ente;

import grafica.GraficoEnte;
import juego.ente.EfectoCelda.EfectoCelda;
import juego.visitor.Visitor;

/*
 * TODO: algunos obstaculos tienen que ser comprables
 */

public class Obstaculo extends Ente {
	
	public Obstaculo(int vida, String name) {
		super(vida);
		grafica = new GraficoEnte(this, name);
	}
	
	public void afectar(EfectoCelda e){
		e.aplicar(this);
	}
	
	public void desafectar(EfectoCelda e){
		e.desaplicar(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
