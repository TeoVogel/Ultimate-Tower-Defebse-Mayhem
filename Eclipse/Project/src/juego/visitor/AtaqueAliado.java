package juego.visitor;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.Obstaculo;

//Ataques que realizan los aliados
public class AtaqueAliado implements Visitor{
	protected int ataque, rango;
	protected Celda celda;
	
	public AtaqueAliado(Celda c) {
		Aliado a = (Aliado) c.getEnte();
		ataque = a.getAtaque();
		rango = a.getRango();
		celda = c;
	}
	
	public void visit(Enemigo e) {
		e.quitarVida(ataque);
	}
	
	public void visit(Aliado a) {
		Ente aux = buscarEnte();
		if (aux != null)
			aux.accept(this);
	}
	
	public void visit(Obstaculo o) {
		Ente aux = buscarEnte();
		if (aux != null)
			aux.accept(this);
	}
	
	//Busca la primer celda (a la derecha) que contenga un ente dentro del rango de ataque
	private Ente buscarEnte() {
		Ente e = null;
		do {
			rango--;
			celda = celda.getDer();
			if (celda != null)
				e = celda.getEnte();
		} while (rango > 0 && celda != null && e == null);
		return e;
	}
}
