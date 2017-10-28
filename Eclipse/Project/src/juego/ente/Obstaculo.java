package juego.ente;

import grafica.GraficoEnte;
import juego.visitor.Visitor;

/*
 * TODO: algunos obstaculos tienen que ser comprables
 */

public class Obstaculo extends Ente {
	
	public Obstaculo(int vida) {
		super(vida);
		grafica = new GraficoEnte(this, "a3");
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub		
	}
	
}
