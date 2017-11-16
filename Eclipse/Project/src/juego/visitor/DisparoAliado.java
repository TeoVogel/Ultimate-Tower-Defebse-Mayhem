package juego.visitor;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.Obstaculo;
import grafica.GraficoDisparo;

//Ataques que realizan los aliados
public class DisparoAliado implements Visitor{
	protected Aliado aliado;
	protected int rango;
	protected Celda celda;
	protected boolean ataco;
	
	public DisparoAliado(Aliado a) {
		aliado = a;
	}
	
	public void reset() {
		rango = aliado.getRango();
		celda = aliado.getCelda();
		ataco = false;
	}
	
	public void visit(Enemigo e) {
		ataco = true;
		e.quitarVida(aliado.getAtaque());
		aliado.getGrafico().graficarDisparo(aliado, e);
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
	
	public boolean ataco(){
		return ataco;
	}
}
