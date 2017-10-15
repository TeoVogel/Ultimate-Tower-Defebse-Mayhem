package vistor;

import ente.Aliado;
import ente.Celda;
import ente.Enemigo;
import ente.Ente;
import ente.Obstaculo;

//Ataques que realizan los enemigos
public class AtaqueEnemigo implements Visitor{
	protected int ataque, rango;
	protected Celda celda;
	
	public AtaqueEnemigo(Celda c) {
		Enemigo e = (Enemigo) c.getEnte();
		rango = e.getRango();
		ataque = e.getAtaque();
		celda = c;
	}
	
	public void visit(Enemigo e) {
		Ente aux = buscarEnte();
		if (aux != null)
			aux.accept(this);
	}
	
	public void visit(Aliado a) {
		a.quitarVida(ataque);
	}
	
	public void visit(Obstaculo o) {
		o.quitarVida(ataque);
	}
	
	//Busca la primer celda (a la izquierda) que contenga un ente dentro del rango de ataque
	private Ente buscarEnte() {
		Ente e = null;
		do {
			rango--;
			celda = celda.getIzq();
			if (celda != null)
				e = celda.getEnte();
		} while (rango > 0 && celda != null && e == null);
		return e;
	}
}
