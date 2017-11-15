package juego.visitor;

import juego.ente.Aliado;
import juego.ente.Celda;
import juego.ente.Enemigo;
import juego.ente.Ente;
import juego.ente.Obstaculo;
import grafica.GraficoDisparo;

//Ataques que realizan los enemigos
public class DisparoEnemigo implements Visitor {
	protected Enemigo enemigo;
	protected int rango;
	protected Celda celda;
	protected boolean ataco;
	
	public DisparoEnemigo(Enemigo e) {
		enemigo = e;
	}
	
	public void reset() {
		celda = enemigo.getCelda();
		rango = enemigo.getRango();
		ataco = false;
	}
	
	public void visit(Enemigo e) {
		Ente aux = buscarEnte();
		if (aux != null)
			aux.accept(this);
	}
	
	public void visit(Aliado a) {
		ataco = true;
		a.quitarVida(enemigo.getAtaque());
		enemigo.getGrafico().graficarDisparo(a, enemigo);
	}
	
	public void visit(Obstaculo o) {
		ataco = true;
		o.quitarVida(enemigo.getAtaque());
		enemigo.getGrafico().graficarDisparo(o, enemigo);
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
	
	public boolean ataco(){
		return ataco;
	}
}