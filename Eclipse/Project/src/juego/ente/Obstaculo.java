package juego.ente;

import grafica.GraficoEnte;
import juego.ente.EfectoCelda.EfectoCelda;
import juego.visitor.Visitor;

/*
 * TODO: algunos obstaculos tienen que ser comprables
 */

public class Obstaculo extends Ente {
	
	public Obstaculo(int vida) {
		super(vida);
		grafica = new GraficoEnte(this, "a2");
	}
	
	public void afectar(EfectoCelda e){
		e.aplicar(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
